/**
 * 
 */
package aegis.shield.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aegis.shield.model.entity.Usertb;
import aegis.shield.repository.UserRepository;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 3:07:32 - 01/05/2023
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usertb userEntity = this.userRepository.findById(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(userEntity);
	}

}
