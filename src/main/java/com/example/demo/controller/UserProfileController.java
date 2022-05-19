package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {
	
	private Map<Long, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		
		userMap = new HashMap<>();
		
		userMap.put(1L, new UserProfile(1L, "홍길동", "111-111", "서울시 영등포구 1"));
		userMap.put(2L, new UserProfile(2L, "홍길서", "111-112", "서울시 영등포구 2"));
		userMap.put(3L, new UserProfile(3L, "홍길남", "111-113", "서울시 영등포구 3"));
		userMap.put(4L, new UserProfile(4L, "홍길북", "111-114", "서울시 영등포구 4"));
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") Long id) {
		
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public  List<UserProfile> getAllUserProfile() {
		return new ArrayList<>(userMap.values());
	}

	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		UserProfile userProfile = userMap.get(id);
		userProfile.setName(name);
		userProfile.setPhone(phone);
		userProfile.setAddress(address);
		userMap.put(id, userProfile);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		
		userMap.put(id, new UserProfile(id, name, phone, address));
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") Long id) {
		
		userMap.remove(id);
	}
	
}
