/**
 * 
 */
package aegis.shield.service;

import aegis.shield.model.dto.user.UserDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:49:37 - 09/05/2023
 *
 */
public interface IConcurrentService {

	public int doSomething();
	public UserDTO doSomethingUser(UserDTO request);

}
