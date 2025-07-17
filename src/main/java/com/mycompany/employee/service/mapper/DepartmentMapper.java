package com.mycompany.employee.service.mapper;

import com.mycompany.employee.domain.Department;
import com.mycompany.employee.service.dto.DepartmentDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Department} and its DTO {@link DepartmentDTO}.
 */
@Mapper(componentModel = "spring")
public interface DepartmentMapper extends EntityMapper<DepartmentDTO, Department> {}
