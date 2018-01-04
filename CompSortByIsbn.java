package laboration3B;

import java.util.Comparator;

/**
 * This comparator is used to sort given Book objects by ISBN number (String).
 * 
 * @author Joacim Granberg
 * @author Erik Lindfors
 */

public class CompSortByIsbn implements Comparator<Book>{
    
    /**
     * The compare method handles the sorting logic of the comparator. It compares
     * the given Book objects ISBN number using the compareTo method from the 
     * Comparable interface and returns accordingly. 
     * @param b1
     * @param b2
     * @return -1, 0 or 1
     */
    @Override
    public int compare(Book b1, Book b2){
        if(b1.getIsbn().compareTo(b2.getIsbn()) > 0) {
            return 1;
        }
        else if(b1.getIsbn().compareTo(b2.getIsbn()) < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
