package Inheritance.example;

public class Employee extends Person{

    private String companyName;

    public Employee(String name, int age, String email, String companyName) {
        super(name, age, email);
        this.companyName = companyName;
    }
}
