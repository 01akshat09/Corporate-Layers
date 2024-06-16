package com.akshat.firstproject.job;

import com.akshat.firstproject.job.impl.JobServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobs;

    public JobController(JobServiceImpl jobs) {
        this.jobs = jobs;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
       return ResponseEntity.ok(jobs.findAll());
    }

    @PostMapping
    public ResponseEntity<String> postJob(@RequestBody Job job) {
        jobs.postJob(job);
        return new ResponseEntity<>("Job added Successfully", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> findJobById(@PathVariable Long id) {
        Job job = jobs.findJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean deleted = jobs.deleteJob(id);
        if(deleted) {
            return ResponseEntity.ok("Job Deleted Successfully.");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobs.putJob(id, updatedJob);
        if(updated) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
