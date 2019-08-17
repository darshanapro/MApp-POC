package com.acme.monitor.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client extends BaseModel implements Serializable {

	private static final long serialVersionUID = -1450962929789066502L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq_generator")
	@SequenceGenerator(name = "client_id_seq_generator", sequenceName = "client_client_id_seq", allocationSize = 1)
	@Column(nullable = false, columnDefinition = "SERIAL")
	private int client_id;

	@Column(nullable = false, unique = true)
	private String name;

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}

}
