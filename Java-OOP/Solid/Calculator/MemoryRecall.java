package Solid.Calculator;

import java.util.Stack;

public class MemoryRecall implements Operation {

    private Stack<Integer> memory;

    public MemoryRecall(Stack<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        // ---- тук не имплеменираме нищо защото addOperand() не ни трябва в конкретната команда.
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return !this.memory.isEmpty();
    }
}
