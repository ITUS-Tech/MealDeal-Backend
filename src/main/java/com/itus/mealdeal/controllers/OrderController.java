package com.itus.mealdeal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itus.mealdeal.models.Order;
import com.itus.mealdeal.repos.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepo;
	
	@GetMapping("/{userId}")
	public List<Order> getAllVendorOrders(@PathVariable("userId") int id){
		return orderRepo.findByUserId(id);
		
	}
}
