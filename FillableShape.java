package laboration3A;

public abstract class FillableShape extends Shape{
    
    private boolean filled;
    
    protected FillableShape(){
        super();
        filled = false;
    }
    
    public boolean isFilled(){
        return filled;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format(", filled:%s", filled);
    }
}
