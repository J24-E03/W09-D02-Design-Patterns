package employees;

public abstract class Employee implements Department {

    private final int id;
    private String name;
    protected double salary;
    private String department;
    private static final String companyName = "Tech Solutions";

    public Employee(int id, String name, double salary) {
        this.id = id;
        setName(name);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            System.out.println("Invalid employee name.");
            this.name = "Unknown";
            return;
        }
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0.0) {
            System.out.println("Invalid salary amount");
            this.salary = 0.0;
            return;
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department.isBlank()) {
            System.out.println("Invalid department.");
            this.department = "Development";
            return;
        }
        this.department = department;
    }

    public abstract double calculateBonus();

    public final String getCompanyName() {
        return companyName;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }



    @Override
    public void assignDepartment(String name) {
        setDepartment(name);
    }

    @Override
    public String getDepartmentName() {
        return department;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
}
