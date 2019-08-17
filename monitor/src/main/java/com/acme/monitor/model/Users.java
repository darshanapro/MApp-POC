package com.acme.monitor.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users extends BaseModel implements Serializable {

	private static final long serialVersionUID = -8573458029728345059L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq_generator")
	@SequenceGenerator(name = "users_id_seq_generator", sequenceName = "users_users_id_seq", allocationSize = 1)
	@Column(nullable = false, columnDefinition = "SERIAL")
	private int users_id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
