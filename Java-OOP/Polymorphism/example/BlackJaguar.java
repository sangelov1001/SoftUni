package Polymorphism.example;

public class BlackJaguar implements Jaguar{
    @Override
    public String runFast() {
        return "I'm black Jaguar and I can run fast too";
    }

    public String hiddenInDark() {
        return "I am hidden in the forest!";
    }
}
