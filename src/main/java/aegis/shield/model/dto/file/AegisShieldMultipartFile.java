/**
 * 
 */
package aegis.shield.model.dto.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 0:40:34 - 17/05/2023
 *
 */
public class AegisShieldMultipartFile implements MultipartFile  {

	private AegisFile aegisFile;
	
	public AegisShieldMultipartFile(AegisFile aegisFile) {
		this.aegisFile = aegisFile;
	}

	@Override
	public String getName() {
		return this.aegisFile.getName();
	}

	@Override
	public String getOriginalFilename() {
		return this.aegisFile.getName();
	}

	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public boolean isEmpty() {
		return this.aegisFile == null;
	}

	@Override
	public long getSize() {
		try {
			return this.aegisFile != null ? this.getBytes().length : 0;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public byte[] getBytes() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
			objectOutputStream.writeObject(this.aegisFile);
		}
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		throw new UnsupportedOperationException();
	}	
}