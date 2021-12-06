package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(') {
                // ще запази в стека индекса на който е срещната примерната скоба
                stack.push(i);
            } else if (current == ')') {
                int begin = stack.pop();
                System.out.println(expression.substring(begin, i + 1));
            }
        }
    }
}
