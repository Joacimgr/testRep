package laboration3A;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape{
    
    private double x2;
    private double y2;
    
    /*
    Initialize line as dot at (0,0) 
    */
    public Line(){
        this(0, 0);
    }
    
    public Line(double x2, double y2){
        super();
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public double getX2(){
        return x2;
    }
    
    public double getY2(){
        return y2;
    }
    
    public void setX2(double x2){
        this.x2 = x2;
    }
    
    public void setY2(double y2){
        this.y2 = y2;
    }
    
    @Override
    public void paint(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), getX() + x2, getY() + y2);
    }
    
    @Override
    public void constrain(double boxX, double boxY, 
            double boxWidth, double boxHeight){
        // If outside the box - calculate new dx and dy
        if (getX() < boxX || (getX() + x2) < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } 
        else if (getX() > boxWidth || (getX() + x2) > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        
        if (getY() < boxY || (getY() + y2) < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } 
        else if (getY() > boxHeight || (getY() + y2) > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format(", x2=%.2f, y2=%.2f", x2, y2);
    }
}
