
/**
 * Base is a subclass of ingredient. It is the superclass to 2 other 
 * classes that specify types of sauce for the pizza.
 *
 * @author (Jay Brar)
 * @version (3/12/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Base extends Ingredient {
    /**
     * Constructor for objects of class Base that sends arguements to
     * super constructor (Ingredient)
     */
    public Base(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
    
    /**
     * Base driver - used for testing methods of Base
     */
    public static void main(String[] args) {
        Ingredient test1 = new Ingredient("Alfredo", new Money(2, 11), 142);
        System.out.println(test1); // Testing toString
        
        Ingredient test2 = new Ingredient("Alfredo", new Money(2, 11), 142);
        System.out.println(test1.equals(test2)); // Should print true
        
        System.out.println(test1.compareTo(test2)); // Works
    }
}
