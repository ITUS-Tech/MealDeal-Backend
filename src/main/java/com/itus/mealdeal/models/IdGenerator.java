package com.itus.mealdeal.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "idgen")
public class IdGenerator {
	
	String id;
	int idcount;
		
	public IdGenerator(String id, int idcount) {
		super();
		this.id = id;
		this.idcount = idcount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdcount() {
		return idcount;
	}
	public void setIdcount(int idcount) {
		this.idcount = idcount;
	}

	@Override
	public String toString() {
		return "IdGenerator [id=" + id + ", idcount=" + idcount + "]";
	}

	
}
