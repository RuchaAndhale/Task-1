package com.rachana.Task.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rachana.Task.model.User;
import com.rachana.Task.repository.UserRepository;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	private UserRepository repo;
	
	@PostMapping("/save")
    public User addUser(@RequestBody User user) {
		return repo.save(user);
	}
	
	//get all user list from database
	@GetMapping("/users")
	public List<User> getUserList() {
		return repo.findAll();
	}

	//Delete data from datatable and also from database
    @DeleteMapping("/delete/{id}")
    public void deleteData(@PathVariable Long id) {
        repo.deleteById(id);
    }
    
   
}
