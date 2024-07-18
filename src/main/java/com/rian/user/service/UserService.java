package com.rian.user.service;

import com.rian.user.dao.model.User;
import com.rian.user.dao.repo.UserRepo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

  private final UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public List<User> getAllUsers() {

    List<User> userList = userRepo.findAllUsers();
    log.info("Data: {}", userList);
    return userList;
  }
}
