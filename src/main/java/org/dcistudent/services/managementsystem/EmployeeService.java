package org.dcistudent.services.managementsystem;

import lombok.*;
import org.dcistudent.models.managementsystem.AbstractEmployee;

import java.util.Set;

@Getter @Setter
public final class EmployeeService {
    private Set<AbstractEmployee> employees;

    public EmployeeService(Set<AbstractEmployee> employees) {
        this.getEmployees().addAll(employees);
    }

    @Override
    public String toString() {
        return "EmployeeService [employees=" + this.getEmployees() + "]";
    }
}
