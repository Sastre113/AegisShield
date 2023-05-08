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
 * @version 0:09:26 - 09/05/2023
 *
 */
@Entity
@Table(name = "AUTHORITYTB")
public class Authoritytb implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_AUTHORITY", nullable = false, length = 20)
	private String idAuthority;
	@Column(name = "AUTHORITY", nullable = false, length = 100)
	private String authority;

	@ManyToMany(mappedBy = "setAuthority")
	private Set<Roltb> setRol = new HashSet<>();

	public String getIdAuthority() {
		return idAuthority;
	}

	public void setIdAuthority(String idAuthority) {
		this.idAuthority = idAuthority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Set<Roltb> getSetRol() {
		return setRol;
	}

	public void setSetRol(Set<Roltb> setRol) {
		this.setRol = setRol;
	}
}
