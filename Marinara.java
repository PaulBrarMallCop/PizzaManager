
/**
 * Marinara is a subclass of Base. It contains a constructor that, when
 * called, sends information specifically related to marinara sauce to the 
 * parent class Base.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Marinara extends Base {
    /**
     * Constructor for objects of class Marinara that calls the constructor
     * of the parent class Base. 
     */
    public Marinara()
    {
        super("Marinara", new Money(1, 00), 80);
    }
}
