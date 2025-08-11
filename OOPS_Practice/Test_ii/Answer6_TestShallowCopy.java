package Test_ii;

import java.util.ArrayList;
import java.util.List;

public class Answer6_TestShallowCopy {
    public static void main(String[] args) {
        List<String> skills1 = new ArrayList<>();
        skills1.add("Python");
        skills1.add("java");
        Employee emp1 = new Employee("swata swayam", skills1);
        Employee emp2 = null;

        try {
            emp2 = (Employee)emp1.clone();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(emp2.skills);
        emp1.skills.add("C++");
        System.out.println(emp2.skills);
    
    }
}

class Employee implements Cloneable{
    String name;
    List<String> skills;

    Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}