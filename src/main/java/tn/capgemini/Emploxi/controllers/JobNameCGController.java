package tn.capgemini.Emploxi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.capgemini.Emploxi.entities.JobNameCG;
import tn.capgemini.Emploxi.services.JobNameCGService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/api/jobnames")
public class JobNameCGController {

    @Autowired
    private JobNameCGService jobNameCGService;

    @GetMapping
    public ResponseEntity<List<JobNameCG>> getAllJobNames() {
        List<JobNameCG> jobNames = jobNameCGService.getAllJobNames();
        return new ResponseEntity<>(jobNames, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobNameCG> getJobNameById(@PathVariable Long id) {
        Optional<JobNameCG> jobName = jobNameCGService.getJobNameById(id);
        return jobName.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<JobNameCG> createJobName(@RequestBody JobNameCG jobName) {
        JobNameCG newJobName = jobNameCGService.saveJobName(jobName);
        return new ResponseEntity<>(newJobName, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobName(@PathVariable Long id) {
        Optional<JobNameCG> jobName = jobNameCGService.getJobNameById(id);
        if (jobName.isPresent()) {
            jobNameCGService.deleteJobName(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
