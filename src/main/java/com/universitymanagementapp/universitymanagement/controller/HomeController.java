package com.universitymanagementapp.universitymanagement.controller;

import com.universitymanagementapp.universitymanagement.entity.Student;
import com.universitymanagementapp.universitymanagement.repository.BatchRepository;
import com.universitymanagementapp.universitymanagement.repository.DepartmentRepository;
import com.universitymanagementapp.universitymanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * @author Abdur Rahim Nishad
 * @created 13/01/2021 - 9:08 PM
 * @project universitymanagement
 */
@Controller
public class HomeController {
//    @Autowired
//    private StudentRepository studentRepository;
//    private final DepartmentRepository departmentRepository;
//    private final BatchRepository batchRepository;
    @GetMapping("/")
    public String home(){
        return "index";
    }

//    public HomeController(StudentRepository studentRepository, DepartmentRepository departmentRepository, BatchRepository batchRepository) {
//        this.studentRepository = studentRepository;
//        this.departmentRepository = departmentRepository;
//        this.batchRepository = batchRepository;
//    }
//
//    @GetMapping("/")
//    public String getAll(Model model) {
//        model.addAttribute("departmentList", departmentRepository.findAll());
//        model.addAttribute("batchList", batchRepository.findAll());
//        return "student/manage-student";
//    }
//
//    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody Student saveStudent(@RequestBody Student student) {
//        studentRepository.save(student);
//        return student;
//    }
//    @GetMapping("/all")
//    public String getAllStudent(Model m) {
//        List<Student> students = studentRepository.findAll();
//        m.addAttribute("students", students);
//        return "student/view";
//    }
//
//    @GetMapping("/add")
//    public String add(Model m) {
//        m.addAttribute("student", new Student());
//        m.addAttribute("departmentList", departmentRepository.findAll());
//        m.addAttribute("batchList", batchRepository.findAll());
//        return "student/add";
//    }
//
//    @PostMapping("/save")
//    public RedirectView add(@ModelAttribute("student") Student student) {
//        System.out.println(student.name());
//        studentRepository.save(student);
//        return new RedirectView("/student/");
//    }
}
