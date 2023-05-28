/**
 * 
 */
package aegis.shield.mapper.testMapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.EmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.EmpresaFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:44:59 - 27/05/2023
 *
 */
@Mapper(injectionStrategy =  InjectionStrategy.CONSTRUCTOR, uses = {EmpleadoMapper.class, DatosEmpresaMapper.class})
public interface EmpresaMapper {
	
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "empresaEntity", target = "datosEmpresa")
    @Mapping(source = "listEmployee", target = "empleados")
    EmpresaDTO toDTO(EmpresaFakeEntity empresaEntity);
    
}






