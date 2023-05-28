/**
 * 
 */
package aegis.shield.model.dto.testMapper;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 17:54:50 - 27/05/2023
 *
 */
public class EmpresaDTO {

	private String nombre;
	private DatosEmpresaDTO datosEmpresa;
	private List<EmpleadosDTO> empleados;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DatosEmpresaDTO getDatosEmpresa() {
		return datosEmpresa;
	}

	public void setDatosEmpresa(DatosEmpresaDTO datosEmpresa) {
		this.datosEmpresa = datosEmpresa;
	}

	public List<EmpleadosDTO> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadosDTO> empleados) {
		this.empleados = empleados;
	}
}
