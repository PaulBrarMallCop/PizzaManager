import java.awt.Color;
/**
 * Vegetable is a subclass of ingredient. It is the superclass to 2 other 
 * classes that specify vegetable toppings for the pizza.
 *
 * @author (Jay Brar)
 * @version (3/12/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Vegetable extends Ingredient {  
    private Color color;

    /**
     * Constructor for objects of class Vegetable that sends arguements to
     * super constructor
     */
    public Vegetable(String desc, Money cost, int calories) {
        super(desc, cost, calories);
    }

    /**
     * Constructor for objects of class Vegetable that sends arguements to
     * super constructor and also takes in Color for the Vegetable class
     */
    public Vegetable(String desc, Money cost, int calories, Color choice) {
        super(desc, cost, calories);
        this.color = choice;
    }

    /**
     * setColor method - this method takes in a Color object and stores it
     * in the isntance variable this.color
     */
    public void setColor(Color choice) {
        this.color = choice;
    }

    /**
     * getColor method - this method returns the Color Object associated with
     * this.color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * equals method - this method takes in an Object and checks to see if
     * it is equal to the current instance of the class.
     */
    @Override
    public boolean equals(Object otherObject) {
         // Returns false if Object passed in is null or not the same 
        // class as this
        if (otherObject == null) {
            return false;
        } else if (getClass() != otherObject.getClass()) {
            return false;
        } else { // Here, we just compare instance variables for equality
            Vegetable otherVegetable = (Vegetable) otherObject;
            if (this.color.equals(otherVegetable.color) &&
            description.equals(otherVegetable.description) &&
            cost.equals(otherVegetable.cost) && 
            caloricTotal == otherVegetable.caloricTotal) {
                return true;
            }
        }
        return false;
    }

    /**
     * toString method - this method returns a string containing the 
     * description, cost, caloricTotal, amnd color of the current Vegetable
     */
    @Override
    public String toString() {
        return (super.toString() + " " + getColor().toString());
    }
    
    /**
     * Vegetable driver - used for testing methods of Vegetable
     */
    public static void main(String[] args) {
        Vegetable test1 = new Vegetable("Ham", new Money(2, 50), 120, Color.red);
        System.out.println(test1); // Testing toString
        
        Vegetable test2 = new Vegetable("Ham", new Money(2, 50), 120, Color.red);
        System.out.println(test1.equals(test2)); // Outputs true
        
        System.out.println(test1.compareTo(test2)); // Works
    }
}