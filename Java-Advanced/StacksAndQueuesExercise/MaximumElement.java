package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= n; count++) {
            String commmand = scanner.nextLine();
            // "1x" -> push x in stack
            // "2" -> remove element of the stack
            // "3" -> print max element onlu if stack is not empty

            if (commmand.equals("2")) {
                stack.pop();
            } else if (commmand.equals("3")) {
                if (stack.size() > 0) {
                    System.out.println(Collections.max(stack));
                }
            } else {
                int x = Integer.parseInt(commmand.split("\\s+")[1]);
                stack.push(x);
            }
        }
    }
}
