package Solid.Calculator;

import java.util.Stack;

public class Extension {

    public static InputInterpratotor buildInterpreter(CalculatorEngine engine, Stack<Integer> memory) {
        return new InputInterpratotor(engine, memory);
    }
}
