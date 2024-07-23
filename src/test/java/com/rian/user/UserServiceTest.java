package com.rian.user;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.rian.demo.common.dto.response.GenericResponse;
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

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    userService = new UserService(userRepo);

  }

  @Test
  void getUserByIdTest() {

    //Arrange
    User user = new User(1L, "test1", "test1@gmail.com");
    when(userRepo.findUserById(1L)).thenReturn(user);
    String expectedName = "test1";
    String expectedEmail = "test1@gmail.com";
    when(userRepo.findUserById(1L)).thenReturn(user);

    //Act
    GenericResponse<User> response = userService.getUserById(1L);

    //Assert
    assertEquals(expectedName, response.getData().getUsername(),
        "Test find user by id, is username equal");
    assertEquals(expectedEmail, response.getData().getEmail(),
        "Test find user by id, is email equal");
  }

  @Test
  void getAllUserTest() {
    //Arrange
    List<User> userList = new ArrayList<>(Arrays.asList(
        new User(1L, "test1", "test1@gmail.com"),
        new User(2L, "test2", "test2@gmail.com")
    ));
    int expectedTotalData = 2;
    when(userRepo.findAllUsers()).thenReturn(userList);

    //Act
    GenericResponse<List<User>> response = userService.getAllUsers();

    //Assert
    assertEquals(expectedTotalData, response.getData().toArray().length,
        "Test find user all, is total data equal");
  }

  @Test
  void getUserByUserNameAndEmailTest() {
    //Arrange
    User user2 = new User(1L, "test1", "test1@gmail.com");
    Map<String, Object> paramInput = new HashMap<>();
    paramInput.put("userName", "test1");
    paramInput.put("email", "test1@gmail.com");
    when(userRepo.findUserByUserNameAndEmail(paramInput)).thenReturn(user2);
    String expectedName = "test1";
    String expectedEmail = "test1@gmail.com";

    //Act
    GenericResponse<User> response = userService.getByUserNameAndEmail("test1", "test1@gmail.com");

    //Assert
    assertEquals(expectedName, response.getData().getUsername(),
        "Test find user by name & email, is name equal");
    assertEquals(expectedEmail, response.getData().getEmail(),
        "Test find user by name & email, is email equal");
  }
}
