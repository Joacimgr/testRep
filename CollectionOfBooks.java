package laboration3B;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
/**
 * The CollectionOfBooks class is an aggregate of Book objects and is meant to
 * represent a collection of books. It allows to be initially instantialized
 * with existing Book objects from a given file or created empty. The Book
 * objects are stored as an ArrayList. The class has methods for adding books,
 * removing books, searching for books by a given criteria, listing current
 * books and serialization.
 *
 * @author Erik Lindfors
 * @author Joacim Granberg
 */
public class CollectionOfBooks {

    private ArrayList<Book> books;

    /**
     * The default constructor. Creates an empty list of Book objects.
     */
    public CollectionOfBooks() {
        books = new ArrayList<>();
    }

    /**
     * Adds a given Book object to the list of books.
     *
     * @param book
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a given Book object from the list of books.
     *
     * @param book
     * @return true on sucessful book removal, else false.
     */
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    /**
     * Returns an unsorted copy of the current list of Book objects.
     *
     * @return ArrayList<Book>.
     */
    public ArrayList<Book> getCollection() {
        ArrayList<Book> bookCollection = new ArrayList<>(books);
        return bookCollection;
    }

    /**
     * This method is used to fetch a new list of Book objects matching the
     * given search criteria. The returned list will be sorted with the use of
     * the static Collections.sort method which uses the comparator CompSortByTitle.
     *
     * @param title The title used in the search
     * @return a list of Book objects
     */
    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().contains(title)) {
                searchResult.add(books.get(i));
            }
        }
        Collections.sort(searchResult, new CompSortByTitle());
        return searchResult;
    }

    /**
     * This method is used to fetch a new list of Book objects matching the
     * given search criteria. The returned list will be sorted with the use of
     * the static Collections.sort method which uses the comparator CompSortByAuthor.
     *
     * @param author The Author object used in the search
     * @return a list of Book objects
     */
    public ArrayList<Book> getBooksByAuthor(Author author) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            for (Author a : books.get(i).getAuthors()) {
                if (a.getName().contains(author.getName())) {
                    searchResult.add(books.get(i));
                    break;
                }
            }
        }
        Collections.sort(searchResult, new CompSortByAuthor());
        return searchResult;
    }

    /**
     * This method is used to fetch a new list of Book objects matching the
     * given search criteria. The returned list will be sorted with the use of
     * the static Collections.sort method which uses the comparator CompSortByIsbn.
     *
     * @param isbn The ISBN number used in the search
     * @return a list of Book objects
     */
    public ArrayList<Book> getBooksByIsbn(String isbn) {
        ArrayList<Book> searchResult = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().contains(isbn)) {
                searchResult.add(books.get(i));
            }
        }
        Collections.sort(searchResult, new CompSortByIsbn());
        return searchResult;
    }

    /**
     * This method is used to serialize the current state of the arraylist of
     * Book objects to file. The file should be of type .ser as by convention.
     *
     * @param filename The path to the file used to store the serialized
     * objects.
     * @throws IOException
     */
    public void serializeToFile(String filename) throws IOException {

        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(
                    new FileOutputStream(filename));
            out.writeObject(books);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * This method is used to deserialize an ArrayList of Book objects from
     * file. Only if an Exception of the mentioned type is NOT cast, the method
     * will instantialize an ArrayList of the imported Book objects.
     *
     * @param filename The path to the file used to store the serialized
     * objects.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws EOFException
     */
    @SuppressWarnings("unchecked")
    public void deSerializeFromFile(String filename)
            throws IOException, ClassNotFoundException, FileNotFoundException, EOFException {

        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream(filename));
            books = (ArrayList<Book>) in.readObject();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CollectionOfBooks:\n");
        for (Book b : books) {
            sb.append(b.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
