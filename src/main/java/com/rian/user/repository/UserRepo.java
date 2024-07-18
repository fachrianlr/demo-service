package com.rian.user.repository;

import com.rian.user.model.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepo {

  List<User> findAllUsers();

  User findUserById(Integer id);

  User findUserByUserNameAndEmail(Map<String, Object> paramInput);
}
