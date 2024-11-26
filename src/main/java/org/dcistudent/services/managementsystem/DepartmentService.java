package org.dcistudent.services.managementsystem;

import lombok.*;
import org.dcistudent.models.managementsystem.AbstractEmployee;
import org.dcistudent.models.managementsystem.Manager;

import java.util.Map;

@Getter @Setter
public class DepartmentService {
    private Map<String, AbstractEmployee> employees;

    public DepartmentService(Map<String, AbstractEmployee> employees) {
        this.setEmployees(employees);
    }

    public DepartmentService addEmployee(AbstractEmployee employee) {
        this.getEmployees().put(employee.getName(), employee);

        return this;
    }

    public DepartmentService addEmployee(Integer id, String name, Double salary) {
        this.getEmployees().put(name, new Manager(id, name, salary));

        return this;
    }

    public DepartmentService removeEmployeeByName(String name) {
        this.getEmployees().remove(name);

        return this;
    }

    public DepartmentService removeEmployeeById(Integer id) {
        for (AbstractEmployee employee : this.getEmployees().values()) {
            if (employee.getId().equals(id)) {
                this.getEmployees().remove(employee.getName());
                break;
            }
        }

        return this;
    }

    public String findEmployeesByDepartment(String department) {
        StringBuilder response = new StringBuilder();

        for (AbstractEmployee employee : this.getEmployees().values()) {
            if (employee.getDepartment().equals(department)) {
                response.append(employee).append("\n");
            }
        }

        return response.toString();
    }

    public AbstractEmployee findEmployeeById(Integer id) {
        for (AbstractEmployee employee : this.getEmployees().values()) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }

        throw new RuntimeException("Employee not found");
    }
}
