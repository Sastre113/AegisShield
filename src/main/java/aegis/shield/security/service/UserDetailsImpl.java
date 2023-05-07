/**
 * 
 */
package aegis.shield.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import aegis.shield.model.entity.Usertb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 3:10:59 - 01/05/2023
 *
 */
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String username;
	@JsonIgnore
	private String password;
	private String name;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String username, String password, Collection<? extends GrantedAuthority> authorities ) {
	    this.username = username;
	    this.password = password;
	    this.authorities = authorities;
	}

	public static UserDetailsImpl build(Usertb userEntity) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		userEntity.getSetRol().forEach(rolEntity -> authorities.add(new SimpleGrantedAuthority(rolEntity.getRol())));

		return new UserDetailsImpl(userEntity.getUsername(), userEntity.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(this.username, user.username);
	}
}