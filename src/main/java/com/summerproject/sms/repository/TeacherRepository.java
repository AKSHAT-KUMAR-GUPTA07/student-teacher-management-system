package com.summerproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerproject.sms.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher , Long>{
    
}
