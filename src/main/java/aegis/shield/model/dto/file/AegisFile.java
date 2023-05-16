/**
 * 
 */
package aegis.shield.model.dto.file;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:45:21 - 16/05/2023
 *
 */
public class AegisFile implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int DEPTH = 13;
	private static final int MIN_NUMBER = 1000;
	private static final int MAX_NUMBER = 5000;
	
	private String name;
	private Integer number;
	private Boolean isFile;
	private List<Integer> listNumber;
	private List<AegisFile> listSubFile;

	public AegisFile() {
		listNumber = new ArrayList<>();
        listSubFile = new ArrayList<>();
	}

	public AegisFile(AegisFile file) {
        this.name = file.getName();
        this.number = file.getNumber();
        this.isFile = file.getIsFile();
        this.listNumber = new ArrayList<>(file.getListNumber());

        this.listSubFile = new ArrayList<>();
        for (AegisFile subFile : file.getListSubFile()) {
            this.listSubFile.add(new AegisFile(subFile));
        }
    }
	
	public static AegisFile generateDefaultAegisFile() {
		return AegisFile.createRandomFileDTO(DEPTH, MIN_NUMBER, MAX_NUMBER);
	}

    public static AegisFile createRandomFileDTO(int depth, int minNumber, int maxNumber) {
        AegisFile file = new AegisFile();
        Random random = new Random();

        file.setName(UUID.randomUUID().toString());
        file.setNumber(random.nextInt(maxNumber - minNumber + 1) + minNumber);
        file.setIsFile(random.nextBoolean());
        file.setListNumber(generateRandomNumberList(random.nextInt(10), minNumber, maxNumber));

        if (depth > 0) {
            int subFileCount = random.nextInt(5) + 1; 
            for (int i = 0; i < subFileCount; i++) {
                AegisFile subFile = createRandomFileDTO(depth - 1, minNumber, maxNumber);
                file.getListSubFile().add(subFile);
            }
        }

        return file;
    }

    private static List<Integer> generateRandomNumberList(int size, int min, int max) {
        List<Integer> numberList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            numberList.add(randomNumber);
        }

        return numberList;
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

	public List<AegisFile> getListSubFile() {
		return listSubFile;
	}

	public void setListSubFile(List<AegisFile> listSubFile) {
		this.listSubFile = listSubFile;
	}
}
