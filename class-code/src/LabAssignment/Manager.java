package LabAssignment;

import java.util.Collection;
import java.util.Iterator;

public class Manager extends Employee implements Department{

    public Manager(int id, String name, double salary){
        super(id, name, salary);
    }

    @Override
    public double calculateBonus(int days) {
        return 0;
    }

    @Override
    protected void calculateBonus() {
        setSalary((getSalary() * 30) / 100);
    }

    @Override
    public String getDepartmentName() {
        return "";
    }

    @Override
    public void assignDepartment(String name) {

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