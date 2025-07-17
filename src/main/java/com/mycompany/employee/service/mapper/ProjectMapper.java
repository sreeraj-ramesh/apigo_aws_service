package com.mycompany.employee.service.mapper;

import com.mycompany.employee.domain.Employee;
import com.mycompany.employee.domain.Project;
import com.mycompany.employee.service.dto.EmployeeDTO;
import com.mycompany.employee.service.dto.ProjectDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Project} and its DTO {@link ProjectDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
    @Mapping(target = "employees", source = "employees", qualifiedByName = "employeeIdSet")
    ProjectDTO toDto(Project s);

    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "removeEmployees", ignore = true)
    Project toEntity(ProjectDTO projectDTO);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);

    @Named("employeeIdSet")
    default Set<EmployeeDTO> toDtoEmployeeIdSet(Set<Employee> employee) {
        return employee.stream().map(this::toDtoEmployeeId).collect(Collectors.toSet());
    }
}
