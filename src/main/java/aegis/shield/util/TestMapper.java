/**
 * 
 */
package aegis.shield.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import aegis.shield.mapper.baeldung.ArticleUsingPersonMapper;
import aegis.shield.mapper.testMapper.EmpresaMapper;
import aegis.shield.mapper.testMapper.EmpresaSoloMapper;
import aegis.shield.model.dto.testMapper.EmpresaDTO;
import aegis.shield.model.dto.testMapper.baeldung.Article;
import aegis.shield.model.dto.testMapper.baeldung.ArticleDTO;
import aegis.shield.model.dto.testMapper.baeldung.Person;
import aegis.shield.model.dto.testMapper.fakeEntity.EmployeeFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.EmpresaFakeEntity;
import aegis.shield.model.dto.testMapper.fakeEntity.JobFakeEntity;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 17:53:18 - 27/05/2023
 *
 */
public final class TestMapper {
	
	private final String[] arrayName = {"Gordon Freeman", "John", "G-Man", "Peter"};
	private final String[] jobName = {"Programador", "Cientifico", "Analista", "Agente"};

	public TestMapper() {
		EmpresaFakeEntity empresaEntity = new EmpresaFakeEntity();
		List<EmployeeFakeEntity> listaEmpleados = this.crearListaEmpleados();
		List<JobFakeEntity> listaJob = this.crearListaPuesto();
		
		empresaEntity.setName("Black-mesa");
		empresaEntity.setAddres("Texas");
		empresaEntity.setJob(listaJob);
		empresaEntity.setListEmployee(listaEmpleados);
		
		
		
		EmpresaDTO empresaDTO = EmpresaSoloMapper.INSTANCE.toDTO(empresaEntity);
		System.out.println(empresaDTO);
		
		EmpresaDTO empresaDosDTO = EmpresaMapper.INSTANCE.toDTO(empresaEntity);
		System.out.println(empresaDosDTO);
		
		
		Article articulo = new Article();
		articulo.setIdArticulo(100);
		articulo.setNombre("Pepe");
		articulo.setAutores(this.crearListaPersonas());
		
		ArticleDTO articuloDTO = ArticleUsingPersonMapper.INSTANCE.articleToArticleDto(articulo);
		System.out.println(articuloDTO);
		
		
	}

	

	/**
	 * @return
	 */
	private List<Person> crearListaPersonas() {
		List<Person> personas = new ArrayList<>();
		
		for(String name : arrayName) {
			Person persona = new Person();
			persona.setIdPersona(new Random().nextInt() + "");
			persona.setNombre(name);
			
			personas.add(persona);
		}
		
		
		return personas;
	}



	private List<EmployeeFakeEntity> crearListaEmpleados() {
		List<EmployeeFakeEntity> listaEmpleados = new ArrayList<>();
		
		for(String name : arrayName) {
			EmployeeFakeEntity empleado = new EmployeeFakeEntity();
			empleado.setName(name);
			empleado.setYears(new Random().nextInt());
			
			listaEmpleados.add(empleado);
		}
		
		return listaEmpleados;
	}
	
	
	private List<JobFakeEntity> crearListaPuesto() {
		List<JobFakeEntity> listaJob = new ArrayList<>();

		for(String jobName : jobName) {
			JobFakeEntity job = new JobFakeEntity();
			job.setName(jobName);
			job.setSalary(new Random().nextInt());
			
			listaJob.add(job);
		}
		
		return listaJob;
	}
}