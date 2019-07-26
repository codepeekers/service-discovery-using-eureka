package com.example.eureka.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

  private List<Student> students = new ArrayList<>();

  @LoadBalanced @Autowired private RestTemplate restTemplate;

  @PostConstruct
  public void init() {
    students.add(new Student("john", "john@gmail.com", 1));
    students.add(new Student("emilia", "emilia@gmail.com", 2));
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @GetMapping("/list")
  public List<StudentDTO> getStudents() {
    return students.stream().map(this::getStudentDTO).collect(Collectors.toList());
  }

  private StudentDTO getStudentDTO(Student student) {
    Course course =
        restTemplate.getForObject(
            "http://course-service/courses/details/" + student.getCourseId(), Course.class);
    return new StudentDTO(student.getName(), student.getEmailId(), course);
  }
}
