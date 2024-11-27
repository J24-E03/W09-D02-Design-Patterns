public class Manager extends Employee {
    public Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    public double calculateBonus() {
        return 0.30 * salary;

    }
    @Override
    public String toString() {
        return super.toString() + ", Role: Manager";
    }
}
