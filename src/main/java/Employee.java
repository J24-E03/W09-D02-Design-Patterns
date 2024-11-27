public abstract class Employee {
  final int id;
  private String name;
  protected double salary;
  static String companyName = "Tech Solutions";

  //Constructor
    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;

    }
    //Abstract method: calculateBonus()
    public abstract double calculateBonus();

    //Getter and setter for name (demonstrate encapsulation).
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Override toString() to display employee details.
    public String toString(){
        return "Employee ID: " + id + "Name: " + name + ",Salary: " + salary;

    }
    public final String getCompanyName(){
        return companyName;
    }
}
