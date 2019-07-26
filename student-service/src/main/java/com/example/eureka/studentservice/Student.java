package com.example.eureka.studentservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String name;
  private String emailId;
  private int courseId;
}
