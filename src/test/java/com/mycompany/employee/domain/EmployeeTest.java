package com.mycompany.employee.domain;

import static com.mycompany.employee.domain.AddressTestSamples.*;
import static com.mycompany.employee.domain.DepartmentTestSamples.*;
import static com.mycompany.employee.domain.EmployeeTestSamples.*;
import static com.mycompany.employee.domain.JobTestSamples.*;
import static com.mycompany.employee.domain.ProjectTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.employee.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Employee.class);
        Employee employee1 = getEmployeeSample1();
        Employee employee2 = new Employee();
        assertThat(employee1).isNotEqualTo(employee2);

        employee2.setId(employee1.getId());
        assertThat(employee1).isEqualTo(employee2);

        employee2 = getEmployeeSample2();
        assertThat(employee1).isNotEqualTo(employee2);
    }

    @Test
    void departmentTest() {
        Employee employee = getEmployeeRandomSampleGenerator();
        Department departmentBack = getDepartmentRandomSampleGenerator();

        employee.setDepartment(departmentBack);
        assertThat(employee.getDepartment()).isEqualTo(departmentBack);

        employee.department(null);
        assertThat(employee.getDepartment()).isNull();
    }

    @Test
    void jobTest() {
        Employee employee = getEmployeeRandomSampleGenerator();
        Job jobBack = getJobRandomSampleGenerator();

        employee.setJob(jobBack);
        assertThat(employee.getJob()).isEqualTo(jobBack);

        employee.job(null);
        assertThat(employee.getJob()).isNull();
    }

    @Test
    void addressTest() {
        Employee employee = getEmployeeRandomSampleGenerator();
        Address addressBack = getAddressRandomSampleGenerator();

        employee.setAddress(addressBack);
        assertThat(employee.getAddress()).isEqualTo(addressBack);

        employee.address(null);
        assertThat(employee.getAddress()).isNull();
    }

    @Test
    void projectsTest() {
        Employee employee = getEmployeeRandomSampleGenerator();
        Project projectBack = getProjectRandomSampleGenerator();

        employee.addProjects(projectBack);
        assertThat(employee.getProjects()).containsOnly(projectBack);

        employee.removeProjects(projectBack);
        assertThat(employee.getProjects()).doesNotContain(projectBack);

        employee.projects(new HashSet<>(Set.of(projectBack)));
        assertThat(employee.getProjects()).containsOnly(projectBack);

        employee.setProjects(new HashSet<>());
        assertThat(employee.getProjects()).doesNotContain(projectBack);
    }
}
