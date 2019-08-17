package com.acme.monitor.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usersroles")
public class UsersRoles extends BaseModel implements Serializable {

	private static final long serialVersionUID = -8078919915019164284L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersroles_id_seq_generator")
	@SequenceGenerator(name = "usersroles_id_seq_generator", sequenceName = "usersroles_id_seq", allocationSize = 1)
	@Column(nullable = false, columnDefinition = "SERIAL")
	private int usersroles_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", referencedColumnName = "users_id")
	private Users users;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client;

	public UsersRoles() {
		// TODO Auto-generated constructor stub
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getUsersroles_id() {
		return usersroles_id;
	}

	public void setUsersroles_id(int usersroles_id) {
		this.usersroles_id = usersroles_id;
	}

}
