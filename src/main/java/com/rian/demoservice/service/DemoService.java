package com.rian.demoservice.service;


import com.rian.demoservice.config.DemoProperties;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  final DemoProperties demoProperties;

  public DemoService(DemoProperties demoProperties) {
    this.demoProperties = demoProperties;
  }

  public String getTestVariable1() {
    return demoProperties.getName();
  }
}
