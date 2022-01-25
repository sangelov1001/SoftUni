package Solid.Calculator;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    // за всеки един от класовете * / ms ..
    // добавяме съотвените сетвания на на getResult returnResult() ...
    // паметта ще бъде общо dependency -> memory ще присъства навсякъде

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Stack<Integer> memory = new Stack<>();

        CalculatorEngine engine = new CalculatorEngine();

        // разбираме че buildInterpreter e статичен метод защото се извиква чрез класа си Extension.
        InputInterpratotor interpreter = Extension.buildInterpreter(engine,memory);

        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if (token.equals("end")) {
                break;
            }
            interpreter.interpret(token);
        }
        System.out.println(engine.getCurrentResult());
    }
}
