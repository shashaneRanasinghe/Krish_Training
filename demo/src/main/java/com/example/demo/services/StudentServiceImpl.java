package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent (int id){
        Optional<Student> student =  studentRepository.findById(id);
        if (student.isPresent()){
            return student.get();
        }else{
            return null;
        }
    }
}
