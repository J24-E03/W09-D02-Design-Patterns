package org.dcistudent.models.managementsystem;

import lombok.*;

@Getter @Setter
public abstract class AbstractEmployee {
    private Integer id;
    private String name;
    protected Double salary;
    private static String companyName = "DCI";

    protected AbstractEmployee(Integer id, String name, Double salary) {
        this.setId(id);
        this.setName(name);
        this.setSalary(salary);
    }

    public abstract AbstractEmployee assignDepartment(String name);
    public abstract String getDepartment();
    protected abstract Double  calculateBonus();

    public final String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + this.getId() + ", name=" + this.getName() + ", salary=" + this.getSalary() + "]";
    }
}
