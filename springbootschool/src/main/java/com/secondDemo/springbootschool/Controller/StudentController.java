package com.secondDemo.springbootschool.Controller;

import com.secondDemo.springbootschool.Model.Student;
import com.secondDemo.springbootschool.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/students/*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getallsorted/{field}")
    public List<Student> getAllSortedStudent(@PathVariable("") String field){
        return studentService.getAllSortedStudent(field);
    }

    @GetMapping("/getwithpagination/{offset}/{pageSize}")
    public Page<Student> getWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        Page<Student> student1=studentService.getWithPagination(offset,pageSize);
        return student1;

    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    private void deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
    }

    @PostMapping("/students/save")
    private int saveStudent(@RequestBody Student student){
        studentService.save(student);
        return student.getId();
    }
    @PutMapping("/students/update")
    private Student update(@RequestBody Student student)
    {
        studentService.update(student);
        return student;
    }


//    private Student updateStudent(@PathVariable("id") int id,@RequestBody Student student){
//        return studentService.updateStudent(id,student);
//    }
}
