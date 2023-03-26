package net.javaguides.sprintbootrestapi.controller;

import net.javaguides.sprintbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;


@RestController
public class StudentController {
  @GetMapping("student")
  public ResponseEntity<Student> getStudent() {
    Student student = new Student(
      1,
      "John",
      "Doe"
    );
    return ResponseEntity.ok()
    .header("custom-header", "remesh")
    .body(student);
  }
  @GetMapping("students")
  public ResponseEntity<List<Student>> getStudents() {
    List<Student> students = new ArrayList<>();
    students.add(new Student(1, "John", "Doe"));
    students.add(new Student(2, "Umesh", "Doe"));
    students.add(new Student(3, "Ram", "Angrea"));
    students.add(new Student(4, "Sanjay", "Kumar"));
    return ResponseEntity.ok(students);
  }
  @GetMapping("students/{id}/{first-name}/{last-name}")
  public ResponseEntity<Student> studentPathVariable(
    @PathVariable("id") int studentId,
    @PathVariable("first-name") String firstName,
    @PathVariable("last-name") String lastName) {
    Student student = new Student(studentId, firstName, lastName);
    return ResponseEntity.ok(student);
  }
  //http://localhost:8080/students/query?id=1&firstName=John&lastName=Doe
  @GetMapping("students/query")
  public Student studentRequestVariable(
    @RequestParam int id,
    @RequestParam String firstName,
    @RequestParam String lastName) {
    return new Student(id, firstName, lastName);
  }
  // Sprign boot REST API that hancles HTTP POST Request
  // @PostMapping and @RequestBody
  @PostMapping("students/create")
  // @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    System.out.println(student.getId());
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }
  // Spring boot REST API that handles HTTP PUT Request - updating existing resource
  @PutMapping("students/{id}/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return ResponseEntity.ok(student);
  }
  // Spring boot REST API that handles HTTP DELETE Request - deleting existing resource
  @DeleteMapping("students/{id}/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
    System.out.println(studentId);
    return ResponseEntity.ok("Student deleted successfully");
  }
}

