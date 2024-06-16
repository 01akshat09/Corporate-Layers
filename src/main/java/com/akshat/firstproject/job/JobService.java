package com.akshat.firstproject.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void postJob(Job job);
    Job findJobById(Long id);
    boolean deleteJob(Long id);
    boolean putJob(Long id, Job updatedJob);
}
