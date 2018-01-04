package laboration3B;

import java.util.Comparator;

public class CompSortByTitle implements Comparator<Book>{
   
    @Override
    public int compare(Book b1,Book b2){
        //Sort by title first then author
        if (b1.getTitle().compareTo(b2.getTitle()) > 0) {
            return 1;
        } else if (b1.getTitle().compareTo(b2.getTitle()) == 0) {
            int size = b1.getAuthors().size() < b2.getAuthors().size() ? 
                    b1.getAuthors().size() : b2.getAuthors().size();
            for (int i = 0; i < size; i++) {
                if (b1.getAuthors().get(i).getName().compareTo(b2.getAuthors().get(i).getName()) < 0) {
                    return -1;
                } else if (b1.getAuthors().get(i).getName().compareTo(b2.getAuthors().get(i).getName()) > 0) {
                    return 1;
                }
            }
            if(b1.getAuthors().size() < b2.getAuthors().size())
                return -1;
            else if(b1.getAuthors().size() == b2.getAuthors().size()){
                return 0;
            }
            else
                return 1;
        } else {
            return -1;
        }
    }
}
