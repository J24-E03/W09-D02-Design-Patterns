package org.dcistudent.models.managementsystem;

import lombok.*;
import org.dcistudent.interfaces.models.managementsystem.Department;

import java.util.List;

@Getter @Setter
public class Developer extends AbstractEmployee implements Department {
    private String programmingLanguage;
    private static List<String> programmingLanguagesAvailable = List.of("Java", "Python", "JavaScript");
    private String department = "";

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
        return "Developer [id=" + getId() +
                ", name=" + getName() +
                ", salary=" + getSalary() +
                ", programmingLanguage=" + this.getProgrammingLanguage() + "]";
    }
}
