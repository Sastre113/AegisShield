/**
 * 
 */
package aegis.shield.model.dto.auth;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 3:38:02 - 01/05/2023
 *
 */
public class LoginRequest {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
