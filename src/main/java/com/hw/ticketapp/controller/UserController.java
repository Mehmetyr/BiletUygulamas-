package com.hw.ticketapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hw.ticketapp.model.User;
import com.hw.ticketapp.security.SecurityConfig;
import com.hw.ticketapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	private final SecurityConfig securityConfig;

	public UserController(UserService userService, SecurityConfig securityConfig) {
		this.userService = userService;
		this.securityConfig = securityConfig;

	}

	@GetMapping
	public List<User> findAllUser() {

		List<User> users = new ArrayList<>();
		try {
			users = userService.findAllUser();

		} catch (Exception e) {

			throw e;
		}
		return users;

	}

	@PostMapping
	public User saveUser(@RequestBody User user) {

		User result = new User();
		try {
			result = userService.saveUser(user);
			UserDetails userDetail = securityConfig.createNewUser(user.getName(), user.getPassword(), "USER");
			securityConfig.userEkle(userDetail);
		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@PutMapping
	public User updateUser(@RequestBody User user) {

		User result = new User();
		try {
			result = userService.updateUser(user);

		} catch (Exception e) {

			throw e;
		}
		return result;

	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) throws Exception {

		try {
			User user = userService.findById(id);
			userService.deleteUser(id);
			securityConfig.userSil(user.getName());
		} catch (Exception e) {

			throw e;
		}
	}

}
