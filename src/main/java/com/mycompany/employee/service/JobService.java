package com.mycompany.employee.service;

import com.mycompany.employee.domain.Job;
import com.mycompany.employee.repository.JobRepository;
import com.mycompany.employee.service.dto.JobDTO;
import com.mycompany.employee.service.mapper.JobMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.employee.domain.Job}.
 */
@Service
@Transactional
public class JobService {

    private static final Logger LOG = LoggerFactory.getLogger(JobService.class);

    private final JobRepository jobRepository;

    private final JobMapper jobMapper;

    public JobService(JobRepository jobRepository, JobMapper jobMapper) {
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
    }

    /**
     * Save a job.
     *
     * @param jobDTO the entity to save.
     * @return the persisted entity.
     */
    public JobDTO save(JobDTO jobDTO) {
        LOG.debug("Request to save Job : {}", jobDTO);
        Job job = jobMapper.toEntity(jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    /**
     * Update a job.
     *
     * @param jobDTO the entity to save.
     * @return the persisted entity.
     */
    public JobDTO update(JobDTO jobDTO) {
        LOG.debug("Request to update Job : {}", jobDTO);
        Job job = jobMapper.toEntity(jobDTO);
        job = jobRepository.save(job);
        return jobMapper.toDto(job);
    }

    /**
     * Partially update a job.
     *
     * @param jobDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<JobDTO> partialUpdate(JobDTO jobDTO) {
        LOG.debug("Request to partially update Job : {}", jobDTO);

        return jobRepository
            .findById(jobDTO.getId())
            .map(existingJob -> {
                jobMapper.partialUpdate(existingJob, jobDTO);

                return existingJob;
            })
            .map(jobRepository::save)
            .map(jobMapper::toDto);
    }

    /**
     * Get all the jobs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<JobDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Jobs");
        return jobRepository.findAll(pageable).map(jobMapper::toDto);
    }

    /**
     * Get one job by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JobDTO> findOne(Long id) {
        LOG.debug("Request to get Job : {}", id);
        return jobRepository.findById(id).map(jobMapper::toDto);
    }

    /**
     * Delete the job by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete Job : {}", id);
        jobRepository.deleteById(id);
    }
}
