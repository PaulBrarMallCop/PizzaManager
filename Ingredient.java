
/**
 * Parent class for all Ingredient subclasses. This class is at the top
 * of the hierarchy when it comes to ingredients and topings.
 *
 * @author (Jay Brar)
 * @version (3/11/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Ingredient implements Comparable {
    public final String description; 
    public final Money cost;
    public final int caloricTotal;

    /**
     * Constructor for objects of class Ingredient
     */
    public Ingredient(String description, Money cost, int calories) {
        this.description = description;
        this.cost = cost;
        this.caloricTotal = calories;
    }

    /**
     * compareTo method - this method compares Ingredient objects. Since it 
     * compares based on cost, we can use it as a facade to point towards to 
     * the compareTO method in Money.
     */
    @Override
    public int compareTo(Object other) {
        // Throws exception if paramater is invalid
        if (other == null || !(other instanceof Ingredient)) {
            throw new PizzaException();
        }
        // Typecast to turn other into an Ingredient object
        Ingredient valid = (Ingredient)other;
        // We just return the Money classes compareTo since it already
        // compares money values 
        return cost.compareTo(valid.cost);
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
            Ingredient otherIngredient = (Ingredient) otherObject;
            return (description.equals(otherIngredient.description) &&
                cost.equals(otherIngredient.cost) && 
                caloricTotal == otherIngredient.caloricTotal);
        }
    }

    /**
     * toString method - this method returns a string containing the 
     * description, cost, and caloricTotal of the current Ingredient
     */
    @Override
    public String toString() {
        return this.description + " " + this.cost + " " + this.caloricTotal;
    }
    
    /**
     * Ingredient driver - used for testing methods of Ingredient
     */
    public static void main(String[] args) {
        Ingredient test1 = new Ingredient("Onion", new Money(3, 50), 100);
        System.out.println(test1); // Testing toString
        
        Ingredient test2 = new Ingredient("Onion", new Money(3, 50), 100);
        System.out.println(test1.equals(test2)); // Should print true
        
        System.out.println(test1.compareTo(test2)); // Works
    }
}
