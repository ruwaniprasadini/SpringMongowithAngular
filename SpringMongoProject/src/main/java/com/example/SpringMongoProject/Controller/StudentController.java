package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Student;
import com.example.SpringMongoProject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {


    @Autowired
    private StudentService studentService;
    @PostMapping(value = "/save")
    private String saveStudent(@RequestBody Student students){

        studentService.saveorUpdate(students);
        return students.get_id();
    }

    @GetMapping(value = "/getAll")
    private   Iterable<Student>getStudents(){

        return studentService.ListAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name="id")String _id){

        student.set_id(_id);
        studentService.saveorUpdate(student);
        return student;

    }

    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id") String _id){
        studentService.deleteStudent(_id);
    }

    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name="id")String studentid){
        return studentService.getStudentById(studentid);
    }



}
