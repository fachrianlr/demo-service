package com.rian.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.rian.demo.common.dto.response.GenericResponse;
import com.rian.demo.config.DemoProperties;
import com.rian.demo.model.Demo;
import com.rian.demo.repository.DemoRepo;
import com.rian.demo.service.DemoService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DemoServiceTest {

  @Mock
  private DemoProperties demoProperties;
  @Mock
  private DemoRepo demoRepo;

  private DemoService demoService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    demoService = new DemoService(demoProperties, demoRepo);
  }

  @Test
  void getAllDemoTest() {
    //Arrange
    List<Demo> expectedDemoList = new ArrayList<>(Arrays.asList(
        new Demo(1L, "A", "Desc A", LocalDateTime.now()),
        new Demo(2L, "B", "Desc B", LocalDateTime.now())
    ));
    int expectedTotalData = 2;
    when(demoRepo.findAllDemo()).thenReturn(expectedDemoList);

    //Act
    GenericResponse<List<Demo>> response = demoService.getAllDemo();

    //Assert
    assertEquals(expectedTotalData, response.getData().toArray().length,
        "Test get all demo, is total data equal to " + expectedTotalData);
  }
}
