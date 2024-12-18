package org.dcistudent;

import org.dcistudent.models.managementsystem.AbstractEmployee;
import org.dcistudent.models.managementsystem.Manager;
import org.dcistudent.services.managementsystem.DepartmentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Map<String, AbstractEmployee> employees = new HashMap<>();
        employees.put("1", new Manager(1, "John Doe", 100000.0).assignDepartment("Engineering"));
        DepartmentService departmentService = new DepartmentService(employees);

        Scanner scanner = new Scanner(System.in);
        System.out.println("# Adding an employee #");
        System.out.println("Enter employee ID: ");
        Integer employeeId = scanner.nextInt();
        System.out.println("Enter employee name: ");
        String employeeName = scanner.next();
        System.out.println("Enter employee salary: ");
        Double employeeSalary = scanner.nextDouble();
        departmentService.addEmployee(employeeId, employeeName, employeeSalary);
        System.out.println("Employee added successfully!");

        System.out.println("# Removing an employee #");
        System.out.println("Enter employee ID: ");
        Integer employeeIdToRemove = scanner.nextInt();
        departmentService.removeEmployeeById(employeeIdToRemove);
        System.out.println("Employee removed successfully!");

        System.out.println("# Employee list #");
        System.out.println(departmentService.getEmployees().toString());

        System.out.println("# Finding employees by ID #");
        System.out.println("Enter employee ID: ");
        Integer employeeIdToFind = scanner.nextInt();
        AbstractEmployee employeeFound = departmentService.findEmployeeById(employeeIdToFind);
        System.out.println("Found employee: " + employeeFound.toString());

        System.out.println("# Finding employees by department #");
        System.out.println("Enter department: ");
        String department = scanner.next();
        String employeesForDepartment = departmentService.findEmployeesByDepartment(department);
        System.out.println("Found employees: " + employeesForDepartment);
    }
}