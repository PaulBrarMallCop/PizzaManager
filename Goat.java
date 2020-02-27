
/**
 * Goat is a subclass of Cheese. It contains a constructor that, when
 * called, sends information specifically related to goat cheese to the 
 * parent class Cheese.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Goat extends Cheese {
    /**
     * Constructor for objects of class Goat that calls the constructor
     * of the parent class Cheese.
     */
    public Goat()
    {
        super("Goat", new Money(1, 50), 230);
    }
}
