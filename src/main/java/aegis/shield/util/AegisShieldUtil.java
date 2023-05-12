/**
 * 
 */
package aegis.shield.util;


import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import aegis.shield.security.service.UserDetailsImpl;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:45:34 - 12/05/2023
 *
 */
public final class AegisShieldUtil {

	private AegisShieldUtil() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Método que permite recuperar los datos del usuario obtenidos del SecurityContext
	 * @return
	 */
	public Optional<UserDetailsImpl> getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetail = authentication != null ? (UserDetailsImpl) authentication.getPrincipal() : null;
		return Optional.ofNullable(userDetail);
	}
}
