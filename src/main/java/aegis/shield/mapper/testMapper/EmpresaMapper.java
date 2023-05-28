/**
 * 
 */
package aegis.shield.mapper.testMapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.DatosEmpresaDTO;
import aegis.shield.model.dto.testMapper.EmpleadosDTO;
import aegis.shield.model.dto.testMapper.EmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.EmployeeFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.EmpresaFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:44:59 - 27/05/2023
 *
 */
@Mapper(componentModel = "spring", uses = {EmpleadoMapper.class, DatosEmpresaMapper.class})
public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "addres", target = "datosEmpresa.direccion")
    EmpresaDTO toDTO(EmpresaFakeEntity empresa);

 
}






