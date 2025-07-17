package com.mycompany.employee.service.mapper;

import com.mycompany.employee.domain.Job;
import com.mycompany.employee.service.dto.JobDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Job} and its DTO {@link JobDTO}.
 */
@Mapper(componentModel = "spring")
public interface JobMapper extends EntityMapper<JobDTO, Job> {}
