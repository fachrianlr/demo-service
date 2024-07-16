package com.rian.demoservice.dao.repo;

import com.rian.demoservice.dao.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepo {

  List<User> findAllUsers();
}
