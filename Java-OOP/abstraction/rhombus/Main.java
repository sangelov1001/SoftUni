package abstraction.rhombus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int r = 1; r <= n - 1; r++) {
            printLineOfSpaces(n - r);
            printLineOfStart(r);
            System.out.println();
        }
        printLineOfStart(n);
        System.out.println();

        for (int r = 1; r < n; r++) {
            printLineOfSpaces(r);
            printLineOfStart(n - r);
            System.out.println();
        }
    }
    public static  void printLineOfStart(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
    }

    public static void printLineOfSpaces (int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
}
