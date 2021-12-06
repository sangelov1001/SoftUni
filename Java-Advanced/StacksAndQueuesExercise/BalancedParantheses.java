package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class BalancedParantheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isBalanced = false;
        // използваме стек защото ни е такава логиката на взимане на скобите
        String input = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        for (int index = 0; index <= input.length(); index++) {
            char currentBracket = input.charAt(index);
            // проверка дали скобата е отворена
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } // проверка дали скобата е затворена
            else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                if (!openBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                // проверка дали тази затворена скоба съвпада с последната отворена
                char lastOpenedBracket = openBrackets.pop();
                if (lastOpenedBracket == '(' && currentBracket == ')') {
                        isBalanced = true;
                } else if (lastOpenedBracket == '{' && currentBracket == '}') {
                        isBalanced = true;
                } else if (lastOpenedBracket == '[' && currentBracket == ']') {
                        isBalanced = true;
                } else {
                    // тук не са балансирани
                    isBalanced = false;
                    break;
                }
            }

        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
