package com.example.demo.services;

import com.example.demo.models.Student;

public interface StudentService {
    Student save(Student student);
    Student findStudent(int id);
}
