package com.secondDemo.springbootschool.Service;

import ch.qos.logback.core.net.SyslogOutputStream;

import com.secondDemo.springbootschool.Model.Student;
import com.secondDemo.springbootschool.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    //    private static Object studentRepoitory;
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> student = new ArrayList<Student>();

        studentRepository.findAll().forEach(student1 -> student.add(student1));
        return student;
    }

    public List<Student> getAllSortedStudent(String field) {
        System.out.println("h1");
        return studentRepository.findAll(Sort.by(field));
        //return studentRepository.findAllByOrderByName();
    }

    public Page<Student> getWithPagination(int offset, int pageSize) {
        Page<Student> stu = studentRepository.findAll(PageRequest.of(offset, pageSize));
        return stu;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student)
    {
        studentRepository.save(student);
    }
}

//     Sort.by("name")
//    Create or obtain a PageRequest object, which is an implementation of the Pageable interface
//    Pass the PageRequest object as an argument to the repository method we intend to use
//    We can create a PageRequest object by passing in the requested page number and the page size.

