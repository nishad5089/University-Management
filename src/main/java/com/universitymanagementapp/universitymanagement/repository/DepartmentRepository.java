package com.universitymanagementapp.universitymanagement.repository;

import com.universitymanagementapp.universitymanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 5:13 PM
 * @project university management
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
