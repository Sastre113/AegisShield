/**
 * 
 */
package aegis.shield.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.model.entity.Usertb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:55:43 - 30/04/2023
 *
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

	public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mapping(source = "username", target = "username")
	@Mapping(source = "name", target = "name")
	public UserDTO toDTO(Usertb userEntity);
	
	@Mapping(source = "username", target = "username")
	@Mapping(source = "name", target = "name")
	public Usertb toEntity(UserDTO userDTO);

	@Mapping(source = "username", target = "username")
	@Mapping(source = "password", target = "password")
	@Mapping(source = "name", target = "name")
	public Usertb toEntity(RequestCreateUserDTO requestDTO);
}
