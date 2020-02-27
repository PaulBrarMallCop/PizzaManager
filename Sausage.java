
/**
 * Sausage is a subclass of Meat. It contains a constructor that, when
 * called, sends information specifically related to sausage to the 
 * parent class Meat.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Sausage extends Meat {
    /**
     * Constructor for objects of class Sausage that calls the constructor
     * of the parent class Meat.
     */
    public Sausage()
    {  
        super("Sausage", new Money(1, 25), 195);
    }
}
