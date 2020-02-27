
/**
 * Marinara is a subclass of Base. It contains a constructor that, when
 * called, sends information specifically related to marinara sauce to the 
 * parent class Base.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Alfredo extends Base {
    /**
     * Constructor for objects of class Alfredo that calls the constructor
     * of the parent class Base.
     */
    public Alfredo()
    {
        super("Alfredo", new Money(2,0), 100);
    }
}
