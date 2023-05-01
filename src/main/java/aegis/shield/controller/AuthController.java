/**
 * 
 */
package aegis.shield.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aegis.shield.model.dto.auth.JwtResponse;
import aegis.shield.model.dto.auth.LoginRequest;
import aegis.shield.model.dto.auth.SignupRequest;
import aegis.shield.model.entity.Usertb;
import aegis.shield.repository.UserRepository;
import aegis.shield.security.jwt.JwtTokenProvider;
import aegis.shield.security.service.UserDetailsImpl;
import jakarta.validation.Valid;

/**
 * @author Miguel Á. Sastre <sastre113@gmail.com>
 * @version 3:36:48 - 01/05/2023
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
			PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenProvider.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
	}


	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (this.userRepository.findById(signUpRequest.getUsername()).isPresent()) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}

		// Create new user's account
		Usertb user = new Usertb();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(this.passwordEncoder.encode(signUpRequest.getPassword()));
		this.userRepository.save(user);
		return ResponseEntity.ok(null);
	}
}