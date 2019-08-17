package com.acme.monitor.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.monitor.controller.request.LoginRequest;
import com.acme.monitor.controller.request.UserRequest;
import com.acme.monitor.controller.response.BaseResponse;
import com.acme.monitor.controller.response.UsersResponse;
import com.acme.monitor.security.JwtTokenUtil;
import com.acme.monitor.service.UsersService;

@RestController
@RequestMapping(path = "/user")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	private final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

	@GetMapping(path = "/status")
	public ResponseEntity<?> getStatus(){
		return new ResponseEntity<>("Api is up and running", HttpStatus.OK);
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<?> getById(@PathVariable(name = "id", required = true) int userId) {

		UsersResponse response = usersService.getById(userId);

		return new ResponseEntity<>((response == null ? new BaseResponse(BaseResponse.ERROR, "NO User found")
				: new BaseResponse(BaseResponse.SUCCESS, "", response)), HttpStatus.OK);
	}

	@PostMapping(path = "/save")
	public ResponseEntity<?> saveOrUpdate(@RequestBody @Valid UserRequest userRequest) {

		UsersResponse response = (userRequest.getUser_id() == 0 ? usersService.save(userRequest)
				: usersService.update(userRequest));

		return (response == null
				? new ResponseEntity<>(new BaseResponse(BaseResponse.ERROR, "Failed to save/update user"),
						HttpStatus.OK)
				: new ResponseEntity<>(new BaseResponse(BaseResponse.SUCCESS, "", response), HttpStatus.OK));
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {

		UsersResponse usersResponse = usersService.getByUserName(loginRequest.getUsername());
		if (usersResponse == null)
			return new ResponseEntity<>(new BaseResponse(BaseResponse.ERROR, "No user found with mentioned username"),HttpStatus.OK);

		Authentication authentication = null;

		try {
			authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		} catch (BadCredentialsException ex) {
			String message = "Invalid username or password.";
			LOGGER.error(ex.getMessage());
			return new ResponseEntity<>(new BaseResponse(BaseResponse.ERROR, message), HttpStatus.OK);
		} catch (AuthenticationException e) {
			String message = "Failed to authenticate credentials";
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(new BaseResponse(BaseResponse.ERROR, message), HttpStatus.OK);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenUtil.doGenerateToken(usersResponse.getUsername());

		return new ResponseEntity<>(new BaseResponse(BaseResponse.SUCCESS, "", token), HttpStatus.OK);
	}

	// logout
	
	//forgotpassword


}
