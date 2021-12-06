package Arrays;

import java.util.Scanner;

public class TestArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = scanner.nextInt();
        }
        // делим на 2 за да не прехърлим елементите в масива който имаме
        for (int i = 0; i < numbers.length / 2; i++) {

            int swapIndex = numbers.length - 1 - i;
            int oldNumbersI = numbers[i];
            numbers[i] = numbers[swapIndex];
            numbers[swapIndex] = oldNumbersI;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }

    }

}
