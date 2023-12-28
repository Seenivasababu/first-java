package com.ecommerce.Ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserService userService = new UserService(userRepository);

    @Test
    void createUser_shouldSaveUserAndReturnIt() {
        User user = new User("testuser", "test@example.com");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser);
        assertEquals(user.getUsername(), savedUser.getUsername());
        assertEquals(user.getEmail(), savedUser.getEmail());
    }

    @Test 
    void getAllUser_shouldReturnPageOfUsers() {
        Pageable pageable = PageRequest.of(0, 10);
        User user1 = new User("user1","user1@gmail.com");
        User user2 = new User("user2","user2@gmail.com");
        Page<User> expected = new PageImpl<>(List.of(user1,user2));
        when(userRepository.findAll(pageable)).thenReturn(expected);
        Page<User> result = userService.getAllUser(pageable);
        assertEquals(2, 2);
        assertEquals(expected, result);
        assertEquals(2, result.getNumberOfElements());
    }
}
