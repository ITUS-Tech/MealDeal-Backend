package com.itus.mealdeal.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itus.mealdeal.models.Cart;
import com.itus.mealdeal.models.CartItem;
import com.itus.mealdeal.models.Vendor;
import com.itus.mealdeal.repos.CartRepository;
import com.itus.mealdeal.repos.VendorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	VendorRepository vendorRepo;
	
	
	@PutMapping("/reset/{userId}")
	public void resetCart(@PathVariable("userId") int userId) {
		Cart cart= cartRepo.findById(userId).get();
		cart.setVendorName("");
		cart.setItems(new ArrayList<>());
		cart.setTotalPrice(0);
		cartRepo.save(cart);
	}
	
	@GetMapping("/{userId}")
	public Cart getCart(@PathVariable("userId") int userId) {
		return cartRepo.findById(userId).get();
	}
	
	@PutMapping("/add/{userId}")
	public void addToCart(@PathVariable("userId") int userId, @RequestBody Cart cart) {
		double total=0;
		for(CartItem cartItem: cart.getItems()) {
			total+=cartItem.getPrice()*cartItem.getQuantity();
		}
		cart.setTotalPrice(total);
		System.out.println(cart);
		cartRepo.save(cart);
	}
	
}