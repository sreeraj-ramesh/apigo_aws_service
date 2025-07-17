package com.mycompany.employee.service.mapper;

import com.mycompany.employee.domain.Project;
import com.mycompany.employee.domain.Task;
import com.mycompany.employee.service.dto.ProjectDTO;
import com.mycompany.employee.service.dto.TaskDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Task} and its DTO {@link TaskDTO}.
 */
@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDTO, Task> {
    @Mapping(target = "project", source = "project", qualifiedByName = "projectName")
    TaskDTO toDto(Task s);

    @Named("projectName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProjectDTO toDtoProjectName(Project project);
}
