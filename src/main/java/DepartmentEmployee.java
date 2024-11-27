
import java.util.*;

public class DepartmentEmployee {
    private final HashMap<String, List<Employee>> departmentMap = new HashMap<>();

    //Add an employee to a department
    public void addEmployeeToDepartment(String department, Employee employee) {
        departmentMap.putIfAbsent(department, new ArrayList<>(Arrays.asList(employee))); //add a key-value pair to the map
        departmentMap.get(department).add((employee));
    }

    //
    public void removeEmployeeFromDepartment(String department, Employee employee) {
        if (departmentMap.containsKey(department)) {
            departmentMap.get(department).remove((employee));
        }
    }

    // Display all employees in a specific department
    public void displayEmployeesInDepartment(String department) {
        if (departmentMap.containsKey(department)) {
            for (Employee employee : departmentMap.get(department)) {
                System.out.println(employee);
            }
        } else {
            System.out.println("No employees in department: " + department);
        }
    }
}
