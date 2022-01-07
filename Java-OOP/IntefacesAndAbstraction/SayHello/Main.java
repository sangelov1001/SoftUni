package IntefacesAndAbstraction.SayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

            List<Person> persons = new ArrayList<>();

            persons.add(new Bulgarian("Peter"));
            persons.add(new European("John"));
            persons.add(new Chinese("Lin-Sung"));

        for (Person person : persons) {
            print(person);
        }

    }
    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
