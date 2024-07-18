package com.rian.demo.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Demo {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;

}
