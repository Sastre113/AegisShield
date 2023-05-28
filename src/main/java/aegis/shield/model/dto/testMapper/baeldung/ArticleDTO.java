/**
 * 
 */
package aegis.shield.model.dto.testMapper.baeldung;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 22:53:05 - 27/05/2023
 *
 */
public class ArticleDTO {
	private int id;
	private String name;
	private List<PersonDTO> author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PersonDTO> getAuthor() {
		return author;
	}

	public void setAuthor(List<PersonDTO> author) {
		this.author = author;
	}

}
