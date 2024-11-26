public class Manager extends Employee implements Department {
    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    protected void calculateBonus() {
        setSalary((getSalary() * 30.0) / 100.0);
    }

    @Override
    protected void addEmployee(int id, String name, double salary) {
        employees.add(new Manager(id, name, salary));
    }

    @Override
    public String getDepartmentName() {
        return "";
    }

    @Override
    public void assignDepartment(String name) {

    }
}
