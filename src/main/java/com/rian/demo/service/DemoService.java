package com.rian.demo.service;


import com.rian.demo.common.dto.response.GenericResponse;
import com.rian.demo.config.DemoProperties;
import com.rian.demo.repository.DemoRepo;
import com.rian.demo.model.Demo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoService {

  private final DemoProperties demoProperties;
  private final DemoRepo demoRepo;

  public DemoService(DemoProperties demoProperties, DemoRepo demoRepo) {
    this.demoProperties = demoProperties;
    this.demoRepo = demoRepo;
  }

  public GenericResponse<String> getTestVariable() {
    return GenericResponse.<String>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(demoProperties.getName())
        .build();
  }

  public GenericResponse<List<Demo>> findAllDemo() {

    List<Demo> demoList = demoRepo.findAllDemo();
    log.info("findByUserNameAndEmail: {}", demoList);
    return GenericResponse.<List<Demo>>builder()
        .respCode(String.valueOf(HttpStatus.OK.value()))
        .respDesc(HttpStatus.OK.getReasonPhrase())
        .data(demoList)
        .build();
  }
}
