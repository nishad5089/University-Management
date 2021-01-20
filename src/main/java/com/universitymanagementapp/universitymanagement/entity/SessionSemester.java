package com.universitymanagementapp.universitymanagement.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 1:07 PM
 * @project universitymanagement
 */

//@Builder
//@Accessors(fluent = true, chain = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "session_semester_tbl")
public class SessionSemester implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "session_semester_name")
    private String name;

    @OneToMany(mappedBy = "sessionSemester", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "sessionSemester", cascade = CascadeType.ALL)
    private Set<Course> courses;
}
