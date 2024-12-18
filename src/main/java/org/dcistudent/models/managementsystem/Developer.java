package org.dcistudent.models.managementsystem;

import lombok.*;
import org.dcistudent.interfaces.models.managementsystem.Department;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class Developer extends AbstractEmployee implements Department {
    private String programmingLanguage;
    private static Set<String> programmingLanguagesAvailable = new HashSet<>();
    private String department = "";

    static {
        programmingLanguagesAvailable.add("Java");
        programmingLanguagesAvailable.add("Python");
        programmingLanguagesAvailable.add("JavaScript");
    }

    public Developer(Integer id, String name, Double salary, String programmingLanguage) {
        super(id, name, salary);
        this.setProgrammingLanguage(programmingLanguage);
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        if (programmingLanguagesAvailable.contains(programmingLanguage)) {
            this.programmingLanguage = programmingLanguage;
            return;
        }

        throw new IllegalArgumentException("Invalid programming language");
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public Developer assignDepartment(String name) {
        this.department = name;

        return this;
    }

    public static void addProgrammingLanguage(String programmingLanguage) {
        programmingLanguagesAvailable.add(programmingLanguage);
    }

    @Override
    protected Double calculateBonus() {
        return this.getSalary() * 0.2;
    }

    @Override
    public String toString() {
        return "Developer [id=" + this.getId() +
                ", name=" + this.getName() +
                ", salary=" + this.getSalary() +
                ", programmingLanguage=" + this.getProgrammingLanguage() + "]";
    }
}
