package com.rian.user.dao.repo;

import com.rian.user.dao.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepo {

  List<User> findAllUsers();
}
