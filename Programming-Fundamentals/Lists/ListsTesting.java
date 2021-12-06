package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListsTesting {

    public static void main(String[] args) {

        // 3 3 6 1
        // 6 3 6 1
        // 6 6 1
        // 12 1
        Scanner scanner = new Scanner(System.in);

        String[] userInput = scanner.nextLine().split(" ");

        // вариант за четене от конзолата на един ред.
        List<Integer> streamList = Arrays.stream(userInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // до -1 за да се застраховаме че няма да излезем от списъка.
        for (int i = 0; i < streamList.size() - 1; i++) {

            // проверяваме дали елемента на i е равен на елемента от i + 1
            if (streamList.get(i).equals(streamList.get(i + 1))) {

                int sum = streamList.get(i) + streamList.get(i + 1);
                streamList.set(i, sum);
                streamList.remove(i + 1 );
                // рестартираме цикъла да минава през всяко число отначало
                i = -1;
            }
        }
        System.out.println(streamList.toString().replaceAll("[\\[\\],]", " "));


    }
}
