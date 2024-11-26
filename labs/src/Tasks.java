import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tasks {
    public static void main(String[] args) {
        Map<String, List<Employee>> map = new HashMap<>();

        Employee e1 = new Manager(1, "John", 5000);
        Employee e2 = new Developer(2, "Thomas", 7000, "Java");

        System.out.println(e1);
        System.out.println(e2);

        Employee.employees.add(e1);
        Employee.employees.add(e2);
        System.out.println(Employee.employees);
    }
}
