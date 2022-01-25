package Solid.Calculator;

import java.util.Stack;

public class MemorySave implements Operation {

    private Stack<Integer> memory;

    public MemorySave(Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
            this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    // тук винаги трябва да връща false -> защото трябва да може да се добавя операнд addOperand()
    @Override
    public boolean isCompleted() {
        return false;
    }
}
