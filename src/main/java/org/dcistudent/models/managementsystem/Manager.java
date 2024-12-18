package org.dcistudent.models.managementsystem;

import lombok.Getter;
import org.dcistudent.interfaces.models.managementsystem.Department;

@Getter
public class Manager extends AbstractEmployee implements Department {
    private String department = "";

    public Manager(Integer id, String name, Double salary) {
        super(id, name, salary);
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public Manager assignDepartment(String name) {
        this.department = name;

        return this;
    }

    @Override
    protected Double calculateBonus() {
        return this.getSalary() * 0.3;
    }

    @Override
    public String toString() {
        return "Manager [id=" + getId() + ", name=" + getName() + ", salary=" + getSalary() + "]";
    }
}
