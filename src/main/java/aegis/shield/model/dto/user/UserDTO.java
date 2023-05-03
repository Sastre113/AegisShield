/**
 * 
 */
package aegis.shield.model.dto.user;

import java.util.Set;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:53:42 - 30/04/2023
 *
 */
public class UserDTO {

	private String username;
	private String name;
	private Set<RolDTO> setRol;

	public Set<RolDTO> getSetRol() {
		return setRol;
	}

	public void setSetRol(Set<RolDTO> setRol) {
		this.setRol = setRol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
