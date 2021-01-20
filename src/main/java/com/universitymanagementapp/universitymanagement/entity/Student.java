package com.universitymanagementapp.universitymanagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Abdur Rahim Nishad
 * @created 08/01/2021 - 8:24 PM
 * @project universitymanagement
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(fluent = true, chain = true)
@Table(name = "student_tbl")
public class Student implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(name = "course_student",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name= "course_id"))
//    private Set<Course> courses;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(name = "student_semester",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name= "semester_id"))
//    private Set<Semester> semesters;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "batch_id")
    private Batch batch;

    @OneToOne(mappedBy = "student")
    private Enrollment enrollment;
//
////    @ManyToMany(fetch = FetchType.LAZY,
////            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
////                    CascadeType.DETACH, CascadeType.REFRESH})
////    @JoinTable(name = "session_student",
////            joinColumns = @JoinColumn(name = "student_id"),
////            inverseJoinColumns = @JoinColumn(name= "session_id"))
////    private Set<Session> sessions;
}
