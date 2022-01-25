package Solid.Calculator;

import java.util.Stack;

public class InputInterpratotor {

    private CalculatorEngine engine;
    private Stack<Integer> memory;


    public InputInterpratotor(CalculatorEngine engine, Stack<Integer> stack) {
        this.engine = engine;
        this.memory = stack;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception e) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new Multiplication();
        } else if (operation.equals("/")) {
            return new Division();
        } else if (operation.equals("ms")) {
            return new MemorySave(this.memory);
        } else if (operation.equals("mr")) {
            return new MemoryRecall(this.memory);
        }
        return null;
    }
}
