package Arrays;

import java.util.Scanner;
import  java.util.Arrays;

public class EquaArrays {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Четене на 2 масива от конзолата (съкратен вариант)
        String firstLine = scanner.nextLine();

        String[] firstArray = firstLine.split(" ");
        int[] arrOne = Arrays.stream(firstArray)
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String secondLine = scanner.nextLine();
        String[] secondArray = secondLine.split(" ");
        int[] arrTwo = Arrays.stream(secondArray)
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();


        boolean isEqual = true;
       if (firstArray.length == secondArray.length){

           for (int i = 0; i < firstArray.length; i++) {

               if (firstArray[i] != secondArray[i]){

                   isEqual = false;
               } else{
                   isEqual = false;
               }

               if (isEqual) {
                   System.out.println("Arrays are identical");

               } else{
                   System.out.println("Arrays are not identical");
               }
           }
        }

    }
}
