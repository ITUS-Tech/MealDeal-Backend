package com.itus.mealdeal.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="carts")
public class Cart {
	
	@Id
	private int userId;
	private int vendorId;
	private String vendorName;
	private String startDate;
	private String endDate;
	private List<CartItem> items;
	private double totalPrice;
	public Cart() {}

	public Cart(int userId, int vendorId, String vendorName, String startDate, String endDate, List<CartItem> items,
			double totalPrice) {
		super();
		this.userId = userId;
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", vendorId=" + vendorId + ", vendorName=" + vendorName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", items=" + items + ", totalPrice=" + totalPrice + "]";
	}
}
