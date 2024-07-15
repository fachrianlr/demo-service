package com.rian.demoservice.controller;

import com.rian.demoservice.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {

  private final DemoService demoService;

  public DemoController(DemoService demoService) {
    this.demoService = demoService;
  }

  @GetMapping("/test")
  public String getTest() {
    return demoService.getTestVariable1();
  }

}
