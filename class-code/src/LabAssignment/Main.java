package LabAssignment;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Map<String, List<Employee>> map = new HashMap<>();

        Developer developer = new Developer(1, "Omar", 15000,"Java");
        Manager manager = new Manager(2,"Marcel",12000);

        System.out.println(manager);
        System.out.println(developer);




    }


}
