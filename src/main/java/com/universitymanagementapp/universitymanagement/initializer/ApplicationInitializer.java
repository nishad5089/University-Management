package com.universitymanagementapp.universitymanagement.initializer;

import com.universitymanagementapp.universitymanagement.entity.*;
import com.universitymanagementapp.universitymanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 5:07 PM
 * @project universitymanagement
 */
@Component
public class ApplicationInitializer implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SessionSemesterRepository sessionSemesterRepository;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Override
    public void run(String... args) throws Exception {
//        Department dpt = new Department(); dpt.setName("EEE");
//        departmentRepository.save(dpt);
//        Department dpt1 = new Department(); dpt1.setName("ETE");
//        departmentRepository.save(dpt1);
//

//        Department dpt =  departmentRepository.getOne("06e1cddf-2e10-491e-8c83-dc8d5326d8e2");
//        Set<Course> courses = new HashSet<>();
//        Course course  = new Course();course.setName("CSE-101"); course.setDepartment(dpt);
//        courseRepository.save(course);
//        Course course2 =  new Course();course2.setName("CSE-102");course2.setDepartment(dpt);
//        courseRepository.save(course2);
//        Course course3 =  new Course();course3.setName("CSE-103");course3.setDepartment(dpt);
//        courseRepository.save(course3);
//        courses.add(course);
//        courses.add(course2);
//        courses.add(course3);
//
//        Batch batch = new Batch();batch.setName("43");
//        batchRepository.save(batch);
//        Batch batch1 = new Batch();batch1.setName("44");
//        batchRepository.save(batch1);
//
//
//        Student std = new Student(); std.setName("Fahim");
//        std.setBatch(batch);
//        std.setDepartment(dpt);
//        studentRepository.save(std);
//
//        Student std2 = new Student();
//        std2.setName("faisal");std2.setBatch(batch);std2.setDepartment(dpt);
//        studentRepository.save(std2);
////
//        SessionSemester sessionSemester = new SessionSemester().name("1st");
//        sessionSemesterRepository.save(sessionSemester);

//        SessionSemester s1 = new SessionSemester();
//        s1.setName("1st");
//        sessionSemesterRepository.save(s1);
//        SessionSemester s2 = new SessionSemester();
//        s2.setName("2nd");
//        sessionSemesterRepository.save(s2);
//        SessionSemester s3 = new SessionSemester();
//        s3.setName("3rd");
//        sessionSemesterRepository.save(s3);


//        Enrollment enrollment = new Enrollment().student(std).courses(courses).sessionSemester(s1);
//        enrollmentRepository.save(enrollment);
//
    }
}
