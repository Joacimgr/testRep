package laboration3A;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A representation of an abstract drawablee shape. For consistency, (x,y)
 * should represent the upper-left point for all sub shapes. The velocity,
 * (dx,dy), is measured in pixels per second. Subclasses must override the
 * methods - paint(GraphicsContext), defining how to paint the specific subtype
 * - constrain(...), defining how to keep the shape inside a specified area
 * ("window"). Furthermore, som subtypes must override the move methods,
 * depending on whether the added extra members defines absolute or relative
 * coordinates.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
abstract public class Shape {

    public static final double BILLION = 1_000_000_000.0;

    private double x, y; // position of the balls center
    private double dx, dy; // velocity measured in pixels/second
    private Color color;

    protected Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    protected Shape() {
        this(0.0, 0.0, Color.BLACK);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double newX) {
        x = newX;
    }

    public void setY(double newY) {
        y = newY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }

    double getDx() {
        return dx;
    }

    double getDy() {
        return dy;
    }

    public void setVelocity(double newDx, double newDy) {
        dx = newDx;
        dy = newDy;
    }

    public void moveTo(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public void move(long elapsedTimeNs) {
        x += dx * elapsedTimeNs / BILLION;
        y += dy * elapsedTimeNs / BILLION;
    }

    abstract public void paint(GraphicsContext gc);

    public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        if (x < boxX) {
            dx = Math.abs(dx);
        } else if (x > boxWidth) {
            dx = -Math.abs(dx);
        }
        if (y < boxY) {
            dy = Math.abs(dy);
        } else if (y > boxHeight) {
            dy = -Math.abs(dy);
        }
    }

    @Override
    public String toString() {
        String info
                = this.getClass().getName() + ": x=" + x + ", y=" + y
                + ", color=" + color;
        return info;
    }
}
