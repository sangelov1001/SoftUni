package abstractionExercises.cardRank;

public class Card {

    private CardSuits cardSuit;
    private CardRanks cardRank;


    // правим си конструктор
    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower() {
        return  cardRank.getRankPower() + cardSuit.getSuitPower();
    }
}
