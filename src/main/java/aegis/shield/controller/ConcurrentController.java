/**
 * 
 */
package aegis.shield.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.service.IConcurrentService;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 20:48:22 - 09/05/2023
 *
 */
@RestController
@RequestMapping("/api/test/")
public class ConcurrentController {

	@Autowired
	private IConcurrentService concurrentService;

	@GetMapping(value = "/test1")
	public int test1() {
		return this.concurrentService.doSomething();
	}
	
	@PostMapping(value = "/test2")
	public UserDTO test2(@RequestBody UserDTO request) {
		return this.concurrentService.doSomethingUser(request);
	}
}
