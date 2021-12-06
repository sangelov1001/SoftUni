package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> wordStates = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currText = new StringBuilder();
        for (int count = 0; count <= n; count++) {
            String command = scanner.nextLine();
            // 1 [string]
            // 2 [count]
            // 3 [index]
            // 4
            String commandNumber = command.split("\\s+")[0]; // 1,2,3,4
            switch (commandNumber) {
                case "1":
                    String textToAdd = command.split("\\s+")[1];
                    currText.append(textToAdd);
                    wordStates.push(currText.toString());
                    break;
                case "2":
                    int countElements = Integer.parseInt(command.split("\\s+")[1]);
                    int startIndex = currText.length() - countElements;
                    String textForRemove = currText.substring(startIndex);
                    currText = currText.replace(startIndex, startIndex + countElements, "");
                    wordStates.push(currText.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(command.split("\\s+")[1]);
                    System.out.println(currText.charAt(index - 1));
                    break;
                case "4":
                    // заради команда 4 изпозлваме стека за да може да пазим думите след всяка промяна
                    if (!wordStates.isEmpty()) {
                        wordStates.pop();
                        currText = new StringBuilder(wordStates.peek());
                    } else {
                        currText = new StringBuilder();
                    }
                    break;
            }

        }
        System.out.println(wordStates);

    }
}
