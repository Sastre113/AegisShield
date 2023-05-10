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

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 23:37:50 - 30/04/2023
 *
 */
@RestController
@RequestMapping("/user")
@PreAuthorize("hasAnyRole('ADMIN')")
public class UserController {

	private IUserService userService;
	
	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "")
	@PreAuthorize("hasRole('ADMIN')")
	public UserDTO createUser(@RequestBody RequestCreateUserDTO requestDTO) {
		return this.userService.createUser(requestDTO);
	}
	
	@GetMapping(value = "/{idUser}")
	@PreAuthorize("hasRole('USER')")
	public UserDTO getUser(@PathVariable String idUser) {
		return this.userService.getUser(idUser);
	}
	
	@GetMapping(value = "/{idUser}/rol")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Set<RolDTO> getUserDTO(@PathVariable String idUser) {
		return this.userService.getUserRol(idUser);
	}
	
	@GetMapping(value = "")
	@Secured("ROLE_ADMIN")
	public List<UserDTO> getAllUser() {
		return this.userService.getAllUser();
	}
	
	@Secured("ADMIN")
	@DeleteMapping(value = "/{idUser}")
	public void deleteUser(@PathVariable String idUser) {
		this.userService.deleteUser(idUser);
	}
	
	@Secured("ADMIN")
	@DeleteMapping(value = "")
	public void throwException(@PathVariable String idUser) {
		throw new RuntimeException("Es una prueba");
	}
}
