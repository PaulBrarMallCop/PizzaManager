import java.awt.Color;
/**
 * Olive is a subclass of Vegetable. It contains a constructor that, when
 * called, sends information specifically related to olives to the 
 * parent class Vegetable.
 *
 * @author (Jay Brar)
 * @version (3/13/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Olive extends Vegetable {
    /**
     * Constructor for objects of class Olive that calls the constructor
     * of the parent class Vegetable.
     */
    public Olive() {
        super("Olive", new Money(1, 0), 90, Color.black);
    }
}
