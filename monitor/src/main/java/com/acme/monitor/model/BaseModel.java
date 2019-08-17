package com.acme.monitor.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 7541802146790901155L;

	@Column(nullable = false)
	private boolean isActive = true;

	@Column(nullable = false, updatable = false)
	private int createdBy;

	@Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date created;

	@Column(nullable = false)
	private int updatedBy;

	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updated;

	public BaseModel() {
		// TODO Auto-generated constructor stub
	};

	public BaseModel(boolean isActive, int createdBy, Date created, int updatedBy, Date updated) {
		super();
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.created = created;
		this.updatedBy = updatedBy;
		this.updated = updated;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
