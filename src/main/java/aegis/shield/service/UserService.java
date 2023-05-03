/**
 * 
 */
package aegis.shield.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import aegis.shield.mapper.UserMapper;
import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.model.entity.Usertb;
import aegis.shield.repository.IUserRepository;
import jakarta.transaction.Transactional;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:38:28 - 30/04/2023
 *
 */
@Service
@Transactional
public class UserService implements IUserService {

	private IUserRepository userRepository;
	
	public UserService(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDTO createUser(RequestCreateUserDTO requestDTO) {
		Usertb userEntity = UserMapper.INSTANCE.toEntity(requestDTO);
		this.userRepository.save(userEntity);
		return UserMapper.INSTANCE.toDTO(userEntity); 
	}
	
	@Override
	public UserDTO getUser(String idUser) {
		Usertb userEntity = this.userRepository.findById(idUser).orElseThrow();
		return UserMapper.INSTANCE.toDTO(userEntity);
	}
	
	@Override
	public List<UserDTO> getAllUser() {
		List<Usertb> listUserEntity = this.userRepository.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		listUserEntity.forEach(userEntity -> listUserDTO.add(UserMapper.INSTANCE.toDTO(userEntity)));
		
		return listUserDTO;
	}

	@Override
	public void deleteUser(String idUser) {
		this.userRepository.deleteById(idUser);
	}
}