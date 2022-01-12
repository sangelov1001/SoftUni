package Polymorphism.example;

public class YellowJaguar implements Jaguar{

    @Override
    public String runFast() {
        return "I'm yellow Jaguar and I can run fast.";
    }

    public String eatPray() {
        return "I am eating meat!";
    }
}
