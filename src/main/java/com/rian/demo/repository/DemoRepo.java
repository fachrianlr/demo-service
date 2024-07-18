package com.rian.demo.repository;

import com.rian.demo.model.Demo;
import com.rian.user.model.User;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoRepo {

  List<Demo> findAllDemo();

}
