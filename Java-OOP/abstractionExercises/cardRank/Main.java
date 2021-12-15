package abstractionExercises.cardRank;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //  System.out.println("Card Ranks: ");

       // for (CardRanks cardRanks : CardRanks.values()) {
       //     System.out.printf("Ordinal value: %d; Name value: %s%n", cardRanks.ordinal(), cardRanks.name());
       // }

        Scanner scanner = new Scanner(System.in);
        // първо си четем ранга на картата
        CardRanks cardRank = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardSuit, cardRank);
        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, card.getPower());
    }
}
