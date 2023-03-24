package com.itus.mealdeal.models;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "vendors")
public class Vendor {
	@Id
	private int id;
	private String image;
	private String vendorName;
	private String address;
	private String menu;
	private Map<String, Integer> prices;
	
	public Vendor() {}

	public Vendor(int id, String image, String vendorName, String address, String menu, Map<String, Integer> prices) {
		super();
		this.id = id;
		this.image = image;
		this.vendorName = vendorName;
		this.address=address;
		this.menu = menu;
		this.prices = prices;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public Map<String, Integer> getPrices() {
		return prices;
	}

	public void setPrices(Map<String, Integer> prices) {
		this.prices = prices;
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", image=" + image + ", vendorName=" + vendorName + ", address=" + address
				+ ", menu=" + menu + ", prices=" + prices + "]";
	}
}
