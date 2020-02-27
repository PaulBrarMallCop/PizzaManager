
/**
 * Mozzarella is a subclass of Cheese. It contains a constructor that, when
 * called, sends information specifically related to mozzarella cheese to the 
 * parent class Cheese.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Mozzarella extends Cheese {
    /**
     * Constructor for objects of class Mozzarella that calls the constructor
     * of the parent class Cheese.
     */
    public Mozzarella()
    {
        super("Mozzarella", new Money(1, 0), 160);
    }
}
