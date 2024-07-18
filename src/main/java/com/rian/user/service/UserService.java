package com.rian.user.service;

import com.rian.common.dto.response.GenericResponse;
import com.rian.user.model.User;
import com.rian.user.repository.UserRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    log.info("getAllUsers: {}", userList);
    return GenericResponse.<List<User>>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(userList)
        .build();
  }

  public GenericResponse<User> findUserById(int id) {
    User user = userRepo.findUserById(id);
    log.info("findUserById: {}", user);
    return GenericResponse.<User>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(user)
        .build();
  }

  public GenericResponse<User> findByUserNameAndEmail(String userName, String email) {
    Map<String, Object> params = new HashMap<>();
    params.put("userName", userName);
    params.put("email", email);

    User user = userRepo.findUserByUserNameAndEmail(params);
    log.info("findByUserNameAndEmail: {}", user);
    return GenericResponse.<User>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(user)
        .build();
  }
}
