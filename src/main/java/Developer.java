import java.util.ArrayList;

public class Developer extends Employee{
    String programmingLanguage;
    static ArrayList<String> programmingLanguages = new ArrayList<>();
    static {
        programmingLanguages.add("Java");
        programmingLanguages.add("JavaScript");
        programmingLanguages.add("Python");
    }


    public Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);

    }


    @Override
    public double calculateBonus() {
        return 0.20 * getSalary();
    }
    @Override
    public String toString(){
        return "Developer{id=" + id + " , salary=" + salary + ", programmingLanguage='" + programmingLanguage + "'}";
    }


}
