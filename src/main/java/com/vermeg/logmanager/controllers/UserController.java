package com.vermeg.logmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.logmanager.entities.User;
import com.vermeg.logmanager.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserRepository userReposotory;

	public UserController(UserRepository userReposotory) {
		this.userReposotory = userReposotory;
	}

	@PostMapping("/save")
	public User save(@RequestBody User user) {
		return userReposotory.save(user);
	}

	@GetMapping("/findById/{id}")
	public User findById(@PathVariable int id) {
		return userReposotory.findById(id).get();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteid(@PathVariable int id) {
		userReposotory.deleteById(id);
	}

	@GetMapping("/findAll")
	public List<User> findAll() {
		return userReposotory.findAll();
	}
}
