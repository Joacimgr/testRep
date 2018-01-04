package laboration3A;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape{
    
    private double diameter;
    
    public Circle(){
        super();
        diameter = 1.0;
    }
    
    public double getDiameter(){
        return diameter;
    }
    
    public void setDiameter(double diameter){
        this.diameter = diameter;
    }
    
    @Override
    public void paint(GraphicsContext gc){
        
        if(isFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX(), getY(), diameter, diameter);
        }
        else{
            gc.setStroke(getColor());
            gc.strokeOval(getX(), getY(), diameter, diameter);
        }
    }
    
    @Override
    public void constrain(double boxX, double boxY, 
            double boxWidth, double boxHeight){
        
        if (getX() < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } 
        else if ((getX() + diameter) > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        
        if (getY() < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } 
        else if ((getY() + diameter) > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
        
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format(", diameter:%.2f", diameter);
    }
}
