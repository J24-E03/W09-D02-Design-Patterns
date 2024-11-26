import java.util.HashSet;
import java.util.Set;

public abstract class Employee {
    private final int id;
    private final String name;
    private double salary;

    private static String companyName = "Tech Solutions";

    protected static final Set<Employee> employees = new HashSet<>();

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    protected abstract void calculateBonus();

    protected abstract void addEmployee(int id, String name, double salary);

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public static void displayEmployees() {
        System.out.println(employees);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static String getCompanyName() {
        return companyName;
    }
}
