package com.restful.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "classes")
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "classname")
    private String classname;

    @Column(name = "address")
    private String address;

    @OneToMany(
            // 指定关联的另一方实体
            targetEntity = Student.class,
            // 级联操作
            cascade = CascadeType.ALL,
            // 延迟加载
            fetch = FetchType.LAZY)
    @JoinColumn(name = "classes_id")
    @JsonManagedReference
    private List<Student> students;
}
