package com.acme.monitor.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.acme.monitor.controller.request.UserRequest;
import com.acme.monitor.controller.response.UsersResponse;
import com.acme.monitor.dao.ClientDao;
import com.acme.monitor.dao.UsersDao;
import com.acme.monitor.model.Client;
import com.acme.monitor.model.Users;
import com.acme.monitor.service.UsersService;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService , UserDetailsService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Users user = usersDao.findByUserNameIgnoreCase(userName);
		if(user == null) {
			throw new UsernameNotFoundException("No user found with username : "+userName);
		}
		
		return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
	}
	
	public UsersResponse getByUserName(String userName) {
		
		return getUsersResponse(usersDao.findByUserNameIgnoreCase(userName));
	
	}

	
	@Override
	public UsersResponse getById(int userId) {

		return getUsersResponse(usersDao.findByUserId(userId));
	}

	private UsersResponse getUsersResponse(Users users) {

		UsersResponse response = null;
		if (users != null) {
			response = new UsersResponse();
			response.setUser_id(users.getUsers_id());
			response.setUsername(users.getUserName());
			response.setEmail(users.getEmail());
			response.setClient_id(users.getClient().getClient_id()); // TODO : need to find better solution for loading object
		}
		return response;
	}

	@Override
	public UsersResponse save(UserRequest userRequest) {

		Users user = new Users();
		user.setUserName(userRequest.getUsername());
		user.setEmail(userRequest.getEmail());
		user.setPassword( passwordEncoder.encode(userRequest.getPassword()) );
		user.setCreatedBy(0); // TODO : Need to make dynamic
		user.setUpdatedBy(0);

		Client client = clientDao.findByClientId(userRequest.getClient_id());
		if (client == null)
			return null;

		user.setClient(client);
		user = usersDao.save(user);

		return getUsersResponse(user);
	}

	@Override
	public UsersResponse update(UserRequest userRequest) {

		Users user = usersDao.findByUserId(userRequest.getUser_id());
		if(user == null)
			return null;
		
		user.setPassword(StringUtils.isEmpty(userRequest.getPassword()) ? user.getPassword() : userRequest.getPassword());
		user = usersDao.save(user);
		return getUsersResponse(user);
	}

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println( encoder.encode("Pass@123"));
	}

}
