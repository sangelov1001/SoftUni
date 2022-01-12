package Polymorphism.Animals;

public class Main {
    public static void main(String[] args) {

            Animal cat = new Cat("Oskar", "Whiskas");
            Animal dog = new Dog("Ares", "Purina");

        System.out.println(cat.explainSelf());
        System.out.println(dog.explainSelf());
    }
}
