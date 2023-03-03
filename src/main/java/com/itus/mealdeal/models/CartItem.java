package com.itus.mealdeal.models;

public class CartItem {
	
	private String subscription;
	private double price;
	private double quantity;
	
	public CartItem() {}
	
	public CartItem(String subscription, double price, double quantity) {
		super();
		this.subscription = subscription;
		this.price = price;
		this.quantity = quantity;
	}

	public String getsubscription() {
		return subscription;
	}

	public void setsubscription(String subscription) {
		this.subscription = subscription;
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
		return "CartItem [subscription=" + subscription + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
