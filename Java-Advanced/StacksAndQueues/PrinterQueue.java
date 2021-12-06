package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String task = scanner.nextLine();

        while (!task.equals("print")) {

            if (task.equals("cancel")) {
                    if (queue.isEmpty()) {
                        System.out.println("Printer is on standby");
                    } else {
                        String canceledTask = queue.poll();
                        System.out.println("Canceled " + canceledTask);
                    }
            } else {
                queue.offer(task);
            }

            task = scanner.nextLine();
        }
            for (String file : queue) {
                System.out.println(file);
            }

    }
}
