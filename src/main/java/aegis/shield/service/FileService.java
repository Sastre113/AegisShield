/**
 * 
 */
package aegis.shield.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aegis.shield.model.dto.file.AegisFile;
import aegis.shield.model.dto.file.AegisShieldMultipartFile;
/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:42:03 - 16/05/2023
 *
 */
@Service
public class FileService implements IFileService {
	
	@Override
	public double getFileSize() {
		return this.calcularTamanoBytes(AegisFile.generateDefaultAegisFile());
	}

	@Override
	public MultipartFile getMultipartFile() {
		try {
			return this.convertToMultipartFile();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private <T> double calcularTamanoBytes(T object) {
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(object);
			oos.flush();
	        return baos.size() / (1024.0 * 1024.0); 
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private MultipartFile convertToMultipartFile() throws IOException {
		AegisFile aegisFile = AegisFile.generateDefaultAegisFile();
		return new AegisShieldMultipartFile(aegisFile);
	}
}
