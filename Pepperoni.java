
/**
 * Pepperoni is a subclass of Meat. It contains a constructor that, when
 * called, sends information specifically related to pepperoni to the 
 * parent class Meat.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Pepperoni extends Meat {
    /**
     * Constructor for objects of class Pepperoni that calls the constructor
     * of the parent class Meat.
     */
    public Pepperoni()
    {
        super("Pepperoni", new Money(1, 0), 160);
    }
}
