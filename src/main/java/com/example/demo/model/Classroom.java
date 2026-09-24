package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column (name = "course_code")
    private String courseCode;

    @Column (name = "semester")
    private String semester;

    @ManyToOne
    @JoinColumn (name = "teacher_id", nullable = false)
    private User teacher;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Assignment> assignments = new ArrayList<>();


}
