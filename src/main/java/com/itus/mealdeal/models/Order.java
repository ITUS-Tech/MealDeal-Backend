package com.itus.mealdeal.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class Order {
	private int id;
	private int userId;
	private int vendorId;
	private String name;
	private List<Plan> plans;
	private double totalAmount;
	private String address;
	private String phone;
	private String email;
	
	public Order() {
		super();
	}

	public Order(int id, int userId, int vendorId, String name, List<Plan> plans, double totalAmount, String address,
			String phone, String email) {
		super();
		this.id = id;
		this.userId = userId;
		this.vendorId = vendorId;
		this.name = name;
		this.plans = plans;
		this.totalAmount = totalAmount;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", name=" + name + ", plans=" + plans + ", totalAmount="
				+ totalAmount + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
}