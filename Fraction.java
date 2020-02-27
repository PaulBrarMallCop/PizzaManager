
/**
 * Write a description of class Fraction here.
 * This class should be a simple abstraction (i.e., a small class) that 
 * represents the ratio of two numbers.  There will be only two data elements,
 * and only a few methods.
 * @author (Jay Brar)
 * @version (1/20/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class Fraction implements Cloneable, Comparable { 
    // instance variables for numerator and denominator
    private int numerator;
    private int denominator;

    /**
     * Constructor for objects of class Fraction
     */
    public Fraction() {

    }

    /**
     * Constructor for objects of class Fraction that takes in values for the 
     * numerator and denominator
     */
    public Fraction(int numerator, int denominator) {
        // calls the setFraction method to set the instance variables 
        setFraction(numerator, denominator);
    }

    /**
     * getNumerator method - this method is a getter method that returns the 
     * instance  variable this.numerator
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * getDenominator method - this method is a getter method that returns the 
     * instance variable this.denominator
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * setFraction method - this method takes in a valid numerator and 
     * denominator and finds the reduced fraction using a method that returns 
     * the greatest common divisor and sets the instance variables
     */
    private void setFraction(int numerator, int denominator) {
        // returns greatest common divisor
        int gcd = euclidsGCD(numerator, denominator);

        // if its already reduced the gcd should = 0
        if(gcd == 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else { // if there is a GCD we just divide both values by it 
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }
    }

    /**
     * euclidsGCD method - this  method uses Euclids GCD theorem to find and
     * return and integer of the greatest common divisor of the numerator and 
     * denominator
     */
    private int euclidsGCD(int numerator, int denominator) {
        // returns numerator if denominator is equal to zero
        if (denominator == 0) {
            return numerator;
        }
        else { 
            // eventually the two numbers will be equal so we keep on 
            // doing it until it is
            return euclidsGCD(denominator, numerator % denominator);
        }
    }

    /**
     * equals method - this method checks to see if two fractions are equal. 
     * Returns true if there is another equal fraction and false if there isn't
     */
    public boolean equals(Object obj) {
        // Enters this path if there is an instance of a fraction
        if(obj instanceof Fraction) {
            Fraction other = (Fraction)obj;

            // Enters this path and returns true if that fraction is equal to 
            // the fraction passed in
            if(this.numerator == other.numerator && 
            this.denominator == other.denominator) {
                // returns true if input is a fraction and numerator and 
                // denominator are equal
                return true;
            }
        }

        // returns false if there isn't one thats quickly 
        return false;
    }
    
    /**
     * toDecimal method - this method returns the decimal of the current fraction.
     */
    public double toDecimal() {
        return ((double) numerator / (double) denominator);
    }

    /**
     * subtract method - this method takes in a Fraction Object and subtracts
     * it from this Object.
     */
    public Fraction subtract(Fraction amt) {
        int num, den;
        // If denominators are equal, we can subtract numerators and return
        // the new Fraction
        if (getDenominator() == amt.getDenominator()){
            num = (getNumerator() - amt.getNumerator());
            den = getDenominator();

            return new Fraction(num, den);
        } else { // Multiply denominators and numerators to get a common
            // denominator we can just subtract and return
            num = (getNumerator() * amt.getDenominator()) - 
            (amt.getNumerator() * getDenominator());
            den = getDenominator() * amt.getDenominator();
            
            return new Fraction(num, den);
        }
    }
    
    /**
     * compareTo method - compares this Fraction to a Fraction Object passed
     * in and returns an integer value based on which fraction is bigger.
     * Returns 0 if fractions are equal.
     */
    @Override
    public int compareTo(Object o) {
        // Throw exception if parameter is invalid
        if (o == null || !(o instanceof Fraction)) {
            throw new IllegalArgumentException();
        }
        Fraction other = (Fraction) o;
        // turns Fractions into decimal numbers for comparison
        double frac1 = ((double) numerator / (double) denominator);
        double frac2 = ((double) getNumerator() / (double) getDenominator());
        
        if (frac1 > frac2) {
            return 1; // if this Fraction is bigger than the one passed in
        } else if (frac2 > frac1) {
            return -1; // if the one passed in is bigger
        }
        return 0; // if they are the same
    }
    
    @Override
    /**
     * toString method - this method puts the instance variables into a string 
     * that holds the variables in a fraction that will later be outputted to 
     * the screen
     * ("<numerator>/<denominator>")
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    @Override
    /**
     * clone method - this method creates an exact copy of an object by 
     * creating a new instance of the current object and initilazing all of
     * its fields with the same contents as the current object.
     */
    public Fraction clone() {
        // Attempts to make a clone and throws an exception if it can't
        try {
            return (Fraction)super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
