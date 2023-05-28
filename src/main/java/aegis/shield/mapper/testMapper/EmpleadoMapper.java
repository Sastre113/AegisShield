/**
 * 
 */
package aegis.shield.mapper.testMapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.EmpleadosDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.EmployeeFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:45:11 - 27/05/2023
 *
 */
@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "years", target = "edad")
    EmpleadosDTO toDTO(EmployeeFakeEntity empleado);
    /*
    @Named("mapEmpleados")
    EmpleadosDTO mapEmpleados(EmployeeFakeEntity empleados);
    */
}