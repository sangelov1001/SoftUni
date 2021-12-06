package Arrays;

import java.util.Scanner;

public class EvenAndOddSubstraction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       String line = scanner.nextLine();

       String[] numberAsStrings = line.split(" ");
       int[] numbers = new int[numberAsStrings.length];

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = Integer.parseInt(numberAsStrings[i]);
        }
            int evenSum = 0;
            int oddSum = 0;

            for (int number : numbers){

                if (number % 2 == 0){
                    evenSum += number;
                }
                else{
                    oddSum += number;
                }
            }

        System.out.println(evenSum - oddSum);
    }
}
