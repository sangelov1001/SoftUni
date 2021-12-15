package Encapsulation.Testing.mutableVsImmutable;

import Encapsulation.Testing.exercise3.Person;

public class Main {
    public static void main(String[] args) {

        // Mutable vs Immutable
        String text = "The crazy brown fox jumps over the lazy dog";
        String substring = text.substring(0, 10);

        Person p = new Person("Mariika", "Ivanova", 32, 1000);
        System.out.println(p.toString());
        // сетваме lastName да е "Hristova" и така излизат 2 стринга.
        // единия е с "Ivanova", другия е с "Hristova"
    }
}
