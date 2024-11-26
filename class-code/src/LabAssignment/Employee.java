package LabAssignment;

import java.util.HashSet;
import java.util.Set;

public abstract class Employee {

    //          Fields and Attributes:
    private int id;
    private String name;
    private double salary;

    protected static final Set<Employee> employees = new HashSet<>();

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    //          Getters:
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    //          Setters:
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    protected abstract double calculateBonus(int days);

    public void displayUserInfo() {
        System.out.println("id: " + id + ", name: " + name + ", salary: " + salary);
    }


    protected abstract void calculateBonus();
}