package com.restful.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classno;
    private String classname;
    @OneToMany
    private List<Student> students;

}
