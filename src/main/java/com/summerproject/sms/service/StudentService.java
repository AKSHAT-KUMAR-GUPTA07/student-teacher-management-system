package com.summerproject.sms.service;

import java.util.List;

import com.summerproject.sms.entity.Student;

public interface StudentService {
    List<Student> getAllStudent();
    
    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudentById(Student student);

    void deleteStudentById(Long id);
}
