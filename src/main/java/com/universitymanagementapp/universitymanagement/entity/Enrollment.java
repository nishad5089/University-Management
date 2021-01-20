package com.universitymanagementapp.universitymanagement.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 12:51 PM
 * @project universitymanagement
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(fluent = true, chain = true)
@Table(name = "enrollment_tbl")
public class Enrollment implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH})
    @JoinColumn(name = "session_semester_id")
    private SessionSemester sessionSemester;

    @OneToOne(cascade = {CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


     @ManyToMany(fetch = FetchType.LAZY,
         cascade= {CascadeType.MERGE,
                 CascadeType.DETACH, CascadeType.REFRESH})
     @JoinTable(name = "course_enrollment",
         joinColumns = @JoinColumn(name = "enrollment_id"),
         inverseJoinColumns = @JoinColumn(name= "course_id"))
    private Set<Course> courses;
}
