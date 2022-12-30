package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")  // Base URL
public class StudentController {

    // http://localhost:8080/students/student
    @GetMapping("student")
//    public Student getStudent(){
//        Student student = new Student(
//                1,
//                "Joe",
//                "Doe"
//        );
//        return student;
//    }

    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Joe",
                "Doe"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Joe")
                .body(student);
    }

    // http://localhost:8080/students
    @GetMapping
//    public List<Student> getStudents(){
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "Joe", "Doe"));
//        students.add(new Student(2, "William", "Martin"));
//        students.add(new Student(3, "Carol", "Moore"));
//        students.add(new Student(4, "Luz", "Engels"));
//        return students;
//    }

    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Joe", "Doe"));
        students.add(new Student(2, "William", "Martin"));
        students.add(new Student(3, "Carol", "Moore"));
        students.add(new Student(4, "Luz", "Engels"));
        return ResponseEntity.ok(students);
    }

    // Spring boot REST API with Path Variable
    // {id} - URL template variable
    // http://localhost:8080/students/1/Jose/Doe
    @GetMapping("{id}/{first-name}/{last-name}")
//    public Student studentPathVariable(@PathVariable("id") int studentId,
//                                       @PathVariable("first-name") String firstName,
//                                       @PathVariable("last-name") String lastName){
//        return new Student(studentId, firstName, lastName);
//    }

    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Joe&lastName=Doe
    @GetMapping("query")
//    public Student studentRequestVariable(@RequestParam int id,
//                                          @RequestParam String firstName,
//                                          @RequestParam String lastName){
//        return new Student(id, firstName, lastName);
//    }

    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handlers HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
//    public Student createStudent(@RequestBody Student student){
//        System.out.println(student.getId());
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
        // ok return 200 and HttpStatus.CREATED return 201
    }

    // Spring boot REST API that handlers HTTP PUT Request - updating existing resource
    // http://localhost:8080/students/3/update
    @PutMapping("{id}/update")
//    public Student updateStudent(@RequestBody Student student,
//                                 @PathVariable("id") int studentId){
//        System.out.println(student.getFirstName());
//        System.out.println(student.getLastName());
//        return student;
//    }

    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handlers HTTP DELETE Request - deleting the existing resource
    // http://localhost:8080/students/3/delete
    @DeleteMapping("{id}/delete")
//    public String deleteStudent(@PathVariable("id") int studentId){
//        System.out.println(studentId);
//        return "Student deleted successfully!";
//    }

    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
