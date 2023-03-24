package com.itus.mealdeal.controllers;

import java.util.ArrayList;
import java.util.List;

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

@CrossOrigin(origins = "*")
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
		cart.setVendorId(0);
		cart.setVendorName("");
		cart.setItems(new ArrayList<>());
		cart.setTotalPrice(0);
		cartRepo.save(cart);
	}
	
	@GetMapping("/{userId}")
	public Cart getCart(@PathVariable("userId") int userId) {
		System.out.println(userId);
		return cartRepo.findById(userId).get();
	}
	
	@PutMapping("/edit/{userId}")
	public void editQuantity(@PathVariable("userId") int userId, @RequestBody Cart cart) {
		cartRepo.save(cart);
	}
	
	@PutMapping("/add/{userId}")
	public void addToCart(@PathVariable("userId") int userId, @RequestBody Cart cart) {
		Cart currentCart= getCart(userId);
		List<CartItem> currentItems= currentCart.getItems();
		currentItems.add(cart.getItems().get(0));
		currentCart.setTotalPrice(currentCart.getTotalPrice()+(cart.getItems().get(0).getPrice()*cart.getItems().get(0).getQuantity()));
		cartRepo.save(currentCart);
	}
	
}
