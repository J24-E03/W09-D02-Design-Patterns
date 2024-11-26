package LabAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Developer extends Employee implements Department {

    private static final ArrayList<String> possibleLanguages = new ArrayList<>(Arrays.asList("Java", "Python", "JavaScript"));

    private final String programmingLanguage;

    public Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    private static void addProgrammingLanguage(String programmingLanguage) {
        if (possibleLanguages.contains(programmingLanguage)) {
            System.out.println(programmingLanguage + " already exists!");
        } else {
            possibleLanguages.add(programmingLanguage);
        }
    }

    @Override
    protected void calculateBonus() {
        setSalary((getSalary() * 20.0) / 100.0);
    }

    @Override
    public void assignDepartment(String name) {

    }

    @Override
    public String getDepartmentName() {
        return "";
    }

    @Override
    public double calculateBonus(int days) {
        return 0;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}