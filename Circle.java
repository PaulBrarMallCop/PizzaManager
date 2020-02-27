import java.awt.*;
/**
 * Circle class that extends Shape and overrides some of the methods
 * in the superclass with methods specific to circles.
 * (FROM LAB)
 * @author (Jay Brar)
 * @version (2/11/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Circle extends Shape implements Cloneable {
    private double radius;

    /**
     * Constructor for Circle - takes in arguements for x, y, and radius
     * of the circle.
     */
    public Circle(int x, int y, double radius) {
        super(x, y); // gives the values of x and y to the superclass Shape
        this.radius = radius;
    }

    @Override
    /**
     * getArea method - this method returns the area of the circle.
     */
    public double getArea() {
        return Math.PI * (this.radius * this.radius); // A = pi * r^2
    }

    @Override
    /**
     * draw method - this method draws a filled circle using Graphics2D and 
     * getter methods for x, y, width, and height (radius).
     */
    public void draw(Graphics g) {
        // following lets us treat g like a Graphics2D object
        Graphics2D g2d = (Graphics2D)g;

        g2d.fillOval(getX(), getY(), (int)this.radius, (int)this.radius);
    }

    /**
     * getRadius method - getter method that returns a double related
     * to the radius of the circle.
     */
    public double getRadius() {
        return this.radius;
    }

    /**
     * setRadius method - setter method that sets the radius of the circle
     * equal to the double passed into the method.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * toString method - returns a descriptor of the class Circle.
     */
    @Override
    public String toString() {
        return "Circular";
    }

    @Override
    /**
     * clone method - this method creates an exact copy of an object by 
     * creating a new instance of the current object and initilazing all of
     * its fields with the same contents as the current object.
     */
    public Circle clone() {
        // Attempts to make a clone and throws an exception if it can't
        try {
            return new Circle(getX(), getY(), getRadius());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }
    }

    /**
     * main method - this method is used to test the methods of this class.
     */
    public static void main(String[] args) {
        Circle c = new Circle(0, 0, 10);

        System.out.println(c.getArea()); // Should output about 314
        System.out.println(c.getRadius()); // Should output 10.0

        c.setRadius(17); // changing the radius to 17

        System.out.println(c.getArea()); // Should output about 907
        System.out.println(c.getRadius()); // Should output 17.0
    }
}
