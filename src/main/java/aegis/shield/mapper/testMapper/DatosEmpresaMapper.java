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

import aegis.shield.model.dto.testMapper.DatosEmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:45:20 - 27/05/2023
 *
 */
@Mapper(componentModel = "spring")
public interface DatosEmpresaMapper {
    DatosEmpresaMapper INSTANCE = Mappers.getMapper(DatosEmpresaMapper.class);

    @Named("mapPuestos")
    default List<String> mapPuestos(List<JobFakeEntity> jobs) {
        return jobs.stream()
                .map(JobFakeEntity::getName)
                .collect(Collectors.toList());
    }
    /*
    @Named("mapDatosEmpresa")
    DatosEmpresaDTO mapDatosEmpresa(Integer fool, List<JobFakeEntity> puestos);
    */
}






