package com.rian.user.controller;


import com.rian.demo.common.dto.response.GenericResponse;
import com.rian.user.model.User;
import com.rian.user.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public GenericResponse<List<User>> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{userId}")
  public GenericResponse<User> getUserById(@PathVariable Integer userId) {
    return userService.findUserById(userId);
  }

  @GetMapping("/{userName}/{email}")
  public GenericResponse<User> getUserById(@PathVariable String userName, @PathVariable String email) {
    return userService.findByUserNameAndEmail(userName, email);
  }
}
