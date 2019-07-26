package com.example.eureka.studentservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
  private int courseId;
  private int fees;
  private String courseName;
}
