
/**
 * Just a regular custom exception class to be used by other classes
 * in the final assignment.
 *
 * @author (Jay Brar)
 * @version (3/11/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class PizzaException extends RuntimeException {
    /**
     * Constructor for objects of class PizzaException
     */
    public PizzaException() {
        super();
    }

    /**
     *  Constructor for objects of class PizzaException that takes in a string
     *  that will be passed into super
     */
    public PizzaException(String message) {
        super(message);
    }
}
