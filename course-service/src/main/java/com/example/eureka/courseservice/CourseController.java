package com.example.eureka.courseservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/courses/")
@Slf4j
public class CourseController {

  private Map<Integer, Course> courseMap = new HashMap<>();

  @PostConstruct
  public void init() {
    log.info("Initializing course information");
    courseMap.put(1, new Course(1, 10000, "Data Structures"));
    courseMap.put(2, new Course(2, 20000, "Data science"));
  }

  @GetMapping("/details/{courseId}")
  public Course getCourseDetails(@PathVariable("courseId") int courseId) {
    return courseMap.get(courseId);
  }
}
