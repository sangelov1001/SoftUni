package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {


        // n ->брой числа за добавяне
        // s -> брой числа за премахване
        // x -> проверка дали го има в стека
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // 5 2 12
        // S N X
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        // n
        for (int count = 1; count <= n; count++) {
            // към стека ми вземи и ми добави integer-а който видиш
            queue.offer(scanner.nextInt());
        }
        // s
        for (int count = 1; count <= s; count++) {
            queue.poll();
        }
        //x
        if (queue.contains(x)) {
            System.out.println("true");
        } else { // x го няма в стека
            // проверяваме дали са соатанали елементи в стека преди да проверяваме за най-малкия елемент
            if (!queue.isEmpty()) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
