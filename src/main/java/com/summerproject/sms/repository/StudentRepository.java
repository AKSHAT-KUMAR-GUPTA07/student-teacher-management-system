package com.summerproject.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerproject.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student , Long>{
    
}
