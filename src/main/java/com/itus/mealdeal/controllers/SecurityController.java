package com.itus.mealdeal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itus.mealdeal.models.AuthenticationRequest;
import com.itus.mealdeal.models.AuthenticationResponse;
import com.itus.mealdeal.models.Cart;
import com.itus.mealdeal.models.IdGenerator;
import com.itus.mealdeal.models.User;
import com.itus.mealdeal.repos.CartRepository;
import com.itus.mealdeal.repos.IdgenRepository;
import com.itus.mealdeal.repos.UserRepository;
import com.itus.mealdeal.repos.VendorRepository;

@CrossOrigin(origins = "*")
@RestController
public class SecurityController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	IdgenRepository idRepo;
	
	@Autowired
	CartRepository cartRepo;
	
	@GetMapping("/")
	public String hello() {
		return "HELLO WORLD";
	}

	
	@PostMapping("/login")
	public int login(@RequestBody AuthenticationRequest authRequest) {
		List<User> users= new ArrayList<>();
		userRepo.findAll().stream().forEach(users::add);
		for(User user: users) {
			if(user.getEmail().compareTo(authRequest.getEmail())==0) {
				if(user.getPassword().compareTo(authRequest.getPassword())==0)
					return user.getId();
				else
					return 0;
			}
		}
		return -1;
	}
	
	@PostMapping("/register")
	public AuthenticationResponse signup(@RequestBody User user) {
		System.out.println("signing up "+user);
		List<String> usernames= new ArrayList<>();
		userRepo.findAll().forEach(u-> usernames.add(u.getEmail()));
		if(usernames.contains(user.getEmail()))
			return null;
		IdGenerator id= idRepo.findById("idgen").get();
		user.setId(id.getIdcount());
//		System.out.println(id);
//		System.out.println(user);
		System.out.println("registered "+user);
		userRepo.save(user);
		createCart(user.getId());
		id.setIdcount(id.getIdcount()+1);
//		System.out.println(id);
		idRepo.save(id);
		return new AuthenticationResponse(user.getId(), user.getFname());
	}
	
	public void createCart(@PathVariable("userId") int userId) {
		cartRepo.save(new Cart(userId, null, new ArrayList<>(), 0));
	}
}
