package com.universitymanagementapp.universitymanagement.repository;

import com.universitymanagementapp.universitymanagement.entity.SessionSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Abdur Rahim Nishad
 * @created 09/01/2021 - 5:03 PM
 * @project university management
 */
@Repository
public interface SessionSemesterRepository extends JpaRepository<SessionSemester,String> {
}
