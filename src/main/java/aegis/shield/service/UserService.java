/**
 * 
 */
package aegis.shield.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import aegis.shield.event.historical.HistoricalRecordEventPublisher;
import aegis.shield.mapper.UserMapper;
import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.RolDTO;
import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.model.entity.Roltb;
import aegis.shield.model.entity.Usertb;
import aegis.shield.repository.IRolRepository;
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
	private IRolRepository rolRepository;
	private HistoricalRecordEventPublisher eventPublisher;
	
	public UserService(IUserRepository userRepository,  IRolRepository rolRepository, HistoricalRecordEventPublisher eventPublisher) {
		super();
		this.userRepository = userRepository;
		this.eventPublisher = eventPublisher;
		this.rolRepository = rolRepository;
	}
	
	@Override
	public UserDTO createUser(RequestCreateUserDTO requestDTO) {
		Usertb userEntity = UserMapper.INSTANCE.toEntity(requestDTO);
		Set<Roltb> setRolEntity = new HashSet<>();
		userEntity.setSetRol(setRolEntity);
		Roltb rolEntity = this.rolRepository.findByRol("ROLE_USER")
			.orElseThrow(() -> new RuntimeException("Role not found!"));
		setRolEntity.add(rolEntity);
		this.userRepository.save(userEntity);
		this.eventPublisher.postEvent("USERTB","CREATE", null);
		return UserMapper.INSTANCE.toDTO(userEntity); 
	}
	
	@Override
	public UserDTO getUser(String idUser) {
		Usertb userEntity = this.userRepository.findById(idUser).orElseThrow();
		return UserMapper.INSTANCE.toDTO(userEntity);
	}
	
	@Override
	public Set<RolDTO> getUserRol(String idUser) {
		Usertb userEntity = this.userRepository.findById(idUser).orElseThrow();
		return UserMapper.INSTANCE.mapToSetRolDTO(userEntity.getSetRol());	
	}
	
	@Override
	public List<UserDTO> getAllUser() {
		List<Usertb> listUserEntity = this.userRepository.findAll();
		List<UserDTO> listUserDTO = new ArrayList<>();
		
		if(!listUserEntity.isEmpty()) {
			listUserEntity.forEach(userEntity -> listUserDTO.add(UserMapper.INSTANCE.toDTO(userEntity)));			
		}
		
		return listUserDTO;
	}

	@Override
	public void deleteUser(String idUser) {
		this.eventPublisher.postEvent("USERTB","DELETE", this.userRepository.findById(idUser).orElseThrow());
		this.userRepository.deleteById(idUser);
	}
}