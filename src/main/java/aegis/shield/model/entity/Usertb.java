/**
 * 
 */
package aegis.shield.model.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:38:54 - 30/04/2023
 *
 */
@Entity
@Table(name = "USERTB")
public class Usertb {

	@Id
	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 500)
	private String password;
	@Column(name = "NAME", nullable = false, length = 100)
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