/**
 * 
 */
package aegis.shield.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.RolDTO;
import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.model.entity.Roltb;
import aegis.shield.model.entity.Usertb;


/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:55:43 - 30/04/2023
 *
 */
@Mapper(componentModel = "spring", uses = RolMapper.class)
public interface UserMapper {

	public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "username", target = "username")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "setRol", target = "setRol", qualifiedByName = "mapToSetRolDTO")
	public UserDTO toDTO(Usertb userEntity);

	@Mapping(source = "username", target = "username")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "setRol", target = "setRol", qualifiedByName = "mapToSetRolEntity")
	public Usertb toEntity(UserDTO userDTO);

	@Mapping(source = "username", target = "username")
	@Mapping(source = "password", target = "password")
	@Mapping(source = "name", target = "name")
	public Usertb toEntity(RequestCreateUserDTO requestDTO);
	
	@Named("mapToSetRolDTO")
	default Set<RolDTO> mapToSetRolDTO(Set<Roltb> setRolEntity){
		Set<RolDTO> setRolDTO = new HashSet<>();
		setRolEntity.forEach(rolEntity -> setRolDTO.add(RolMapper.INSTANCE.toDTO(rolEntity)));
		
		return setRolDTO;
	}
	
	@Named("mapToSetRolEntity")
	default Set<Roltb> mapToSetRolEntity(Set<RolDTO> setRolDTO){
		Set<Roltb> setRolEntity = new HashSet<>();
		setRolDTO.forEach(rolDTO -> setRolEntity.add(RolMapper.INSTANCE.toEntity(rolDTO)));
		
		return setRolEntity;
	}
}
