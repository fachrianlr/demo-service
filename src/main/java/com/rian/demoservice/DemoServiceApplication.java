package com.rian.demoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan
@SpringBootApplication
public class DemoServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoServiceApplication.class, args);
  }

}
