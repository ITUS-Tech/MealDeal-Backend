package com.itus.mealdeal.models;

public class CartItem {
	
	private String subscription;
	private String startDate;
	private String endDate;
	private double price;
	private double quantity;
	
	public CartItem() {}

	public CartItem(String subscription, String startDate, String endDate, double price, double quantity) {
		super();
		this.subscription = subscription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.quantity = quantity;
	}

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [subscription=" + subscription + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
