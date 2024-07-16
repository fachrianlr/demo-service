package com.rian.demoservice.controller;


import com.rian.demoservice.dao.model.User;
import com.rian.demoservice.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
}
