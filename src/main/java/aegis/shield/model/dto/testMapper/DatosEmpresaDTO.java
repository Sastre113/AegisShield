/**
 * 
 */
package aegis.shield.model.dto.testMapper;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 17:55:39 - 27/05/2023
 *
 */
public class DatosEmpresaDTO {

	private String direccion;
	private List<String> puestos;

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<String> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<String> puestos) {
		this.puestos = puestos;
	}
}
