package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(stack::push);

        while (stack.size() > 1) {
            int firstElement = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondElement = Integer.parseInt(stack.pop());

            if (op.equals("+")) {
                // вкарваме в стека сбора или изваждането на първите 2 числа
              stack.push(String.valueOf(firstElement + secondElement));
            } else if (op.equals("-")) {
                stack.push(String.valueOf(firstElement - secondElement));
            }
        }
        System.out.println(stack.pop());
    }
}
