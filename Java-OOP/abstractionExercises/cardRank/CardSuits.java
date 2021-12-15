package abstractionExercises.cardRank;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    CardSuits(int suitPower) {
        this.suitPower = suitPower;
    }

    private int suitPower;
    // правим си getter на suitPower за да може да взимаме стойността му в други класове

    public int getSuitPower() {
        return suitPower;
    }
}


