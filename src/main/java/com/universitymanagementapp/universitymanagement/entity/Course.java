package com.universitymanagementapp.universitymanagement.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 08/01/2021 - 8:24 PM
 * @project universitymanagement
 */
@Entity
@Getter
@Setter
//@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(fluent = true, chain = true)
@Table(name = "course_tbl")
public class Course implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;
//    @ManyToMany(fetch= FetchType.LAZY,
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(
//            name="course_student",
//            joinColumns=@JoinColumn(name="course_id"),
//            inverseJoinColumns=@JoinColumn(name="student_id")
//    )
//    private Set<Student> students;
//
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade= {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "course_enrollment",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name= "enrollment_id"))
    private Set<Enrollment> enrollments;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Enrollment enrollment;
//
//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.DETACH,
//                    CascadeType.REFRESH})
//    @JoinColumn(name = "semester_id")
//    private Semester semester;
//
//    @ManyToMany(fetch= FetchType.LAZY,
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(
//            name="course_session",
//            joinColumns=@JoinColumn(name="course_id"),
//            inverseJoinColumns=@JoinColumn(name="session_id")
//    )
//    private Set<Session> sessions;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "session_semester_id")
    private SessionSemester sessionSemester;
}
