package com.rian.user.repository;

import com.rian.user.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepo {

  List<User> findAllUsers();
}
