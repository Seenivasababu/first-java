package com.ecommerce.Ecommerce;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class UserController {

	private final UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		// Call the service to create a new user
		return userService.createUser(user);
	}
	
	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		try {
			Path path = Paths.get(System.getProperty("user.dir"),file.getOriginalFilename());
			Files.copy(file.getInputStream(), path);
			return "File uploaded successfully";
		} catch (Exception e) {
			return "Files uploaded failed";
		}
		
	}


	@GetMapping
	public Page<User> getAllUser(@RequestParam int page, @RequestParam int size) {
		// Call the service to create a new user
		Pageable pageable = PageRequest.of(page, size);
		return userService.getAllUser(pageable);
	}
	@GetMapping("hello")
	public String hello() {
		return "Hello checking";
	}
//    
	@GetMapping("add")
	public User addUsers(@RequestParam String username, @RequestParam String email) {
		logger.info("Adding user with Username: {}, Email: {}", username, email);
		// Call the service to create a new user
		User createdUser = userService.createUser(new User(username, email));
		logger.info("User added successfully: {}", createdUser);
		return createdUser;
	}
}