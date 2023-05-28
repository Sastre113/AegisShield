/**
 * 
 */
package aegis.shield.mapper.testMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.EmpleadosDTO;
import aegis.shield.model.dto.testMapper.EmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.EmployeeFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.EmpresaFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 18:04:28 - 27/05/2023
 *
 */
@Mapper(componentModel = "spring")
public interface EmpresaSoloMapper {
    EmpresaSoloMapper INSTANCE = Mappers.getMapper(EmpresaSoloMapper.class);
    
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "addres", target = "datosEmpresa.direccion")
    @Mapping(target = "empleados", source = "listEmployee", qualifiedByName = "mapEmployees")
    @Mapping(target = "datosEmpresa.puestos", source = "job", qualifiedByName = "mapPuestos")
    EmpresaDTO toDTO(EmpresaFakeEntity empresa);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "years", target = "edad")
    EmpleadosDTO toDTO(EmployeeFakeEntity empleado);
    
    @Named("mapEmployees")
    default List<EmpleadosDTO> mapEmployees(List<EmployeeFakeEntity> employees) {
        return employees.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
    
    @Named("mapPuestos")
    default List<String> mapPuestos(List<JobFakeEntity> jobs) {
        return jobs.stream()
                .map(JobFakeEntity::getName)
                .collect(Collectors.toList());
    }
}





