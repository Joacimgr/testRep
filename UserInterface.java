package laboration3B;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private final Scanner input;
    private final CollectionOfBooks collectionOfBooks;
    private final String filename = "C:\\Laboration 3\\proj\\3B\\Labb3B\\src\\laboration3B\\objects.ser";

    public UserInterface() {
        input = new Scanner(System.in);
        collectionOfBooks = new CollectionOfBooks();
        try {
            collectionOfBooks.deSerializeFromFile(filename);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Unable to find class in file.");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Empty collection created.");
        } catch (EOFException eofe) {       
            System.out.println("Empty file found.");
        } catch (IOException ioe) {
            System.out.println("IOException");
        }

        System.out.println("Imported " + collectionOfBooks.getCollection().size()
                + " number of books from file: " + filename);
    }

    public void run() {
        menu();
    }

    public void addBook() {
        System.out.print("Enter ISBN: ");
        String isbn;
        do {
            isbn = input.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.print("You need to enter an ISBN number: ");
            }
        } while (isbn.isEmpty());

        System.out.print("Enter title: ");
        String title;
        do {
            title = input.nextLine().trim().toUpperCase();
            if (title.isEmpty()) {
                System.out.print("You need to enter a title: ");
            }
        } while (title.isEmpty());

        System.out.print("Enter edition: ");
        Integer edition;
        do {
            edition = null;
            try {
                edition = Integer.parseInt(input.nextLine().trim());
                if (edition < 1) {
                    System.out.println("Negative edition not allowed.");
                    System.out.print("Enter an integer >= 0: ");
                }
            } catch (NumberFormatException nfe) {
                System.out.print("Enter an integer: ");
            }
        } while (edition == null || edition < 1);

        System.out.print("Enter price: ");
        Double price;
        do {
            price = null;
            try {
                price = Double.parseDouble(input.nextLine().trim());
                if (price < 0.0) {
                    System.out.println("Negative price not allowed.");
                    System.out.print("Enter a float value >= 0.0: ");
                }
            } catch (NumberFormatException nfe) {
                System.out.print("Enter a float value: ");
            }
        } while (price == null || price < 0.0);

        ArrayList<Author> authors = new ArrayList<>();

        char choice = ' ';
        String author;
        do {
            System.out.print("Enter author: ");
            do {
                author = input.nextLine().trim();
                if (author.isEmpty()) {
                    System.out.print("You need to enter an author: ");
                }
            } while (author.isEmpty());
            authors.add(new Author(author.trim().toUpperCase()));

            System.out.print("Would you like to add another author? (Y - Yes, N - No): ");
            do {
                choice = input.nextLine().toUpperCase().charAt(0);
            } while (choice != 'N' && choice != 'Y');

        } while (choice == 'Y');

        Book b = new Book(isbn, title, edition, price, authors);
        collectionOfBooks.addBook(b);

        System.out.println("-------------------");
        System.out.print("Book added: ");
        System.out.println(b.toString());
        System.out.println();
    }

    public void removeBook() {

        System.out.println("Remove Book");
        System.out.println("------------");
        ArrayList<Book> searchResults = findBooks();
        if (searchResults.size() < 1) {
            System.out.println("Unable to find book.");
        } else if (searchResults.size() > 1) {
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.printf("%d: %s\n", i, searchResults.get(i).toString());
            }
            System.out.printf("\nWhich index? ");
            int index = 0;

            String stringInput = input.nextLine();
            try {
                index = Integer.parseInt(stringInput);
                System.out.println("Removing: " + searchResults.get(index).toString());
                if (collectionOfBooks.removeBook(searchResults.get(index))) {
                    System.out.println("Book removed.");
                } else {
                    System.out.println("Book not found.");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Only integers allowed.");
            } catch (ArrayIndexOutOfBoundsException aiobe) {
                System.out.println("Invalid index.");
            }
        } else {
            System.out.println("Removing: " + searchResults.get(0).toString());
            if (collectionOfBooks.removeBook(searchResults.get(0))) {
                System.out.println("Book removed.");
            } else {
                System.out.println("Book not found.");
            }
        }
    }

    public void search() {
        ArrayList<Book> searchResults = findBooks();
        System.out.println("Search Results:");
        if (searchResults.isEmpty()) {
            System.out.println("No books found!");
        } else {
            for (Book b : searchResults) {
                System.out.println(b.toString());
            }
        }
    }

    private ArrayList<Book> findBooks() {
        ArrayList<Book> searchResults = new ArrayList<>();

        System.out.println("Search with:");
        System.out.println("T - Title");
        System.out.println("A - Author");
        System.out.println("I - ISBN");
        char choice;
        do {
            System.out.println("Enter choice: ");
            choice = input.nextLine().toUpperCase().charAt(0);
        } while (choice != 'T' && choice != 'A' && choice != 'I');

        switch (choice) {
            case 'T': {
                System.out.print("Enter title: ");
                String title = input.nextLine().toUpperCase();
                searchResults = collectionOfBooks.getBooksByTitle(title);
                break;
            }
            case 'A': {
                System.out.print("Enter author: ");
                String name = input.nextLine().toUpperCase();
                Author author = new Author(name);
                searchResults = collectionOfBooks.getBooksByAuthor(author);
                break;
            }
            case 'I': {
                System.out.print("Enter ISBN: ");
                String isbn = input.nextLine();
                searchResults = collectionOfBooks.getBooksByIsbn(isbn);
                break;
            }
        }
        return searchResults;
    }

    public void listBooks() {

        System.out.println("-------------------");
        System.out.println("Books in collection:");
        for (int i = 0; i < collectionOfBooks.getCollection().size(); i++) {
            System.out.printf("%d: %s\n", i, collectionOfBooks.getCollection().get(i).toString());
        }
        System.out.println();
    }

    private void menu() {
        char choice = ' ';
        String answer;

        do {
            System.out.println("Collection Of Books");
            System.out.println("-------------------");
            System.out.println();
            System.out.println("A - Add book");
            System.out.println("R - Remove book");
            System.out.println("S - Search for books");
            System.out.println("L - List books");
            System.out.println("X - Exit");
            System.out.println();

            do {
                System.out.print("Enter choice: ");
                answer = input.nextLine();
            } while (answer.isEmpty());

            answer = answer.toUpperCase();
            choice = answer.charAt(0);

            switch (choice) {
                case 'A':
                    addBook();
                    break;
                case 'R':
                    removeBook();
                    break;
                case 'S':
                    search();
                    break;
                case 'L':
                    listBooks();
                    break;
                case 'X':
                    try {
                        collectionOfBooks.serializeToFile(filename);
                        System.out.println("Wrote " + collectionOfBooks.getCollection().size()
                                + " number of books to file: " + filename);
                    } catch (IOException ioe) {
                        System.out.println("Unable to open file.");
                    }

                    System.out.println("Exiting...!");
                    break;
                default:
                    System.out.println("Unknown command");
                    System.out.println();
            }

        } while (choice != 'X');
    }
}
