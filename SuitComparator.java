package laboration3C;

import java.util.Comparator;

public class SuitComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuitValue() == c2.getSuitValue()) {
            return 0;
        } else if (c1.getSuitValue() > c2.getSuitValue()) {
            return 1;
        } else {
            return -1;
        }
    }
}