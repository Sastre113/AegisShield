/**
 * 
 */
package aegis.shield.model.dto.testMapper.fakeEntity;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 17:59:25 - 27/05/2023
 *
 */
public class EmpresaFakeEntity {

	private String name;
	private String addres;
	private List<JobFakeEntity> job;
	private List<EmployeeFakeEntity> listEmployee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public List<JobFakeEntity> getJob() {
		return job;
	}

	public void setJob(List<JobFakeEntity> job) {
		this.job = job;
	}

	public List<EmployeeFakeEntity> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeFakeEntity> listEmployee) {
		this.listEmployee = listEmployee;
	}
}
