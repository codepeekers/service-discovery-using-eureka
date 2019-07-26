package com.example.eureka.courseservice;

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
