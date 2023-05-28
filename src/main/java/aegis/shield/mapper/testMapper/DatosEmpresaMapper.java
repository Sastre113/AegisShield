/**
 * 
 */
package aegis.shield.mapper.testMapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.DatosEmpresaDTO;
import aegis.shield.model.dto.testMapper.fakeEntity.EmpresaFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:45:20 - 27/05/2023
 *
 */
@Mapper(injectionStrategy =  InjectionStrategy.CONSTRUCTOR)
public interface DatosEmpresaMapper {
	
    DatosEmpresaMapper INSTANCE = Mappers.getMapper(DatosEmpresaMapper.class);

    
    @Mapping(source = "addres", target = "direccion")
    @Mapping(source = "job", target = "puestos", qualifiedByName = {"mapListaPuestos"})
    DatosEmpresaDTO mapToDatosEmpresaDTO(EmpresaFakeEntity empresa);
    
    @Named("mapListaPuestos")
    default List<String> mapToDatosEmpresaDTO(List<JobFakeEntity> jobs){
    	List<String> listaPuesto = new ArrayList<>();
    	jobs.forEach(job -> listaPuesto.add(job.getName()));
    	return listaPuesto;
    }
   
}






