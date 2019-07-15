package com.amic.dashboard.model;

import java.io.Serializable;
 

 

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_DEFAULT)
public class Model implements Serializable {
	private static final long serialVersionUID = 4587430320826983700L;
	
	private String id;
	  //
	   private String path;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	 
	   
	 
}
