/**
 * 
 */
package aegis.shield.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import aegis.shield.security.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 2:12:49 - 01/05/2023
 * 
 * Clase que proporciona un filtro de autenticación que intercepta y valida las solicitudes de autenticación de tokens JWT.
 * Si la autenticación es exitosa, establece la autenticación en el contexto de seguridad de Spring.
 * 
 * Esta clase depende de un JwtTokenProvider para validar y decodificar los tokens JWT y un UserDetailsService para cargar
 * los detalles de usuario de la base de datos.
 * 
 * <p>La clase se utiliza en conjunto con el {@link aegis.shield.security.jwt.JwtTokenProvider} y el {@link aegis.shield.security.UserDetailsServiceImpl}
 * para implementar la autenticación basada en JWT.</p>
 * 
 * @see aegis.shield.security.jwt.JwtTokenProvider
 * 
 * @see aegis.shield.security.UserDetailsServiceImpl
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = this.parseJwt(request);
			if (jwt != null && jwtTokenProvider.validateJwtToken(jwt)) {
				String username = jwtTokenProvider.getUserNameFromJwtToken(jwt);

				UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
