
/**
 * Meat is a subclass of ingredient. It is the superclass to 2 other 
 * classes that specify meat toppings for the pizza.
 *
 * @author (Jay Brar)
 * @version (3/12/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Meat extends Ingredient {
    /**
     * Constructor for objects of class Meat that sends arguements to
     * super constructor (Ingredient)
     */
    public Meat(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
    
    /**
     * Meat driver - used for testing methods of Meat
     */
    public static void main(String[] args) {
        Ingredient test1 = new Ingredient("Pepperoni", new Money(4, 67), 200);
        System.out.println(test1); // Testing toString
        
        Ingredient test2 = new Ingredient("Pepperoni", new Money(4, 67), 200);
        System.out.println(test1.equals(test2)); // Should print true
        
        System.out.println(test1.compareTo(test2)); // Works
    }
}
