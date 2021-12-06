package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingList {

    public static void main(String[] args) {

        //  вариант в който и двата списъка са еднакви по дължина
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        // взимаме това кой от двата списъка е по-малък
        int size = Math.min(list1.size(), list2.size());


        for (int i = 0; i < size; i++) {

            System.out.print(list1.get(i) + " " + list2.get(i) + " ");
        }
        printTheRest(list1, size);
        printTheRest(list1, size);

    }
    private static void printTheRest(List<Integer> numbers, int beginIndex) {

        for (int i = beginIndex; i < numbers.size(); i++) {

            System.out.print(numbers.get(i) + " ");
        }
    }
}
