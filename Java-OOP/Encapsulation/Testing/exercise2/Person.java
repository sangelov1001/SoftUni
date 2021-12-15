package Encapsulation.Testing.exercise2;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double increment) {
        if (age < 30) {
            increment = increment / 2;
        }
         this.salary = this.salary * (1.0 + increment / 100);
    }
    // искат ни setter за заплатата по условие на judge
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
