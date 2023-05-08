/**
 * 
 */
package aegis.shield.controller;

import java.util.List;
import java.util.Set;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aegis.shield.model.dto.user.RequestCreateUserDTO;
import aegis.shield.model.dto.user.RolDTO;
import aegis.shield.model.dto.user.UserDTO;
import aegis.shield.service.IUserService;
import jakarta.annotation.security.RolesAllowed;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:37:50 - 30/04/2023
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private IUserService userService;
	
	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "")
	public UserDTO createUser(@RequestBody RequestCreateUserDTO requestDTO) {
		return this.userService.createUser(requestDTO);
	}
	
	@GetMapping(value = "/{idUser}")
	@PreAuthorize("hasRole('USER')")
	public UserDTO getUser(@PathVariable String idUser) {
		return this.userService.getUser(idUser);
	}
	
	@GetMapping(value = "/{idUser}/rol")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Set<RolDTO> getUserDTO(@PathVariable String idUser) {
		return this.userService.getUserRol(idUser);
	}
	
	@GetMapping(value = "")
	public List<UserDTO> getAllUser() {
		return this.userService.getAllUser();
	}
	
	@DeleteMapping(value = "/{idUser}")
	public void deleteUser(@PathVariable String idUser) {
		this.userService.deleteUser(idUser);
	}
	
}
