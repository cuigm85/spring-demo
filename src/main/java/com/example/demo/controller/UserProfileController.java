package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	
	private final UserProfileMapper mapper;
	
	public UserProfileController(final UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") Long id) {
		
		return mapper.getUserProfile(id);
	}
	
	@GetMapping("/user/all")
	public  List<UserProfile> getAllUserProfile() {
		
		return mapper.getUserProfileList();
	}

	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		mapper.updateUserProfile(id, name, phone, address);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		mapper.insertUserProfile(id, name, phone, address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") Long id) {
		
		mapper.deleteUserProfile(id);
	}
	
}
