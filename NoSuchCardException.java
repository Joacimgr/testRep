package laboration3C;

public class NoSuchCardException extends RuntimeException{
    
    private final int index;
    
    public NoSuchCardException(int index){
        this.index = index;
    }
    
    @Override
    public String getMessage(){
        return String.format("Unable to access card at index: %d", index);
    }
}
