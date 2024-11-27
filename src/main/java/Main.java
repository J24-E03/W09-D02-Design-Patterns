import java.util.Scanner;

public class Main {
    public static Employees employees = new Employees();
    public static DepartmentEmployee departmentEmployee = new DepartmentEmployee();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type ");

        int choice = scanner.nextInt();


           switch(choice){
               case 1:
                   System.out.println("Enter role (Developer/Manager): ");//Add a new employee (choose role and department interactively).
                   scanner.nextLine();
                   String role = scanner.nextLine();
                   System.out.println("Enter Id: ");
                   int id = scanner.nextInt();
                   scanner.nextLine();
                   System.out.println("Enter name: ");
                   String name = scanner.nextLine();
                   System.out.println("Enter salary: ");
                   double salary = scanner.nextDouble();
                   scanner.nextLine();
                   employees.addEmployee(id,name,salary,role);


               case 2:
                   System.out.println("*Remove an employee by id.*");
                   System.out.println("Enter employee id to remove: ");//Remove an employee by id.
                   int removeId = scanner.nextInt();
                   scanner.nextLine();

               case 3:
                   employees.displayAllEmployees();//Display all employees.

               case 4:
                   System.out.println("*Search for an employee by id.*");
                   System.out.println("Enter employee id to search: ");//Search for an employee by id.
                   int searchId = scanner.nextInt();

               case 5:
                   System.out.println("*Display employees of a specific department.*");
                   System.out.println("Enter department name: ");//Display employees of a specific department.
                   scanner.nextLine();
                   String deptName = scanner.nextLine();
                   departmentEmployee.displayEmployeesInDepartment(deptName);

               case 6:
                   System.out.println("Exiting..");
                   scanner.close();



           }



        }
    }

