package com.rian.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rian.common.dto.response.GenericResponse;
import com.rian.user.model.User;
import com.rian.user.repository.UserRepo;
import com.rian.user.service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  private UserRepo userRepo;
  private UserService userService;

  private final User testUser1 = new User(1L, "test1", "test1@gmail.com");
  private final User testUser2 = new User(2L, "test2", "test2@gmail.com");
  private final List<User> userList = new ArrayList<>(Arrays.asList(testUser1, testUser2));

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    userService = new UserService(userRepo);
  }

  @Test
  void testGetUserById() {
    // Arrange
    when(userRepo.findUserById(1L)).thenReturn(testUser1);

    // Act
    GenericResponse<User> response = userService.getUserById(1L);

    // Assert
    assertEquals("test1", response.getData().getUsername(),
        "The username should be 'test1' when finding user by id 1");
    assertEquals("test1@gmail.com", response.getData().getEmail(),
        "The email should be 'test1@gmail.com' when finding user by id 1");

    // Verify
    verify(userRepo).findUserById(1L);
  }

  @Test
  void testGetAllUsers() {
    // Arrange
    when(userRepo.findAllUsers()).thenReturn(userList);

    // Act
    GenericResponse<List<User>> response = userService.getAllUsers();

    // Assert
    assertEquals(2, response.getData().size(),
        "The total number of users should be 2");

    // Verify
    verify(userRepo).findAllUsers();
  }

  @Test
  void testGetUserByUserNameAndEmail() {
    // Arrange
    Map<String, Object> paramInput = new HashMap<>();
    paramInput.put("userName", "test1");
    paramInput.put("email", "test1@gmail.com");
    when(userRepo.findUserByUserNameAndEmail(paramInput)).thenReturn(testUser1);

    // Act
    GenericResponse<User> response = userService.getByUserNameAndEmail("test1", "test1@gmail.com");

    // Assert
    assertEquals("test1", response.getData().getUsername(),
        "The username should be 'test1' when finding user by username 'test1' and email 'test1@gmail.com'");
    assertEquals("test1@gmail.com", response.getData().getEmail(),
        "The email should be 'test1@gmail.com' when finding user by username 'test1' and email 'test1@gmail.com'");

    // Verify
    verify(userRepo).findUserByUserNameAndEmail(paramInput);
  }

  @Test
  void testGetUserById_NotFound() {
    // Arrange
    when(userRepo.findUserById(99L)).thenReturn(null);

    // Act
    GenericResponse<User> response = userService.getUserById(99L);

    // Assert
    assertEquals(null, response.getData(),
        "The user should be null when no user is found with id 99");

    // Verify
    verify(userRepo).findUserById(99L);
  }

  @Test
  void testGetUserByUserNameAndEmail_NotFound() {
    // Arrange
    Map<String, Object> paramInput = new HashMap<>();
    paramInput.put("userName", "nonexistent");
    paramInput.put("email", "nonexistent@gmail.com");
    when(userRepo.findUserByUserNameAndEmail(paramInput)).thenReturn(null);

    // Act
    GenericResponse<User> response = userService.getByUserNameAndEmail("nonexistent", "nonexistent@gmail.com");

    // Assert
    assertEquals(null, response.getData(),
        "The user should be null when no user is found with username 'nonexistent' and email 'nonexistent@gmail.com'");

    // Verify
    verify(userRepo).findUserByUserNameAndEmail(paramInput);
  }
}
