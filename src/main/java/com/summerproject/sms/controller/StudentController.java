package com.summerproject.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.summerproject.sms.entity.Student;
import com.summerproject.sms.service.StudentService;

@Controller
public class StudentController {

    private StudentService studentService;

    // same here for autowired
    public StudentController(StudentService studentService) {
        super(); // dont foeget
        this.studentService = studentService;
    }

    // handler methods below
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudent()); // this students refering to $students used in
                                                                        // table
        return "students";// refering to html document
    }

    @GetMapping("/students/new")
    public String creatStudentForm(Model model) {
        // create student object to hold form values
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id , @ModelAttribute("student") Student student , Model model) {

        // get student by id from dtabase
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudentById(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
