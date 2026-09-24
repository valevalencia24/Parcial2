package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline", nullable = false, unique = true)
    private LocalDate deadline;

    @Column(name = "max_score", nullable = false)
    private Integer maxScore;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "assignment", cascade = CascadeType.ALL)
    private Repository repositories;
}
