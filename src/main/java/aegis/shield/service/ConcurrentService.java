/**
 * 
 */
package aegis.shield.service;

import org.springframework.stereotype.Service;

import aegis.shield.model.dto.user.UserDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:50:37 - 09/05/2023
 *
 */
@Service
public class ConcurrentService implements IConcurrentService {

	private int localInCocurrentService = 0;
	private UserDTO user = new UserDTO();
	
	@Override
	public int doSomething() {
		int localInDoSomething = 0;
		localInCocurrentService++;
		localInDoSomething++;
		System.out.println("Variable local de clase: " + localInCocurrentService);
		System.out.println("Variable local de método: " + localInDoSomething);
		return this.localInCocurrentService;
	}
	
	
	public UserDTO doSomethingUser(UserDTO request) {
		user.setUsername(request.getUsername());
		user.setName(request.getName());
		return user;
	}

}
