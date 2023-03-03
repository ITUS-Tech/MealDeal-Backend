package com.itus.mealdeal.models;

public class AuthenticationResponse {
	private int id;
	private String name;
	public AuthenticationResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AuthenticationResponse [id=" + id + ", name=" + name + "]";
	}
}
