import java.util.ArrayList;
import java.util.Arrays;

public class Developer extends Employee implements Department {
    private static final ArrayList<String> POSSIBLE_LANGUAGES = new ArrayList<>(Arrays.asList("java", "python", "javascript"));

    private final String programmingLanguage;

    public Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    private static void addProgrammingLanguage(String programmingLanguage) {
        if (POSSIBLE_LANGUAGES.contains(programmingLanguage)) {
            System.out.println(programmingLanguage + " already exists!");
        } else {
            POSSIBLE_LANGUAGES.add(programmingLanguage);
        }
    }

    @Override
    protected void calculateBonus() {
        setSalary((getSalary() * 20.0) / 100.0);
    }

    @Override
    protected void addEmployee(int id, String name, double salary) {
        employees.add(new Developer(id, name, salary, POSSIBLE_LANGUAGES.getFirst()));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                '}';
    }

    @Override
    public String getDepartmentName() {
        return "";
    }

    @Override
    public void assignDepartment(String name) {

    }
}
