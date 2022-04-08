package com.javarunner.springrestvalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="USER_TBL")
@Entity
@Data
@AllArgsConstructor (staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private Integer age;
    private String nationality;



}
