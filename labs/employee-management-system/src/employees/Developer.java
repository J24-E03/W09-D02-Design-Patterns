package employees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Developer extends Employee implements Department{
    private String programmingLanguage;
    private static List<String> possibleLanguages = new ArrayList<>(Arrays.asList("java", "python", "JavaScript"));

    public Developer(int id, String name, double salary, String programmingLanguage) {
        super(id, name, salary);
        if (!possibleLanguages.contains(programmingLanguage)) {
            System.out.println("Invalid programming language.");
            this.programmingLanguage = "Java";
            return;
        }
        this.programmingLanguage = programmingLanguage;
    }

    public static void addPossibleLanguages(String newLanguage) {
        for (String language : possibleLanguages) {
            if (language.equalsIgnoreCase(newLanguage)){
                System.out.println("The language already exists in the list.");
                return;
            }
        }
        possibleLanguages.add(newLanguage);
    }

    public static List<String> displayPossibleLanguages() {
        return possibleLanguages;
    }

    @Override
    public double calculateBonus() {
        return 0.2 * getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Developer, Programming Language: " + programmingLanguage + "\n";
    }


}
