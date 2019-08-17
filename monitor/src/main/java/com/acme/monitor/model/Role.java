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
@Table(name = "role")
public class Role extends BaseModel implements Serializable {

	private static final long serialVersionUID = -140952785695786839L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq_generator")
	@SequenceGenerator(name = "role_id_seq_generator", sequenceName = "role_role_id_seq", allocationSize = 1)
	@Column(nullable = false, columnDefinition = "SERIAL")
	private int role_id;

	@Column(nullable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName = "client_id")
	private Client client;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
