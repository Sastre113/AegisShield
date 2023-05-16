/**
 * 
 */
package aegis.shield.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import aegis.shield.service.IFileService;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 21:41:40 - 16/05/2023
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {

	private IFileService fileService;
	
	public FileController(IFileService fileService) {
		super();
		this.fileService = fileService;
	}

	@GetMapping(value = "")
	public ResponseEntity<?> getFileSize() {
		return ResponseEntity.ok(this.fileService.getFileSize());
	}
	
	@GetMapping(value = "/multipartfile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MultipartFile> getMultipartFile(HttpServletResponse response) {
		// TODO Esta fallando
		MultipartFile multipartFile = this.fileService.getMultipartFile();
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + multipartFile.getOriginalFilename() + "\"");
        try {
			response.getOutputStream().write(multipartFile.getBytes());
			return ResponseEntity.ok(this.fileService.getMultipartFile());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
