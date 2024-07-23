package com.rian.demo.controller;

import com.rian.demo.common.dto.response.GenericResponse;
import com.rian.demo.model.Demo;
import com.rian.demo.service.DemoService;
import java.util.List;
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
  public GenericResponse<String> getTest() {
    return demoService.getTestVariable();
  }

  @GetMapping("/")
  public GenericResponse<List<Demo>> getDemo(){
    return demoService.getAllDemo();
  }

}
