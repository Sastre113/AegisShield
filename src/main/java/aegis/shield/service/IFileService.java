/**
 * 
 */
package aegis.shield.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:39:24 - 16/05/2023
 *
 */
public interface IFileService {

	public double getFileSize();
	public MultipartFile getMultipartFile(); 
	
}
