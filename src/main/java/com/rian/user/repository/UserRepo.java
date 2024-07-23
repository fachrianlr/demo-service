package com.rian.user.repository;

import com.rian.user.model.User;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepo {

  List<User> findAllUsers();

  User findUserById(Long id);

  User findUserByUserNameAndEmail(Map<String, Object> paramInput);
}
