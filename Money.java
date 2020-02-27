
/**
 * This class is used to track a USD amount consisting of two integers to manage 
 * dollars and cents.  All dollars and cents will be positive or 0, and cents
 * will never exceed 99.
 * 
 * @author (Jay Brar)
 * @version (2/27/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Money implements Comparable<Money>, Cloneable, java.io.Serializable {
    private int dollars;
    private int cents;

    /**
     * Constructor for objects of class Money - sets the dollar amount to 
     * the assigned value and cents to 0
     */
    public Money(int dol) {
        setDollars(dol); // only sets if values are valid
        this.cents = 0;
    }

    /**
     * Constructor for objects of class Money - sets both the dollar amount and
     * cent amount to the values passed into the method
     */
    public Money(int dol, int cent) {
        setDollars(dol); // only sets if values are valid
        setCents(cent); 
    }

    /**
     * getDollars - this method returns an integer of the current dollar
     * amount assigned to this.dollars
     */
    public int getDollars() {
        return this.dollars;
    }

    /**
     * getCents - this method returns an integer of the current cent
     * amount assigned to this.cents
     */
    public int getCents() {
        return this.cents;
    }

    /**
     * setDollars - this method takes in an int for dollars and assigns it
     * to the instance variable this.dollars if the value passed in is a
     * non-negative number
     */
    public void setDollars(int dol) {
        if (dol > 0) {
            this.dollars = dol;
        }
    }

    /**
     * setCents - this method takes in an int for cents and assigns it
     * to the instance variable this.cents if the value passed in is a
     * non-negative number and less than 100 (which is equal to $1)
     */
    public void setCents(int cent) {
        if (cent > 0 && cent < 100) {
            this.cents = cent;
        }
    }

    /**
     * getMoney - this method returns the double value of the current amount
     * relating to the current dollar amount in the class
     */
    public double getMoney() {
        // we just need to add the decimal amount of this.cents to this.dollars
        return this.dollars + this.cents/100.0; // divide by 100.0 for the decimal
    }

    /**
     * setMoney - this method takes in values for dollar and cents and calls
     * setDollars and setCents which check the values and assign them to the
     * instance variables if they're valid. 
     */
    public void setMoney(int dol, int cent) {
        setDollars(dol); 
        setCents(cent);
    }

    /**
     * add method - this method passes along the value passed in to the other
     * add method which will add it to the current dollar amount.
     */
    public void add(int dol) {
        add(dol, 0);
    }

    /**
     * add method - this method takes in values for dollars and cents and add
     * them to the current amounts attached to this.dollars and this.cents if
     * the values passed in are non-negative.
     */
    public void add(int dol, int cents) {
        // Adds to this.dollars if dol is a positive number
        if (dol > 0) {
            // add dol amount and cents/100 because this converts the cents
            // to dollars since 100 cents = 1 dollar
            this.dollars += dol + cents / 100;
        }
        // Adds to this.cents if cents is a positive number
        if (cents > 0) {
            // add cents % 100 because the cents can't be over 100 and it
            // will already be added to the dollar amount if it is
            this.cents += cents % 100;
        }
    }

    /**
     * add method - this add method takes in another Money object and 
     * adds the dollar and cents amount from that object to the current 
     * instance of the class we are in.
     */
    public void add(Money other) {
        // Just need to pass in the instance variables from other
        add(other.dollars, other.cents);
    }

    @Override
    /**
     * equals method - this method takes in an object and checks to see if it 
     * is equal to the current instance of the class. Returns true if they are 
     * equal and false if they are not.
     */
    public boolean equals(Object o) {
        // if there is another Money object enter here
        if (o instanceof Money) {
            Money money = (Money)o;
            // compares the instance variables from both objects
            if (this.dollars == money.dollars && this.cents == money.cents)
                return true; // returns true if they're equal
        }

        return false; // they aren't equal
    }

    @Override
    /**
     * toString method - this method returns a string that formats the 
     * dollar and cents amounts into an actual monetary value
     */
    public String toString() {
        // need to format so we have two decimal places for cents
        return "$" + String.format("%.2f", getMoney());
    }

    @Override
    /**
     * compareTo method - this method compares the current class to the 
     * instance of the class passed into the method and returns a postive 
     * integer if this this money amount is bigger than the amount passed 
     * in, a negative integer if this money  amount is less than the one 
     * passed in, and 0 if the amounts are equal.
     */
    public int compareTo(Money other) {
        // we need to multiply the dollars by 100 because dividing cents by
        // 100 and adding that to dollars will give us a double so we do 
        // reverse which will give as an int we can compare similarly
        int thisAmount = 100 * this.dollars + this.cents;
        int otherAmount = 100 * other.dollars + other.cents;
        
        return thisAmount - otherAmount;
    }
    
    @Override
    /**
     * clone method - this method creates an exact copy of an object by 
     * creating a new instance of the current object and initilazing all of
     * its fields with the same contents as the current object.
     */
    public Money clone() {
        // Attempts to make a clone and throws an exception if it can't
        try {
            return (Money)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
