import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

class Square extends Shape  {
    private int sideLength;

    public Square(int a, int b, int length) {
        super(a, b);
        this.sideLength = length;
    }

    //getSide:  Add this getter method
    public int getSideLength() {
        return this.sideLength;
    }

    //setSide:  Add this setter method
    public void setSideLength(int length) {
        this.sideLength = length;
    }

    public double getArea() {
        return sideLength * sideLength; 
    }

    public void draw(Graphics g) {
        g.fill3DRect(getX(), getY(), sideLength, sideLength, false);
    }

    /**
     * toString method - returns a descriptor of the class Square.
     */
    @Override
    public String toString() {
        return "Square";
    }

    @Override
    /**
     * clone method - this method creates an exact copy of an object by 
     * creating a new instance of the current object and initilazing all of
     * its fields with the same contents as the current object.
     */
    public Square clone() {
        try {
            return new Square(getX(), getY(), (int)getSideLength());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        }
    }
}
