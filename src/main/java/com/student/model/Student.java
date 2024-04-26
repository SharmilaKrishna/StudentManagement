package com.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    @JsonProperty("id")
    private Long id;
    
    @Getter @Setter
    @JsonProperty("name")
    private String name;
    
    @Getter @Setter
    @JsonProperty("studentId")
    private String studentId;
    
    @Getter @Setter
    @JsonProperty("grade")
    private String grade;
    
    @Getter @Setter
    @JsonProperty("mobileNumber") 
    private String mobileNumber;
    
    @Getter @Setter
    @JsonProperty("schoolName")
    private String schoolName;
}
