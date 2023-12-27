package com.ecommerce.Ecommerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Other methods...

    public User createUser(User user) {
        // Save the user to the database
        
        return userRepository.save(user);
    }

	public Page<User> getAllUser(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}
}
