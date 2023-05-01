/**
 * 
 */
package aegis.shield.security.jwt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 2:47:44 - 01/05/2023
 * 
 * Implementación de la interfaz {@link org.springframework.security.web.AuthenticationEntryPoint} que maneja 
 * 	las excepciones de autenticación en el proceso de autenticación de Spring Security.
 *
 * <p>Esta clase se utiliza para manejar las excepciones de autenticación que se producen durante el proceso 
 * 	de autenticación de Spring Security. Se encarga de responder a las solicitudes no autenticadas y devolver 
 * 	un código de estado HTTP 401 (Unauthorized) y un mensaje de error en formato JSON.</p>
 *
 * <p>La clase se utiliza en conjunto con el {@link aegis.shield.security.jwt.JwtAuthenticationFilter} y
 * 	 el {@link aegis.shield.security.jwt.JwtTokenProvider} para implementar la autenticación basada en JWT.</p>
 */
@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized error: {}", authException.getMessage());

		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final Map<String, Object> body = new HashMap<>();
		body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
		body.put("error", "Unauthorized");
		body.put("message", authException.getMessage());
		body.put("path", request.getServletPath());

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), body);
	}

}
