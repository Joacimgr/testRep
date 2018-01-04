package laboration3C;

public class Card{

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException("null");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRankValue() {
        return rank.getValue();
    }

    public int getSuitValue() {
        return suit.ordinal(); // default values, 0, 1, 2, 3
    }

    @Override
    public String toString() {
        return String.format("%s of %s", getRank(), getSuit());
    }
}
