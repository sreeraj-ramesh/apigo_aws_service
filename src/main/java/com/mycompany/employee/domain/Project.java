package com.mycompany.employee.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Project.
 */
@Entity
@Table(name = "project")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "start_date")
    private Instant startDate;

    @Column(name = "end_date")
    private Instant endDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "project" }, allowSetters = true)
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "department", "job", "address", "projects" }, allowSetters = true)
    private Set<Employee> employees = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Project id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Project name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getStartDate() {
        return this.startDate;
    }

    public Project startDate(Instant startDate) {
        this.setStartDate(startDate);
        return this;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return this.endDate;
    }

    public Project endDate(Instant endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Set<Task> tasks) {
        if (this.tasks != null) {
            this.tasks.forEach(i -> i.setProject(null));
        }
        if (tasks != null) {
            tasks.forEach(i -> i.setProject(this));
        }
        this.tasks = tasks;
    }

    public Project tasks(Set<Task> tasks) {
        this.setTasks(tasks);
        return this;
    }

    public Project addTasks(Task task) {
        this.tasks.add(task);
        task.setProject(this);
        return this;
    }

    public Project removeTasks(Task task) {
        this.tasks.remove(task);
        task.setProject(null);
        return this;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        if (this.employees != null) {
            this.employees.forEach(i -> i.removeProjects(this));
        }
        if (employees != null) {
            employees.forEach(i -> i.addProjects(this));
        }
        this.employees = employees;
    }

    public Project employees(Set<Employee> employees) {
        this.setEmployees(employees);
        return this;
    }

    public Project addEmployees(Employee employee) {
        this.employees.add(employee);
        employee.getProjects().add(this);
        return this;
    }

    public Project removeEmployees(Employee employee) {
        this.employees.remove(employee);
        employee.getProjects().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Project)) {
            return false;
        }
        return getId() != null && getId().equals(((Project) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Project{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }
}
