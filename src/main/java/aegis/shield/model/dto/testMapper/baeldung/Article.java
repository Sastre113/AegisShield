/**
 * 
 */
package aegis.shield.model.dto.testMapper.baeldung;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 22:52:53 - 27/05/2023
 *
 */
public class Article {

	private int idArticulo;
	private String nombre;
	private List<Person> autores;

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Person> getAutores() {
		return autores;
	}

	public void setAutores(List<Person> autores) {
		this.autores = autores;
	}

}
