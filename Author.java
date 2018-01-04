package laboration3B;

import java.io.Serializable;

/**
 *This class is made to represent an author. It's in a very general form
 *and consists only of the field 'name' with appropriate getters and setters
 *together with a single parameter constructor to set the name field. 
 * 
 *@author Erik Lindfors
 *@author Joacim Granberg
*/

public class Author implements Serializable{

    private String name;
    
    /**
     * This is the only constructor for the Author class. It requires the
     * name of the author.
     * @param name
     */
    public Author(String name){
        this.name = name;
    }
    
    /**
     * This method return a String with the current name. 
     * @return the name of the author
     */
    public String getName(){
        return name;
    }
    
    /**
     * This method sets the name of the author. 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return String.format("Author[name:%s]", name);
    }
}
