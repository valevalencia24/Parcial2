package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommitRepository extends JpaRepository<Commit, Long> {

    List<Commit> findByRepository_ParentRepository_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
            String templateName, String keyword, Integer minLinesAdded);


}
