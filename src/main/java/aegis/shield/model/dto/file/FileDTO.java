/**
 * 
 */
package aegis.shield.model.dto.file;

import java.util.List;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:45:21 - 16/05/2023
 *
 */
public class FileDTO {

	private String name;
	private Integer number;
	private Boolean isFile;
	private List<Integer> listNumber;
	private List<FileDTO> listSubFile;

	public FileDTO() {

	}

	public FileDTO(FileDTO file) {
		super();
		this.name = file.getName();
		this.number = file.getNumber();
		this.listNumber = file.getListNumber();
		this.listSubFile = file.getListSubFile();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Boolean getIsFile() {
		return isFile;
	}

	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}

	public List<Integer> getListNumber() {
		return listNumber;
	}

	public void setListNumber(List<Integer> listNumber) {
		this.listNumber = listNumber;
	}

	public List<FileDTO> getListSubFile() {
		return listSubFile;
	}

	public void setListSubFile(List<FileDTO> listSubFile) {
		this.listSubFile = listSubFile;
	}
}
