package employees;

public class Manager extends Employee implements Department{
    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateBonus() {
        return 0.3 * getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Manager" + "\n";
    }

}
