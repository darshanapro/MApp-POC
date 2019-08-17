package com.acme.monitor.controller.response;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UsersResponse implements Serializable {

	private static final long serialVersionUID = 2615564305273801584L;

	private int user_id;

	private int client_id;

	private String username;

	private String email;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsersResponse() {
		// TODO Auto-generated constructor stub
	}

	public UsersResponse(int user_id, int client_id, String username, String email) {
		super();
		this.user_id = user_id;
		this.client_id = client_id;
		this.username = username;
		this.email = email;
	}

}
