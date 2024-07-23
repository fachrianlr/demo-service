package com.rian.demo.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "service")
@AllArgsConstructor
@Data
public class DemoProperties {

  private String name;
}
