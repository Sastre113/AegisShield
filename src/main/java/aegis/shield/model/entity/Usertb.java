/**
 * 
 */
package aegis.shield.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:38:54 - 30/04/2023
 *
 */
@Entity
@Table(name = "USERTB")
public class Usertb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;
	@Column(name = "PASSWORD", nullable = false, length = 500)
	private String password;
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USERROL"
		,joinColumns = @JoinColumn(name = "USERNAME")
		,inverseJoinColumns = @JoinColumn(name = "ID_ROL"))
	private Set<Roltb> setRol = new HashSet<>();

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

	public Set<Roltb> getSetRol() {
		return setRol;
	}

	public void setSetRol(Set<Roltb> setRol) {
		this.setRol = setRol;
	}
}