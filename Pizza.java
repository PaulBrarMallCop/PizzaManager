import java.awt.Color;
import java.util.Random;
/**
 * A Pizza has a list of ingredients, a shape, a cost, a calorie total, and a
 * few other details. This class creates a pizza and includes methods for 
 * creating and eating a pizza.
 *
 * @author (Jay Brar)
 * @version (3/14/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Pizza implements PizzaComparable {
    private ArrayList<Ingredient> ingredients; // Holds toppings
    private int calorieCount; // Total calories
    private Money cost; // Total cost
    private Shape myShape; // Pizza Shape
    private Fraction remainingPizza; // Pizza left

    /**
     * Constructor for objects of class Pizza that uses java.Random to create
     * a random Pizza
     */
    public Pizza() {
        this.ingredients = new ArrayList<Ingredient>();
        this.calorieCount = 0;
        this.cost = new Money(0);
        this.remainingPizza = new Fraction(1, 1);

        Random rand = new Random(); // Enables us to get random integers

        // Randomly selecting shape
        if (rand.nextInt(2) == 1) {
            myShape = new Circle(0, 0, rand.nextInt(20));
        } else {
            myShape = new Square(0, 0, rand.nextInt(20));
        }

        // Randomly selecting base ingredient
        if (rand.nextInt(2) == 1) {
            addIngredient(new Marinara());
        } else {
            addIngredient(new Alfredo());
        }

        // Randomly selecting cheese ingredient
        if (rand.nextInt(2) == 1) {
            addIngredient(new Mozzarella());
        } else {
            addIngredient(new Goat());
        }

        // Randomly selecting meat ingredient
        if (rand.nextInt(2) == 1) {
            addIngredient(new Pepperoni());
        } else {
            addIngredient(new Sausage());
        }

        // Randomly selecting veggie
        if (rand.nextInt(2) == 1) {
            addIngredient(new Pepper());
        } else {
            addIngredient(new Olive());
        }
    }

    /**
     * getFraction method - returns a Fraction Object related to the amount
     * of remaining pizza.
     */
    public Fraction getRemaining() {
        return remainingPizza.clone(); // clone for privacy leaks
    }

    /**
     * setFraction method - takes in a Fraction Object and sets it equal to
     * the instance variable remainingPizza.
     */
    public void setRemaining(Fraction f) {
        remainingPizza = f.clone();
    }

    /**
     * getCalories method - returns the total calories account of the current 
     * pizza
     */
    public int getCalories() {
        return calorieCount;
    }

    /**
     * getCost method - returns a Cost Object related to the total cost of 
     * the current pizza
     */
    public Money getCost() {
        return cost.clone(); // clone for privacy leaks
    }

    /**
     * getRemainingArea method - returns a double related to the remaining area
     * left of the pizza.
     */
    public double getRemainingArea() {
        // We just need to multiply the total area by the decimal of the 
        // remaining Fraction
        return (myShape.getArea() * remainingPizza.toDecimal());
    }

    /**
     * setShape method - takes in a Shape Object and sets it equal to
     * the instance variable myShape.
     */
    public void setShape(Shape s) {
        myShape = (Shape) s.clone(); // clone for privacy leaks
    }

    /**
     * getShape method - returns the shape of the current pizza.
     */
    public Shape getShape() { 
        return (Shape) myShape.clone(); // clone for privacy leaks
    }

    /**
     * addIngredient method - takes in an Ingredient Object and inserts it
     * into our Ingredient list, adds it to out calorie total, and adds it 
     * to our total cost for the current pizza.
     */
    public void addIngredient(Ingredient a) {
        // Throw exception if parameter is invalid
        if (a == null) {
            throw new PizzaException("Not a valid ingredient");
        }       
        ingredients.insert(a, ingredients.size()); // inserts into list
        calorieCount += a.caloricTotal; // adds to calorie total
        cost.add(a.cost.getDollars(), a.cost.getCents()); // adds to total cost
    }

    /**
     * eatSomePizza method - this method takes in a Fraction Object and 
     * subtracts it from Fraction remainingPizza. Changes remainingPizza
     * based on how much pizza is leftover after the subtraction.
     */
    public void eatSomePizza(Fraction amt) { 
        // Throw exception if parameter is invalid
        if (amt == null) {
            throw new IllegalArgumentException("Not a valid ingredient");
        }  
        // attempt to subtract the amount from this pizza
        Fraction newRemaining = remainingPizza.subtract(amt);

        if (newRemaining.getNumerator() < 0) {
            throw new PizzaException("Can't have negative pizza remaining"); 
            // Throw if we have a neg numerator
        } else if (newRemaining.getNumerator() == 0) {
            throw new RuntimeException(); // Throw if our pizza is all eaten
        }

        // Following reduces the cost based on how much we ate
        // This is complicated because we need to split ints for dollars and
        // cents from a decimal so we multiply the decimal by 100 to get an int
        double reducedPrice = 100 * (cost.getMoney() * newRemaining.toDecimal());
        int dollars = (int) reducedPrice / 100; // / 100 to get the dollars
        int cents = (int) reducedPrice % 100; // % 100 to get the cents

        cost = new Money(dollars, cents); // Changing the total cost
        remainingPizza = newRemaining; // Changing the remaining amount
    }

    /**
     * compareTo method - compares Pizzas based on price. Basically just 
     * a pointer to Money since it already has a compareTo method based on
     * price.
     */
    @Override
    public int compareTo(Object o) {
        // Throw exception if parameter is invalid
        if (o == null || !(o instanceof Pizza)) {
            throw new IllegalArgumentException();
        }
        Pizza other = (Pizza) o; // type casting Object to Pizza       
        return cost.compareTo(other.cost); // calling the money compareTo method
    }

    /**
     * compareToBySize method - compares Pizzas based on how much area each
     * pizza has left.
     */
    @Override
    public int compareToBySize(Object o) {
        // Throw exception if parameter is invalid
        if (o == null || !(o instanceof Pizza)) {
            throw new IllegalArgumentException();
        }
        Pizza other = (Pizza) o; // type casting Object to Pizza  

        if (this.getRemainingArea() > other.getRemainingArea()) {
            return 1; // if this pizza has more remaining area
        } else if (this.getRemainingArea() < other.getRemainingArea()) {
            return -1; // if the other pizza has more remaining area
        }        

        return 0; // if both areas are equal
    }

    /**
     * compareToByCalories method - compares Pizzas based on price how each 
     * pizzas total calories.
     */
    @Override
    public int compareToByCalories(Object o) {
        // Throw exception if parameter is invalid
        if (o == null || !(o instanceof Pizza)) {
            throw new IllegalArgumentException();
        }
        Pizza other = (Pizza) o; // type casting Object to Pizza  
        return calorieCount - other.calorieCount;
    }

    /**
     * toString method - this method returns a string containing the 
     * containg the instance variables of the current Pizza Object.
     */
    @Override
    public String toString() {
        return "Pizza has a price:" + getCost() + " and calories:" + 
        getCalories() + ", Fraction remaining:" + getRemaining() +
        "\nand area left:" + getRemainingArea() + " and shape:" +
        getShape();
    }

    /**
     * Driver for Pizza - used to test Pizza methods
     */
    public static void main(String[] args) {
        Pizza test1 = new Pizza();        
        System.out.println(test1);
        
        // Testing getters
        System.out.println(test1.getRemaining());
        System.out.println(test1.getCalories());
        System.out.println(test1.getCost());
        System.out.println(test1.getRemainingArea());
        System.out.println(test1.getShape());
        
        // Testing setters
        test1.setRemaining(new Fraction(1, 2));
        //test1.setShape(new Square(0, 0, 15));
        System.out.println(test1);
        test1.setRemaining(new Fraction(1, 1));
        
        // Testing eat some method
        Pizza test2 = new Pizza();        
        test2.eatSomePizza(new Fraction(1, 4));
        test1.eatSomePizza(new Fraction(1, 2));
        System.out.println(test1);
        System.out.println(test2); // Price and area should go down
        
        // Testing compareTo methods
        System.out.println(test1.compareTo(test1)); // Should output 0
        System.out.println(test1.compareTo(test2)); 
        
        System.out.println(test1.compareToBySize(test1)); // Should output 0
        System.out.println(test1.compareToBySize(test2)); 
        
        System.out.println(test1.compareToByCalories(test1)); // Should output 0
        System.out.println(test1.compareToByCalories(test2)); 
    }
}
