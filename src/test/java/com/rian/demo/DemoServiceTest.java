package com.rian.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
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

  private final Demo demo1 = new Demo(1L, "A", "Desc A", LocalDateTime.now());
  private final Demo demo2 = new Demo(2L, "B", "Desc B", LocalDateTime.now());
  private final List<Demo> demoList = new ArrayList<>(Arrays.asList(demo1, demo2));

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    demoService = new DemoService(demoProperties, demoRepo);
  }

  @Test
  void testGetAllDemo() {
    // Arrange
    when(demoRepo.findAllDemo()).thenReturn(demoList);

    // Act
    GenericResponse<List<Demo>> response = demoService.getAllDemo();

    // Assert
    assertEquals(2, response.getData().size(),
        "The total number of demos should be 2");

    // Verify
    verify(demoRepo).findAllDemo();
  }

  @Test
  void testGetAllDemo_Empty() {
    // Arrange
    when(demoRepo.findAllDemo()).thenReturn(new ArrayList<>());

    // Act
    GenericResponse<List<Demo>> response = demoService.getAllDemo();

    // Assert
    assertEquals(0, response.getData().size(),
        "The total number of demos should be 0 when no demos are found");

    // Verify
    verify(demoRepo).findAllDemo();
  }
}
