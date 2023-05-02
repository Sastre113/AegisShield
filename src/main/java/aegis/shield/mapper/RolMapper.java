/**
 * 
 */
package aegis.shield.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.user.RolDTO;
import aegis.shield.model.entity.Roltb;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:13:14 - 02/05/2023
 *
 */
@Mapper(componentModel = "spring")
public interface RolMapper {

	public RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);
	
	@Mapping(source = "idRol", target = "idRol")
	@Mapping(source = "rol", target = "rol")
	public RolDTO toDTO(Roltb rolEntity);
	
	@Mapping(source = "idRol", target = "idRol")
	@Mapping(source = "rol", target = "rol")
	public Roltb toEntity(RolDTO rolDTO);
}
