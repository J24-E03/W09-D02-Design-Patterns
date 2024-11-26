import employees.Developer;
import employees.Employee;
import employees.Manager;

import java.util.*;

public class Main {
    private static final String MANAGER = "Manager";
    private static final String DEVELOPER = "Developer";
    private static final String DEVELOPMENT_DEPARTMENT = "Development";
    private static final String MANAGEMENT_DEPARTMENT = "Management";


    private static final Set<Employee> employees = new HashSet<>();
    private static final Map<String, List<Employee>> departmentEmployeesMap = new HashMap<>();

    public static void main(String[] args) {

        departmentEmployeesMap.put("Management", new ArrayList<>());
        departmentEmployeesMap.put("Development", new ArrayList<>());

        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("Choose an option:");
            System.out.println("1. Add a new employee");
            System.out.println("2. Remove an employee by ID");
            System.out.println("3. Display all employees");
            System.out.println("4. Search for an employee by ID");
            System.out.println("5. Display employees of a specific department");
            System.out.println("6. Display all departments");
            System.out.println("7. Exit");
            System.out.println("What is your choose? ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNewEmployee(sc);
                    break;
                case 2:
                    removeEmployeeById(sc);
                    break;
                case 3:
                    displayAllEmployees();
                    break;
                case 4:
                    searchEmployeeById(sc);
                    break;
                case 5:
                    displayEmployeesByDepartment(sc);
                    break;
                case 6:
                    displayAllDepartments();
                    break;
                case 7:
                    isRunning = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }

    private static void addNewEmployee(Scanner sc) {
        Employee newEmployee;
        System.out.print("Enter ID of the new employee: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Role (Manager/Developer): ");
        String role = sc.nextLine();
        System.out.println();
        System.out.print("Enter Department from this list: " + departmentEmployeesMap.keySet() + " ");
        String department = sc.nextLine();
        boolean isDepartmentValid = false;
        for (String dep : departmentEmployeesMap.keySet()) {
            if (dep.equalsIgnoreCase(department)){
                isDepartmentValid = true;
                break;
            }
        }
        if (!isDepartmentValid) {
            System.out.println("Department does not exist.");
            return;
        }

        if (role.equalsIgnoreCase(DEVELOPER)) {
            System.out.print("Enter the Programming Language from the list: " + Developer.displayPossibleLanguages() + " ");
            String language = sc.nextLine();
            newEmployee = new Developer(id, name, salary, language);
            newEmployee.setDepartment(DEVELOPMENT_DEPARTMENT);
            addEmployee(newEmployee, DEVELOPMENT_DEPARTMENT);
        } else if (role.equalsIgnoreCase(MANAGER)) {
            newEmployee = new Manager(id, name, salary);
            newEmployee.setDepartment(MANAGEMENT_DEPARTMENT);
            addEmployee(newEmployee, MANAGEMENT_DEPARTMENT);
        } else {
            System.out.println("Invalid role. Employee was not added.");
        }
    }

    private static void removeEmployeeById(Scanner sc) {
        System.out.print("Enter Employee ID to remove: ");
        int removeId = sc.nextInt();
        sc.nextLine();
        Employee toRemove = null;
        for (Employee employee : employees) {
            if (employee.getId() == removeId) {
                toRemove = employee;
                break;
            }
        }
        if (toRemove != null) {
            System.out.println("Do you know the employee's Department? (y/n)");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter Department from this List: " + departmentEmployeesMap.keySet() + " ");
                String department = sc.nextLine();
                if (department.equalsIgnoreCase(DEVELOPMENT_DEPARTMENT)) {
                    remove(toRemove, DEVELOPMENT_DEPARTMENT);
                } else if (department.equalsIgnoreCase(MANAGEMENT_DEPARTMENT)) {
                    remove(toRemove, MANAGEMENT_DEPARTMENT);
                } else {
                    System.out.println("The department is not valid. let's try to remove the employee if he/she exists in the list.");
                    remove(toRemove);
                }
            } else {
                remove(toRemove);
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println(employees);
        }
    }

    private static void searchEmployeeById(Scanner sc) {
        System.out.print("Enter Employee ID to search: ");
        int searchId = sc.nextInt();
        sc.nextLine();
        Employee found = null;
        for (Employee employee : employees) {
            if (employee.getId() == searchId) {
                found = employee;
                break;
            }
        }
        if (found != null) {
            System.out.println("Employee Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayEmployeesByDepartment(Scanner sc) {
        System.out.print("Enter Department form this list: " + departmentEmployeesMap.keySet() + " ");
        String department = sc.nextLine();
        boolean isDepartmentValid = false;
        for (String dep : departmentEmployeesMap.keySet()) {
            if (dep.equalsIgnoreCase(department)) {
                department = dep;
                isDepartmentValid = true;
                break;
            }
        }
        if (!isDepartmentValid) {
            System.out.println("Department does not exist.");
            return;
        }
        List<Employee> departmentEmployees = departmentEmployeesMap.get(department);
        if (departmentEmployees.isEmpty()) {
            System.out.println("No employees in department: " + department);
        } else {
            System.out.println(departmentEmployees);
        }
    }


    private static void displayAllDepartments() {
        System.out.println("\nAll Departments:");
        for (String department : departmentEmployeesMap.keySet()) {
            System.out.println(department + " ( " + departmentEmployeesMap.get(department).size() + " employees");
        }
    }

    private static void addEmployee(Employee employee, String department) {
        departmentEmployeesMap.putIfAbsent(department, new ArrayList<>());
        if (departmentEmployeesMap.get(department).contains(employee)) {
            System.out.println("An employee with ID: " + employee.getId() + " already exists in the department.");
            return;
        }
        departmentEmployeesMap.get(department).add(employee);
        employees.add(employee);
    }

    private static void remove(Employee employee, String department) {
        List<Employee> departmentList = departmentEmployeesMap.get(department);
        if (departmentList != null && departmentList.remove(employee)) {
            employees.remove(employee);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found in the specified department.");
        }
    }

    private static void remove(Employee employee) {
        if (employees.remove(employee)) {
            for (List<Employee> departmentList : departmentEmployeesMap.values()) {
                departmentList.remove(employee);
            }
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
