package net.javaguides.sprintbootrestapi.controller;

import net.javaguides.sprintbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {
  @GetMapping("student")
  public Student getStudent() {
    Student student = new Student(
      1,
      "John",
      "Doe"
    );
    return student;
  }
}
