package com.universitymanagementapp.universitymanagement.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Abdur Rahim Nishad
 * @created 13/01/2021 - 10:59 PM
 * @project universitymanagement
 */
@Data
public class StudentDto {
    private String id;
    private String name;
    private String depId;
    private String depName;
    private String batchId;
    private String batchName;
    private List<String> courseName;
    private String semesterId;
    private String semesterName;
}