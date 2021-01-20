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
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(fluent = true, chain = true)
@Table(name = "department_tbl")
public class Department implements Serializable {
 @Id
 @GeneratedValue(generator = "uuid")
 @GenericGenerator(name = "uuid", strategy = "uuid2")
 @Column(name = "id", unique = true)
 private String id;

 private String name;
// @ManyToMany(fetch = FetchType.LAZY,
//         cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                 CascadeType.DETACH, CascadeType.REFRESH})
// @JoinTable(name = "semester_department",
//         joinColumns = @JoinColumn(name = "department_id"),
//         inverseJoinColumns = @JoinColumn(name= "semester_id"))
// private Set<Semester> semesters;

 @OneToMany(mappedBy = "department", cascade= CascadeType.ALL)
 private Set<Course> courses;

// @ManyToMany(fetch = FetchType.LAZY,
//         cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                 CascadeType.DETACH, CascadeType.REFRESH})
// @JoinTable(name = "session_department",
//         joinColumns = @JoinColumn(name = "department_id"),
//         inverseJoinColumns = @JoinColumn(name= "session_id"))
// private Set<Session> sessions;

 @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
 private Set<Student> students;
}
