package net.javaguides.sprintbootrestapi.controller;

import net.javaguides.sprintbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;


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
  @GetMapping("students")
  public List<Student> getStudents() {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "John", "Doe"));
    students.add(new Student(2, "Umesh", "Doe"));
    students.add(new Student(3, "Ram", "Angrea"));
    students.add(new Student(4, "Sanjay", "Kumar"));
    return students;
  }
  @GetMapping("students/{id}/{first-name}/{last-name}")
  public Student studentPathVariable(
    @PathVariable("id") int studentId,
    @PathVariable("first-name") String firstName,
    @PathVariable("last-name") String lastName) {
    return new Student(studentId, firstName, lastName);
  }
  //http://localhost:8080/students/query?id=1&firstName=John&lastName=Doe
  @GetMapping("students/query")
  public Student studentRequestVariable(
    @RequestParam int id,
    @RequestParam String firstName,
    @RequestParam String lastName) {
    return new Student(id, firstName, lastName);
  }
}

