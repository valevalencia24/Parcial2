package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    private final IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    @GetMapping("/by-classroom")
    public List<PullRequest> findByClassroomAndStatus(@RequestParam("classroomName") String classroomName,
                                                      @RequestParam("status") String status) {
        return pullRequestRepository
                .findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(classroomName, status);
    }
}
