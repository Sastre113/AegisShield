/**
 * 
 */
package aegis.shield.mapper.baeldung;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.baeldung.Person;
import aegis.shield.model.dto.testMapper.baeldung.PersonDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 22:54:06 - 27/05/2023
 *
 */
@Mapper
public interface PersonMapper {
    
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    
    @Mapping(source = "idPersona", target = "id")
    @Mapping( source = "nombre", target = "name")
    PersonDTO personToPersonDTO(Person person);
}
