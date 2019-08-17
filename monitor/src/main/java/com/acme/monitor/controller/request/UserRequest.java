package com.acme.monitor.controller.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 7196388993762697347L;

	@NotNull
	private int user_id;

	@NotNull
	private int client_id;

	private String username;

	private String password;

	private String email;

	public UserRequest() {
		// TODO Auto-generated constructor stub
	}

	public UserRequest(@NotNull int user_id, @NotNull int client_id, String username, String password, String email) {
		super();
		this.user_id = user_id;
		this.client_id = client_id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
