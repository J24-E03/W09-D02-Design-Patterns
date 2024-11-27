import java.util.HashSet;
import java.util.Set;

public class Employees {
    private HashSet<Employee> employees = new HashSet<>();

    // Add an employee to the Set (version 1)
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    //Version 2: Accepts id, name, salary, and role to create and add the employee.
    public void addEmployee(int id, String name, double salary, String role) {
        Employee employee;
        if (role.equalsIgnoreCase("Developer")) {
            employee = new Developer(id, name, salary, "java"); // default language
        } else {
            employee = new Manager(id, name, salary);
        }
        employees.add(employee);
    }

    //Remove an employee from a department.
    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    // Display all employees
    public void displayAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
