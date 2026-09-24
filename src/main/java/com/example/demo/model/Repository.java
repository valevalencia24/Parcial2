package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_template", nullable = false)
    private Boolean isTemplate;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "parent_repo_id")
    private Repository parentRepository;

    @JsonIgnore
    @OneToMany(mappedBy = "parentRepository")
    private List<Repository> derivedRepositories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "repository")
    private List<PullRequest> pullRequests = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "repository")
    private List<Commit> commits = new ArrayList<>();
}



