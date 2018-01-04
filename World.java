package laboration3A;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

public class World {

    private double width, height; // this worlds width and height

    private final ArrayList<Shape> shapes; // Changed this to an ArrayList of shapes.

    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new ArrayList<>(); // an array of references (change to non-zero size)

        //Set initial values for objects of shape subtypes
        //Circle
        Circle circle = new Circle();
        circle.setDiameter(200);
        circle.setVelocity(76, 100);
        circle.setColor(Color.RED);

        //Rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(30);
        rectangle.setX(200);
        rectangle.setY(200);
        rectangle.setColor(Color.GREEN);
        rectangle.setVelocity(111, 100);

        //Line
        Line line = new Line();
        line.setX(20);
        line.setY(20);
        line.setX2(23);
        line.setY2(88);
        line.setColor(Color.BLUE);
        line.setVelocity(133, 200);
        
        //Add shapes
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(line);

        //Check if shape is instance of FillableShape, if so, set filled.
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof FillableShape) {
                System.out.println("Is instance of FillableShape: " + shapes.get(i).toString());
                ((FillableShape)shapes.get(i)).setFilled(true);
            }
        }   
    }

    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public void move(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).move(elapsedTimeNs);
            shapes.get(i).constrain(0, 0, width, height);
        }
        System.out.println(width + ", " + height);
    }

    public ArrayList<Shape> getShapes() {
        return (ArrayList<Shape>) shapes.clone();
    }
}
