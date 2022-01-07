package InterfaceAndAbstExercise.DefineInterfacePerson;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            // имаме масив от класове // след това взимаме на Citizen класа и му взимаме интерфейсите
            Class[] citizenInterface = Citizen.class.getInterfaces();
            // ако в citizenInterface имаме Person клас
            // вземи му методите
            if (Arrays.asList(citizenInterface).contains(Person.class)) {
                Method[] fields = Person.class.getDeclaredMethods();
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                Person person = new Citizen(name, age);

                System.out.println(fields.length);
                System.out.println(person.getName());
                System.out.println(person.getAge());
            }
    }
}
