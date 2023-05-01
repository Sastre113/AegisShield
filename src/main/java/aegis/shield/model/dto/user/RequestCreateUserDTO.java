/**
 * 
 */
package aegis.shield.model.dto.user;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 1:27:19 - 01/05/2023
 *
 */
public class RequestCreateUserDTO {

	private String username;
	private String password;
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
