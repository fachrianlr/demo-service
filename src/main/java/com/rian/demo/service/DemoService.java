package com.rian.demo.service;


import com.rian.demo.config.DemoProperties;
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
