/**
 * 
 */
package aegis.shield.mapper.baeldung;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import aegis.shield.model.dto.testMapper.baeldung.Article;
import aegis.shield.model.dto.testMapper.baeldung.ArticleDTO;
import aegis.shield.model.dto.testMapper.baeldung.Person;
import aegis.shield.model.dto.testMapper.baeldung.PersonDTO;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 22:54:26 - 27/05/2023
 *
 */
@Mapper(uses = PersonMapper.class)
public interface ArticleUsingPersonMapper {
    
    ArticleUsingPersonMapper INSTANCE = Mappers.getMapper(ArticleUsingPersonMapper.class);
    
    
    @Mapping(source = "idArticulo", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "autores", target = "author", qualifiedByName = {"author"})
    ArticleDTO articleToArticleDto(Article article);
   
    @Named(value = "author")
    List<PersonDTO> listPersonaToPersonaDTO(List<Person> listPersona);
    
}
