package com.itus.mealdeal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itus.mealdeal.models.Vendor;
import com.itus.mealdeal.repos.VendorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	VendorRepository vendorRepo;
	
	@PostMapping("/")
	public void addVendor(@RequestBody Vendor vendor) {
		vendorRepo.save(vendor);
	}
	
	@GetMapping("/")
	public List<Vendor> getAllVendor() {
		List<Vendor> list= new ArrayList<>();
		vendorRepo.findAll().stream().forEach(list::add);
		return list;
	}
	
	@PutMapping("/{id}")
	public void updateVendor(@RequestBody Vendor vendor) {
		vendorRepo.save(vendor);
	}
	
	@GetMapping("/{id}")
	public Vendor getVendor(@PathVariable("id") int id) {
		
		System.out.println(id);
		System.out.println(vendorRepo.findById(id));
		return vendorRepo.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable("id") int id) {
		vendorRepo.deleteById(id);
	}
	
}
