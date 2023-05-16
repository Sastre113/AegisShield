/**
 * 
 */
package aegis.shield.service;

import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import java.io.ObjectOutputStream;
/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:42:03 - 16/05/2023
 *
 */
public class FileService implements IFileService {

	@Override
	public Long getFileSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MultipartFile getMultipartFile() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	 private int calcularTamanoBytes(List<Object> listaObjetos) {
	        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
	             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
	            oos.writeObject(listaObjetos);
	            oos.flush();
	            return baos.size();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }
}
