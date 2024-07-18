package com.rian.demo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "service")
public class DemoProperties {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}