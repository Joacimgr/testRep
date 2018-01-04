package laboration3C;

import java.util.Comparator;

public class AceHighComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getRankValue() == c2.getRankValue()) {
            return 0;
        } else if (c1.getRank() == Rank.ACE) {
            return 1;
        } else if (c2.getRank() == Rank.ACE) {
            return -1;
        } else if (c1.getRankValue() > c2.getRankValue()) {
            return 1;
        } else {
            return -1;
        }
    }
}
