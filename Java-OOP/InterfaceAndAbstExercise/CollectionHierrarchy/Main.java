package InterfaceAndAbstExercise.CollectionHierrarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // използваме AddCollection защото е така по условие -> така и за другите
        // AddCollection имплемнентира Collection който има празен конструктор и може да създава обекти
        AddCollection addCollection = new AddCollection();
        AddRemovableCollection addRemovableCollection = new AddRemovableCollection();
        MyListImplementation myListImpl = new MyListImplementation();

        String[] input = scanner.nextLine().split(" ");
        int itemsToRemove = Integer.parseInt(scanner.nextLine());

        // за всички тези три класа addCollection, ... използвахме Addable в метода
        // защото единственото което ни интерисува е нашия Collection да има add()
        printAdd(input,addCollection);
        printAdd(input, addRemovableCollection);
        printAdd(input, myListImpl);


        printRemove(itemsToRemove, addRemovableCollection);
        printRemove(itemsToRemove, myListImpl);
    }

    private static void printAdd(String[] input, Addable addCollection) {
        for (String text : input) {
            System.out.print(addCollection.add(text) + " ");
        }
        System.out.println();
    }

    // тук също изпозлваме AddRemovable интерфейса защото има вс необхофими методи за имплементацията
    private static void printRemove(int itemsToRemove, AddRemove collection) {
        for (int i = 0; i < itemsToRemove; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
