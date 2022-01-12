package Polymorphism;

import Polymorphism.example.AlbinoJaguar;
import Polymorphism.example.BlackJaguar;
import Polymorphism.example.Jaguar;
import Polymorphism.example.YellowJaguar;

public class Main {
    public static void main(String[] args) {

        displayHowJaguarRun(new YellowJaguar());
        displayHowJaguarRun(new BlackJaguar());

    }

    public static void displayHowJaguarRun(Jaguar jaguar) {
        System.out.println(jaguar.runFast());

        Class<? extends Jaguar> clazz = jaguar.getClass();

       if (jaguar instanceof YellowJaguar) {
           System.out.println(((YellowJaguar) jaguar).eatPray());
       } else if (jaguar instanceof BlackJaguar) {
           System.out.println (((BlackJaguar) jaguar).hiddenInDark());
       } else if (!(jaguar instanceof AlbinoJaguar)){
           // друг начин за такава проверка (jaguar.getClass() != AlbinoJaguar.class)
           // (clazz != AlbinoJaguar.class)
           throw new IllegalStateException("Unknown type " + jaguar.getClass());
       }
    }
}
