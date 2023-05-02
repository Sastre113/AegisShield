/**
 * 
 */
package aegis.shield.service;

import java.util.List;

import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.UserDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:46:44 - 30/04/2023
 *
 */
public interface IUserService {

	public UserDTO createUser(RequestCreateUserDTO requestDTO);
	public UserDTO getUser(String idUser);
	public List<UserDTO> getAllUser();
	public void deleteUser(String idUser);
}
