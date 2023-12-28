package com.ecommerce.Ecommerce;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

class UserControllerTest {

    @Test
    void testCreateUser() {
        // Arrange
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        User mockUser = new User("testuser", "test@example.com");

        // Act
        when(userService.createUser(mockUser)).thenReturn(mockUser);
        User createdUser = userController.createUser(mockUser);

        // Assert
        assertNotNull(createdUser);
        assertEquals(mockUser, createdUser);
        verify(userService, times(1)).createUser(mockUser);
    }

//    @Test
//    void testUpload() {
//        // Arrange
//        UserService userService = mock(UserService.class);
//        UserController userController = new UserController(userService);
//        MultipartFile mockFile = mock(MultipartFile.class);
//
//        // Act
//        when(userService.uploadFile(mockFile)).thenReturn("File uploaded successfully");
//        String result = userController.upload(mockFile);
//
//        // Assert
//        assertEquals("File uploaded successfully", result);
//        verify(userService, times(1)).uploadFile(mockFile);
//    }

    @Test
    void testGetAllUser() {
        // Arrange
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        int mockPage = 0;
        int mockSize = 10;
        Page<User> mockUserPage = mock(Page.class);

        // Act
        when(userService.getAllUser(PageRequest.of(mockPage, mockSize))).thenReturn(mockUserPage);
        Page<User> userPage = userController.getAllUser(mockPage, mockSize);

        // Assert
        assertNotNull(userPage);
        assertEquals(mockUserPage, userPage);
        verify(userService, times(1)).getAllUser(PageRequest.of(mockPage, mockSize));
    }

    @Test
    void testAddUsers() {
        // Arrange
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        String mockUsername = "testuser";
        String mockEmail = "test@example.com";
        User mockCreatedUser = new User(mockUsername, mockEmail);

        // Act
        when(userService.createUser(new User(mockUsername, mockEmail))).thenReturn(mockCreatedUser);
        User createdUser = userController.addUsers(mockUsername, mockEmail);

        // Assert
        assertNotNull(createdUser);
        assertEquals(mockCreatedUser, createdUser);
        verify(userService, times(1)).createUser(new User(mockUsername, mockEmail));
    }
}
