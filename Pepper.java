import java.awt.Color;
/**
 * Pepper is a subclass of Vegetable. It contains a constructor that, when
 * called, sends information specifically related to peppers to the 
 * parent class Vegetable.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Pepper extends Vegetable {
    /**
     * Constructor for objects of class Pepper that calls the constructor
     * of the parent class Vegetable.
     */
    public Pepper()
    {
        super("Pepper", new Money(1, 0), 80, Color.green);
    }
}
