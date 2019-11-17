package edu.hm.hafner.warningsngui.service;

import edu.hm.hafner.warningsngui.dto.Job;
import edu.hm.hafner.warningsngui.mapper.JobMapper;
import edu.hm.hafner.warningsngui.model.JobEntity;
import edu.hm.hafner.warningsngui.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobEntityService {

    @Autowired
    JobRepository jobRepository;


    public List<Job> findAll() {
        List<JobEntity> jobEntities = jobRepository.findAll();
        return JobMapper.map(jobEntities);
    }

    public List<Job> saveAll(List<Job> jobs) {
        List<JobEntity> jobEntities = jobRepository.saveAll(JobMapper.mapToEntities(jobs));
        List<Job> savedJobs = JobMapper.map(jobEntities);
        return savedJobs;
    }

    public Job save (Job job) {
        JobEntity jobEntity = jobRepository.save(JobMapper.mapToEntity(job));
        return JobMapper.map(jobEntity);
    }
}