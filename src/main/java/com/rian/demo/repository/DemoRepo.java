package com.rian.demo.repository;

import com.rian.demo.model.Demo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoRepo {

  List<Demo> findAllDemo();

}
