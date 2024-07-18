package com.rian.user.service;

import com.rian.common.dto.template.GenericResponse;
import com.rian.user.model.User;
import com.rian.user.repository.UserRepo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

  private final UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public GenericResponse<List<User>> getAllUsers() {

    List<User> userList = userRepo.findAllUsers();
    log.info("Data: {}", userList);
    return GenericResponse.<List<User>>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(userList)
        .build();
  }
}
