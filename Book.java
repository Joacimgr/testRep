package laboration3B;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * This class represents a book with relevant data about it. 
 * The book class implements serializable to be able to write objects to files.
 * 
 * @author Erik Lindfors
 * @author Joacim Granberg
 */
public class Book implements Serializable {

    /*Vi talades vid via mail angående att implementera komparatorer i denna uppgift istället
     *för C-uppgiften. Vi har därför valt att inte implementera Comparable i denna klass och
     *istället lägga logiken för sorteringen i komparatorn CompSortByTitle. 
     *Nackdelen blir att vi inte får chansen att visa att vi kan overridea equals och hashcode.
    */
    private String isbn;
    private String title;
    private int edition;
    private double price;
    private final ArrayList<Author> authors;

    /**
     * This constructor creates a book with all values requiered.
     * It uses an anonymous inner comparator to define a sorting algorithm,
     * then sorts the list.
     * @param isbn
     * @param title
     * @param edition
     * @param price
     * @param authors
     */
    public Book(String isbn, String title, int edition, double price, ArrayList<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.authors = authors;
        Comparator<Author> com = new Comparator<Author>(){
            @Override
            public int compare(Author a1, Author a2){
                if(a1.getName().compareTo(a2.getName()) > 0){
                    return 1;
                }
                else if(a1.getName().compareTo(a2.getName()) < 0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        };
        Collections.sort(authors, com);
    }

    /**
     * This method returns the isbn number of the book.
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method sets the isbn of the book.
     * @param isbn (String)
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * This method returns the title of the book.
     * @return title (String)
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets the title of the book.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the books edition.
     * @return edition (int)
     */
    public int getEdition() {
        return edition;
    }

    /**
     * This method sets an edition for the book.
     * @param edition (int)
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * This method returns the books price.
     * @return double
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method sets a price for the book.
     * @param price (double)
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method adds another author to the list of authors
     * @param author
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * This method returns the list of authors
     * @return ArrayList<Author> 
     */
    public ArrayList<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book[");
        sb.append("isbn:");
        sb.append(isbn);
        sb.append(", ");
        sb.append("title:");
        sb.append(title);
        sb.append(", ");
        sb.append("edition:");
        sb.append(edition);
        sb.append(", ");
        sb.append("price:");
        sb.append(price);
        sb.append(", ");
        sb.append("author(s):");
        for (Author a : authors) {
            sb.append(a.getName());
            if (a.getName().equals(authors.get(authors.size() - 1).getName())) {
                sb.append("]");
            } else {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
