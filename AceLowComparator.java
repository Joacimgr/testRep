package laboration3C;

import java.util.Comparator;

public class AceLowComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getRankValue() == c2.getRankValue()) {
            return 0;
        } else if (c1.getRankValue() > c2.getRankValue()) {
            return 1;
        } else {
            return -1;
        }
    }
}