package laboration3B;

import java.util.Comparator;

/**
 * This comparator is used to sort given Book objects by author name (String).
 * It is recommended that the given Book objects' Author lists are already
 * sorted in alphabetical order. 
 * 
 * @author Erik Lindfors
 * @author Joacim Granberg
 */

public class CompSortByAuthor implements Comparator<Book> {
    
    /**
     * The compare method handles the sorting logic of the comparator. It first
     * checks for the smallest Author list size. It then uses this size limit and loops through 
     * each list of Authors and compares the names using the compareTo method from the
     * Comparable interface. If both lists are equal up to the size limit, the method
     * will check for size differences. In this case, the Book object with the shortest
     * Author list will be sorted first. 
     * @param b1
     * @param b2
     * @return -1, 0 or 1.
     */
    @Override
    public int compare(Book b1, Book b2) {
        int smallestSize = b1.getAuthors().size() < b2.getAuthors().size()
                ? b1.getAuthors().size() : b2.getAuthors().size();
        for (int i = 0; i < smallestSize; i++) {
            if ((b1.getAuthors().get(i).getName().compareTo(b2.getAuthors().get(i).getName())) < 0) {
                return -1;
            } else if ((b1.getAuthors().get(i).getName().compareTo(b2.getAuthors().get(i).getName())) > 0) {
                return 1;
            }
        }
        
        if(b1.getAuthors().size() > b2.getAuthors().size()){
            return -1;
        }
        else if(b1.getAuthors().size() < b2.getAuthors().size()){
            return 1;
        }
        else{
            return 0; 
        }
    }
}
