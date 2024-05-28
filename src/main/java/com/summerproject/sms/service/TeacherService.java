package com.summerproject.sms.service;

import java.util.List;

import com.summerproject.sms.entity.Teacher;

public interface TeacherService {
    
    List<Teacher> getAllTeacher();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacherById(Teacher teacher);

    void deleteTeacherById(Long id);
}
