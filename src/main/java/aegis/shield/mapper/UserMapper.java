/**
 * 
 */
package aegis.shield.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.DatosEmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;
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
		
		if(!setRolEntity.isEmpty()) {
			setRolEntity.forEach(rolEntity -> setRolDTO.add(RolMapper.INSTANCE.toDTO(rolEntity)));			
		}
		
		return setRolDTO;
	}
	
	@Named("mapToSetRolEntity")
	default Set<Roltb> mapToSetRolEntity(Set<RolDTO> setRolDTO){
		Set<Roltb> setRolEntity = new HashSet<>();
		
		if(!setRolDTO.isEmpty()) {
			setRolDTO.forEach(rolDTO -> setRolEntity.add(RolMapper.INSTANCE.toEntity(rolDTO)));			
		}
		
		return setRolEntity;
	}
	
	default DatosEmpresaDTO mapDatosEmpresa(List<JobFakeEntity> jobs) {
        DatosEmpresaDTO datosEmpresaDTO = new DatosEmpresaDTO();
        List<String> puestos = jobs.stream()
                .map(JobFakeEntity::getName)
                .collect(Collectors.toList());
        datosEmpresaDTO.setPuestos(puestos);
        return datosEmpresaDTO;
    }
}
