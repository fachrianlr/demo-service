package com.rian.user.controller;


import com.rian.common.dto.template.GenericResponse;
import com.rian.user.model.User;
import com.rian.user.service.UserService;
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
  public GenericResponse<List<User>> getAllUsers() {
    return userService.getAllUsers();
  }
}
