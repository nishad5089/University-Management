package com.universitymanagementapp.universitymanagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 12:35 PM
 * @project universitymanagement
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "batch_tbl")
public class Batch implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    private Set<Student> students;
}
