package com.universitymanagementapp.universitymanagement.repository;

import com.universitymanagementapp.universitymanagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 5:02 PM
 * @project university management
 */
@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
}
