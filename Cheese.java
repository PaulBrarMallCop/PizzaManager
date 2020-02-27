
/**
 * Cheese is a subclass of ingredient. It is the superclass to 2 other 
 * classes that specify cheese toppings for the pizza.
 *
 * @author (Jay Brar)
 * @version (3/12/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Cheese extends Ingredient {
    /**
     * Constructor for objects of class Cheese that sends arguements to
     * super constructor (Ingredient)
     */
    public Cheese(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
    
    /**
     * Cheese driver - used for testing methods of Cheese
     */
    public static void main(String[] args) {
        Ingredient test1 = new Ingredient("Cheddar", new Money(3, 50), 100);
        System.out.println(test1); // Testing toString
        
        Ingredient test2 = new Ingredient("Cheddar", new Money(3, 50), 100);
        System.out.println(test1.equals(test2)); // Should print true
        
        System.out.println(test1.compareTo(test2)); // Works
    }
}
