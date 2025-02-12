package com.summerproject.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.summerproject.sms.entity.Teacher;
import com.summerproject.sms.service.TeacherService;

@Controller
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String listTeachers(Model model){
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String  saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id , Model model){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }
    
    @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher , Model model){
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setId(id);
        existingTeacher.setName(teacher.getName());
        existingTeacher.setDepartment(teacher.getDepartment());
        existingTeacher.setEmail(teacher.getEmail());

        teacherService.updateTeacherById(existingTeacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";

    }
}
