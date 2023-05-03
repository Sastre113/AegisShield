/**
 * 
 */
package aegis.shield.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 17:11:13 - 01/05/2023
 *
 */
@Entity
@Table(name = "ROLTB")
public class Roltb implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_ROL", nullable = false, length = 36)
	private String idRol;
	@Column(name = "ROL", nullable = false, length = 100)
	private String rol;
	
	@ManyToMany(mappedBy = "setRol")
	private Set<Usertb> setUser = new HashSet<>();

	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Set<Usertb> getSetUser() {
		return setUser;
	}

	public void setSetUser(Set<Usertb> setUser) {
		this.setUser = setUser;
	}
}
