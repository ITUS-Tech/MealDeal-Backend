package com.itus.mealdeal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itus.mealdeal.models.Cart;
import com.itus.mealdeal.models.IdGenerator;
import com.itus.mealdeal.models.Order;
import com.itus.mealdeal.models.User;
import com.itus.mealdeal.repos.CartRepository;
import com.itus.mealdeal.repos.IdgenRepository;
import com.itus.mealdeal.repos.OrderRepository;
import com.itus.mealdeal.repos.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	IdgenRepository	idRepo;
	
	@GetMapping("/{vendorId}")
	public List<Order> getAllVendorOrders(@PathVariable("vendorId") int id){
		return orderRepo.findAllByVendorId(id);
	}
	
	@GetMapping("/user/{userId}")
	public List<Order> getAllUserOrders(@PathVariable("userId") int id){
		return orderRepo.findAllByUserId(id);
	}
	
	@PostMapping("/add")
	public int createOrder(@RequestBody Order order) {
		User user= userRepo.findById(order.getUserId()).get();
		IdGenerator id= idRepo.findById("idgen").get();
		order.setId(id.getIdcount());
		id.setIdcount(id.getIdcount()+1);
		idRepo.save(id);
		order.setCustomerName(user.getFname()+" "+user.getLname());
		order.setAddress(user.getAddress());
		order.setPhone(user.getPhno());
		order.setEmail(user.getEmail());
		orderRepo.save(order);
		Cart cart= new Cart();
		cart.setUserId(order.getUserId());
		cart.setItems(new ArrayList<>());
		cartRepo.save(cart);
		return order.getId();
	}
}
