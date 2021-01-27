package com.universitymanagementapp.universitymanagement.controller;

import com.universitymanagementapp.universitymanagement.dto.CourseDto;
import com.universitymanagementapp.universitymanagement.dto.StudentDto;
import com.universitymanagementapp.universitymanagement.entity.*;
import com.universitymanagementapp.universitymanagement.repository.BatchRepository;
import com.universitymanagementapp.universitymanagement.repository.DepartmentRepository;
import com.universitymanagementapp.universitymanagement.repository.SessionSemesterRepository;
import com.universitymanagementapp.universitymanagement.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final BatchRepository batchRepository;
    private final SessionSemesterRepository sessionSemesterRepository;

    public StudentController(StudentRepository studentRepository, DepartmentRepository departmentRepository, BatchRepository batchRepository, SessionSemesterRepository sessionSemesterRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.batchRepository = batchRepository;
        this.sessionSemesterRepository = sessionSemesterRepository;
    }

    @GetMapping("/")
    public String getStudentForm(Model m) {
        m.addAttribute("departmentList", departmentRepository.findAll());
        m.addAttribute("batchList", batchRepository.findAll());
        m.addAttribute("semesterList", sessionSemesterRepository.findAll());
        return "student/add_student";
    }


    @GetMapping(value = "/getAll", consumes = "application/json", produces = "application/json")
    public @ResponseBody List<StudentDto> getAllStudent_onLoad() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student: studentList) {
            StudentDto studentDto  = new ModelMapper().map(student,StudentDto.class);
            studentDto.setBatchName(student.getBatch().getName());
            studentDto.setDepName(student.getDepartment().getName());
            studentDto.setSemesterName(student.getSemester().getName());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }


@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody StudentDto saveStudent(@RequestBody StudentDto studentDto) {
    Department department = departmentRepository.getOne(studentDto.getDepId());
    SessionSemester sessionSemester = sessionSemesterRepository.getOne(studentDto.getSemesterId());
    Batch batch = batchRepository.getOne(studentDto.getBatchId());
    Student student = new ModelMapper().map(studentDto,Student.class);
    student.setBatch(batch);
    student.setSemester(sessionSemester);
    student.setDepartment(department);
    studentRepository.save(student);
    StudentDto studentDto1 = new ModelMapper().map(student, StudentDto.class);
    studentDto1.setDepName(department.getName());
    studentDto1.setSemesterName(sessionSemester.getName());
    studentDto1.setBatchName(batch.getName());
    return studentDto1;
}

    @GetMapping(value = "/getOne/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody StudentDto getOne(@PathVariable("id") String id) {
        Student studentTemp = studentRepository.findById(id).get();
        StudentDto studentDtoTemp = new StudentDto();

        BeanUtils.copyProperties(studentTemp, studentDtoTemp);
        studentDtoTemp.setDepId(studentTemp.getDepartment().getId());
        studentDtoTemp.setDepName(studentTemp.getDepartment().getName());

        studentDtoTemp.setBatchId(studentTemp.getBatch().getId());
        studentDtoTemp.setBatchName(studentTemp.getBatch().getName());
        return studentDtoTemp;
    }
    @GetMapping(value = "/getCourse/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody List<CourseDto> getCourseWithSemester(@PathVariable("id") String id){
           SessionSemester sessionSemester = sessionSemesterRepository.findById(id).get();
           List<Course> courses =  sessionSemester.getCourses().stream().collect(Collectors.toList());
           List<CourseDto> courseDtos = new ArrayList<>();
           for (Course c : courses){
               CourseDto courseDto  = new ModelMapper().map(c,CourseDto.class);
               courseDtos.add(courseDto);
           }
        return courseDtos;
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<StudentDto> update(@RequestBody StudentDto studentDto) {
        Department department = departmentRepository.getOne(studentDto.getDepId());
        Batch batch = batchRepository.getOne(studentDto.getBatchId());
        Student student = studentRepository.findById(studentDto.getId()).get();
        student.setDepartment(department);
        student.setBatch(batch);
        student.setSemester(sessionSemesterRepository.getOne(studentDto.getSemesterId()));
        studentRepository.save(student);
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = new ArrayList<>();

        for (Student student1: studentList) {
            StudentDto sTemp = new StudentDto();
            BeanUtils.copyProperties(student1, sTemp);
            sTemp.setDepName(student1.getDepartment().getName());
            sTemp.setBatchName(student1.getBatch().getName());
            studentDtoList.add(sTemp);
        }
        return studentDtoList;
    }

}
