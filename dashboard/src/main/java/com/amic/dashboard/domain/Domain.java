package com.amic.dashboard.domain;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Dashboard12")
public class Domain implements Serializable {
	
	private static final long serialVersionUID = -2585956794138390018L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private String id;
	@Column(name = "vedios")
	   private Blob vedios;
	@Column(name="isActive")
	private boolean isActive;
	 
	private String path;
	 
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Blob getVedios() {
		return vedios;
	}
	public void setVedios(Blob vedios) {
		this.vedios = vedios;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPath() {
		return path;
	}

	public String setPath(String path) {
		return this.path = path;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Domain(String id, Blob vedios,boolean isActive) {
		super();
		this.id=id;
		this.vedios=vedios;
		this.isActive=isActive;
		

	}
	public Domain() {
		super();
	}
	Domain(String id, Blob vedios) {
			super();
			
			this.id=id;
			this.vedios=vedios;
			
		}
}
