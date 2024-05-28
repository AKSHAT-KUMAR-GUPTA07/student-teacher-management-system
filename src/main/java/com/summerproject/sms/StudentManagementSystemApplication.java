package com.summerproject.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.summerproject.sms.entity.Student;
import com.summerproject.sms.entity.Teacher;
import com.summerproject.sms.repository.StudentRepository;
import com.summerproject.sms.repository.TeacherRepository;


@SuppressWarnings("unused")
@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// Teacher teacher1 = new Teacher("Jothi" , "CSE" , "jothi@gamil.com");
		// teacherRepository.save(teacher1);
	}


}
