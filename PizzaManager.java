import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
////////////////////////////////////////////////////////////////////////////////
public class PizzaManager {
    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    int numPizzas = 0;

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        Scanner foo = new Scanner(System.in);
        char selection;

        do {
            displayAllPizzas();
            displayInstructions();

            selection = foo.next().charAt(0);

            //foo.nextChar() doesn't exist, so now what?
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                addRandomPizza();
                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                addOneHundred();
                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                eatSomePizza(foo);
                break;            
                case 'P':    
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                sortByPrice();
                break;    
                case 'S':    
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                sortBySize();
                break;          
                case 'C':    
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                sortByCalories();
                break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                int cal = foo.nextInt();
                System.out.println(binarySearchByCalories(cal));
                break;
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                System.exit(0);
                break;
                default:    System.out.println("Unrecognized input - try again");
            }
        } while(selection != 'q');
    }

    /** 
     * eatSomePizza method - uses Scanner Object for user desired index and 
     * fraction. If input is valid, we subtract that fraction from the Pizza
     * object in that index of the list.
     */
    private void eatSomePizza(Scanner keys) {
        int index;
        String fraction;

        Scanner input = new Scanner(System.in); // Calling Scanner Object

        fraction = input.next(); // Store ow much they want to eat

        do { // do-while loop that repeats until they input a valid index
            System.out.println("At which index?");
            index = input.nextInt();
        } while(index < 0 || index > numPizzas);

        String[] frac = fraction.split("/"); // Turn string into real fraction
        int numerator = Integer.parseInt(frac[0]);
        int denominator = Integer.parseInt(frac[1]);

        Pizza holder = null;

        // try-catch block that will attempt to subtract fraction from the pizza 
        // object in the list
        try {
            holder = (Pizza) pizzas.get(index);
            // attempt to subtract fraction from desired pizza object
            holder.eatSomePizza(new Fraction(numerator, denominator));

            pizzas.insert(holder, index); // Insert new subtracted Pizza
            pizzas.remove(index + 1); // Remove old Pizza            
            System.out.println(pizzas.get(index)); // Print to screen
        } catch (PizzaException e) { // if we subtracted more than we had
            System.out.println(e.getMessage()); // print error message
        } catch (RuntimeException e) { // if Pizza is finished
            System.out.println("Pizza at index " + index + " is finished.");
            pizzas.remove(index); // Remove the Pizza from the list
        } 
        System.out.println();
    }

    /** 
     * addRandomPizza method - creates a random Pizza Object and adds it to the 
     * end of our list.
     */
    private void addRandomPizza() {
        Pizza random = new Pizza(); // Calling constructor already randomizes it
        pizzas.insert(random, numPizzas); // insert at the end of the list
        numPizzas++; // increment counter by 1
    }

    /** 
     * addOneHundred method - creates 100 random Pizza Objects and adds them
     * to the end of our list.
     */
    private void addOneHundred() {
        for (int i = 0; i < 100; i++) {
            addRandomPizza(); // Just need to call this method 100 times
            // since it adds one random Pizza to the list
        }
    }

    /** 
     * displayAllPizzas method - lists all the pizzas in their current order.
     */
    private void displayAllPizzas() {
        System.out.println(pizzas); // Calls ArrayList's toString method
    }

    /** 
     * sortByPrice method - sorts all the Pizzas in the list based on price,
     * with greatest price first.
     */
    private void sortByPrice() {  
        int minIndex;
        Pizza min; // will store our lesser priced Pizza

        for (int k = 0; k < pizzas.size(); k++) {
            min = (Pizza) pizzas.get(k);
            minIndex = k;
            for (int j = k + 1; j < pizzas.size(); j++) {
                // Use compareTo to compare the costs and store values
                if (((Pizza) pizzas.get(j)).getCost().compareTo(min.getCost()) < 0) {
                    min = (Pizza) pizzas.get(j); // Store the new min
                    minIndex = j; // change out minIndex to j
                }
            }
            pizzas.insert((Pizza) pizzas.get(k), minIndex); // Insert at minIndex
            pizzas.remove(minIndex + 1); // Need to remove at +1 since its a list
            pizzas.insert(min, k); // insert our min at k
            pizzas.remove(k + 1); // remove again
        }               
    }

    /** 
     * sortBySize method - sorts all the Pizzas in the list based on remaining
     * area, with the largest remaining areas first.
     */
    private void sortBySize() {
        int minIndex;
        Pizza min; // will store our lesser area Pizza

        for (int k = 0; k < pizzas.size(); k++) {
            min = (Pizza) pizzas.get(k);
            minIndex = k;
            for (int j = k + 1; j < pizzas.size(); j++) {
                // Use compareTo tot compare the remaining areas and store values
                if (((Pizza) pizzas.get(j)).getRemaining().compareTo(min.getRemaining()) < 0) {
                    min = (Pizza) pizzas.get(j); // Store the new min
                    minIndex = j; // change out minIndex to j
                }
            }
            pizzas.insert((Pizza) pizzas.get(k), minIndex); // Insert at minIndex
            pizzas.remove(minIndex + 1); // Need to remove at +1 since its a list
            pizzas.insert(min, k); // insert our min at k
            pizzas.remove(k + 1); // remove again
        }
    }

    /** 
     * sortByCalories method - sorts all the Pizzas in the list based on 
     * calories, with the largest calorie pizza first.
     */
    private void sortByCalories() {
        int minIndex;
        Pizza min; // will store our lesser calorie Pizza

        for (int k = 0; k < pizzas.size(); k++) {
            min = (Pizza) pizzas.get(k);
            minIndex = k;
            for (int j = k + 1; j < pizzas.size(); j++) {
                // Use signs to compare the calories and store values
                if (((Pizza) pizzas.get(j)).getCalories() < min.getCalories()) {
                    min = (Pizza) pizzas.get(j); // Store a lesser cal pizza
                    minIndex = j; // set the minIndex to J
                }
            }
            pizzas.insert((Pizza) pizzas.get(k), minIndex); // Insert at minIndex
            pizzas.remove(minIndex + 1); // Need to remove at +1 since its a list
            pizzas.insert(min, k); // insert our min at k
            pizzas.remove(k + 1); // remove again
        }
    }

    /** 
     * binarySearchCalories method - searches over pizzas using their calorie
     * count. List needs to be sorted prior to the search.
     */
    private int binarySearchByCalories(int cals) {
        sortByCalories(); // Sort our list prior to search       
        int low = 0; 
        int high = numPizzas - 1;
        int middle;

        // while loop that will perform a binary search through the entire list
        while (low <= high) {
            middle = (low + high) / 2; // Find our mid index first

            if (cals == ((Pizza) pizzas.get(middle)).getCalories()) {
                return middle; // Return middle if its our target         
            } else if (cals < ((Pizza) pizzas.get(middle)).getCalories()) {
                high = middle - 1; // Change high limit if cals is lower  
            } else if (cals > ((Pizza) pizzas.get(middle)).getCalories()) {
                low = middle + 1; // Change low limit if cals is lower 
            }
        }
        // If for some reason we reach here, it will be because we couldn't 
        // locate the target Object
        throw new PizzaException("Pizza not found");
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
