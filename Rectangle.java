package laboration3A;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends FillableShape{
    
    private double width;
    private double height;
    
    public Rectangle(){
        super();
        width = 1.0;
        height = 1.0;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    @Override
    public void paint(GraphicsContext gc){
        if(isFilled()){
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(), width, height);
        }
        else{
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), width, height);
        }
    }
    
    @Override
    public void constrain(double boxX, double boxY, 
            double boxWidth, double boxHeight){
        
        if (getX() < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } 
        else if ((getX() + width) > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        
        if (getY() < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } 
        else if ((getY() + height) > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format(", width:%.2f, height:%.2f", width, height);
    }
}
