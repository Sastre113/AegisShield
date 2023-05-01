/**
 * 
 */
package aegis.shield.security.jwt;

import java.security.SignatureException;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import aegis.shield.security.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 2:33:29 - 01/05/2023
 * 
 * Clase que proporciona métodos para generar, validar y obtener información de los 
 * 	tokens JWT utilizados en el proceso de autenticación de Spring Security.
 *
 * <p>Esta clase se utiliza para generar tokens JWT que se utilizan para autenticar solicitudes HTTP. 
 * 	Además, proporciona métodos para validar los tokens y obtener información sobre los mismos, 
 * 	como el usuario autenticado o la fecha de caducidad.</p>
 *
 * <p>La clase se utiliza en conjunto con el {@link aegis.shield.security.jwt.JwtAuthenticationFilter} 
 * 	y el {@link aegis.shield.security.jwt.AuthEntryPointJwt} para implementar la autenticación basada en JWT.</p>
 */
@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	@Value("${aegis.shield.jwtSecret}")
	private String jwtSecret;

	@Value("${aegis.shield.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder().setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}