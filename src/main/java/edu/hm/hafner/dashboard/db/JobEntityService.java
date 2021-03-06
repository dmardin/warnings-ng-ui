package edu.hm.hafner.dashboard.db;

import edu.hm.hafner.dashboard.db.model.JobEntity;
import edu.hm.hafner.dashboard.db.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to handle the interactions for {@link JobEntity}s with the database by using the {@link JobRepository}.
 *
 * @author Deniz Mardin
 */
@Service
public class JobEntityService {
    private JobRepository jobRepository;

    /**
     * Creates a new instance of {@link JobEntityService}.
     *
     * @param jobRepository the repository for jobs
     */
    @Autowired
    JobEntityService(final JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Fetches all {@link JobEntity}s form the database.
     *
     * @return the fetched {@link JobEntity}s
     */
    public List<JobEntity> findAll() {
        return jobRepository.findAll();
    }

    /**
     * Searches for a job by its name.
     *
     * @param name the name of the job
     * @return the job
     */
    public JobEntity findJobByName(final String name) {
        return jobRepository.findByName(name);
    }

    /**
     * Saves all given {@link JobEntity}s.
     *
     * @param jobEntities the {@link JobEntity}s to save
     * @return the saved {@link JobEntity}s
     */
    public List<JobEntity> saveAll(final List<JobEntity> jobEntities) {
        return jobRepository.saveAll(jobEntities);
    }
}
