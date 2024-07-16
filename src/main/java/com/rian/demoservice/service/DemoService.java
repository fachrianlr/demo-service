package com.rian.demoservice.service;


import com.rian.demoservice.config.DemoProperties;
import com.rian.demoservice.dao.model.User;
import com.rian.demoservice.dao.repo.UserRepo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  private final DemoProperties demoProperties;

  public DemoService(DemoProperties demoProperties) {
    this.demoProperties = demoProperties;
  }

  public String getTestVariable1() {
    return demoProperties.getName();
  }

}
