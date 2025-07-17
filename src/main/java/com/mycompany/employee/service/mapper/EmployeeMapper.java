package com.mycompany.employee.service.mapper;

import com.mycompany.employee.domain.Address;
import com.mycompany.employee.domain.Department;
import com.mycompany.employee.domain.Employee;
import com.mycompany.employee.domain.Job;
import com.mycompany.employee.domain.Project;
import com.mycompany.employee.service.dto.AddressDTO;
import com.mycompany.employee.service.dto.DepartmentDTO;
import com.mycompany.employee.service.dto.EmployeeDTO;
import com.mycompany.employee.service.dto.JobDTO;
import com.mycompany.employee.service.dto.ProjectDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Employee} and its DTO {@link EmployeeDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDTO, Employee> {
    @Mapping(target = "department", source = "department", qualifiedByName = "departmentName")
    @Mapping(target = "job", source = "job", qualifiedByName = "jobTitle")
    @Mapping(target = "address", source = "address", qualifiedByName = "addressCity")
    @Mapping(target = "projects", source = "projects", qualifiedByName = "projectNameSet")
    EmployeeDTO toDto(Employee s);

    @Mapping(target = "removeProjects", ignore = true)
    Employee toEntity(EmployeeDTO employeeDTO);

    @Named("departmentName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DepartmentDTO toDtoDepartmentName(Department department);

    @Named("jobTitle")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    JobDTO toDtoJobTitle(Job job);

    @Named("addressCity")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "city", source = "city")
    AddressDTO toDtoAddressCity(Address address);

    @Named("projectName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    ProjectDTO toDtoProjectName(Project project);

    @Named("projectNameSet")
    default Set<ProjectDTO> toDtoProjectNameSet(Set<Project> project) {
        return project.stream().map(this::toDtoProjectName).collect(Collectors.toSet());
    }
}
