package tn.capgemini.Emploxi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.capgemini.Emploxi.entities.JobNameCG;
import tn.capgemini.Emploxi.repositories.JobNameCGRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobNameCGService {

    @Autowired
    private JobNameCGRepository jobNameCGRepository;

    public List<JobNameCG> getAllJobNames() {
        return jobNameCGRepository.findAll();
    }

    public Optional<JobNameCG> getJobNameById(Long id) {
        return jobNameCGRepository.findById(id);
    }

    public JobNameCG saveJobName(JobNameCG jobName) {
        return jobNameCGRepository.save(jobName);
    }

    public void deleteJobName(Long id) {
        jobNameCGRepository.deleteById(id);
    }
}
