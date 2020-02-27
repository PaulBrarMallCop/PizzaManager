import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * ArrayList class that adds and removes elements of an array at different 
 * indices and opens and closes the array when elements of it are manipulated.
 *
 * @author (Jay Brar)
 * @version (2/27/2019)
 */
////////////////////////////////////////////////////////////////////////////////
public class ArrayList<T> implements Iterable<T> {
    private Object[] arrayList;
    private int size = 0;

    /**
     * ArrayList constructor - Initializes the array to hold 1 object.
     */
    public ArrayList() {
        this.arrayList = new Object[1];
        this.size = 0;
    }

    /**
     * insert method - this method takes in an Object and an index and inserts 
     * the given Object into the list at that index if the parameters are valid.
     */
    public void insert(T item, int index) {
        // if parameters are invalid end here
        if (index < 0 || index > this.size || item == null) {
            return;
        }

        // if this is the first Object being added into the list
        if (this.size == 0) {
            this.arrayList[0] = item; // just add the item
        } else { // if there are already Objects in the list
            // create a copy array thats one size bigger than this.arrayList
            Object[] copyList = new Object[this.size + 1];

            // for-loop that transfers values into the copy up until it 
            // reaches the index passed through
            for (int i = 0; i < index; i++) {
                copyList[i] = this.arrayList[i];
            }

            // for-loop that starts at index + 1 and transfers those values 
            // into the copy to create a gap where we want to insert the Object
            for (int i = index + 1; i < this.size + 1; i++) {
                // we do i - 1 because we want to shift the elements starting 
                // at the index to the right
                copyList[i] = this.arrayList[i - 1];
            }

            copyList[index] = item; // inserts the Object at the given index
            this.arrayList = copyList;         
        }

        this.size++; // increase size by 1 because we just added to the list
    }

    /**
     * 
     */
    public Object remove(int index) {
        // returns null if the index passed in is an invalid index
        if (index < 0 || index > this.size) {
            return null;
        }

        // stores the object at the desired index
        Object removed = this.arrayList[index];
        // create a copy list that is one position smaller than this.arrayList
        Object[] copyList = new Object[this.size - 1];

        // for-loop that transfers values into the copy up until it 
        // reaches the index passed through
        for (int i = 0; i < index; i++) {
            copyList[i] = this.arrayList[i];
        }

        // for-loop that starts at the index and transfers those values 
        // into the copy to fill of the gap of the Object we want to remove
        for (int i = index; i < this.size - 1; i++) {
            // i + 1 because we want to shift the elements 1 spot to the left
            copyList[i] = this.arrayList[i + 1];
        }

        this.arrayList = copyList;
        this.size--; // decrease size by 1 because we removed an Object

        return removed; // return the stored Object 
    }

    /**
     * size method - this method returns the number of Objects in the stack
     */
    public int size() {
        return this.size;
    }

    /**
     * isEmpty method - this method returns true if there are elements in the 
     * array and false if there aren't any. 
     */
    public boolean isEmpty() {
        // list isn't empty if there are elements in the array
        if (this.size > 0) {
            return false;
        }

        return true;
    }

    @Override
    /**
     * toString method - this method returns a string representing the Objects
     * currently held in the array list. The left represents the left of the list
     * while the right represents the right. 
     */
    public String toString() {
        String retVal = ""; 

        for (int i = 0; i < this.size; i ++){ 
            if (arrayList[i] != null) {
                retVal += this.arrayList[i] + "\n";
            }
        }

        return retVal;
    }

    /**
     * indexOf method - this method takes in an Object as a parameter and searches
     * through the array to see if there it is currently holding an Object equal 
     * to it. If it is equal, it returns the index of where the Object is held. If 
     * not, it returns -1.
     */
    public int indexOf(Object item) {
        int index = -1; // index will remain -1 if Object isn't in the list

        // for-loop that goes through the list and checks if the Object passed
        // through is being stored or not
        for (int i = 0; i < this.arrayList.length; i++) {
            // if it is being stored go in here
            if (this.arrayList[i].equals(item)) {
                index = i; // set index equal to the position in the list
            }
        }

        return index; // returns -1 or index 
    }

    @Override
    /**
     * equals method - this method tests the Object passed in for equality. If 
     * the Object is an ArrayList and the elements are equal to the isntance of the 
     * class we are in, the method returns true.
     */
    public boolean equals(Object obj) {
        // if obj is an ArrayList go in here
        if (obj instanceof ArrayList) {
            ArrayList other = (ArrayList)obj;

            // if the sizes of both lists are equal
            if (this.size == other.size) {               
                for (int i = 0; i < this.size; i++) {
                    if (!this.arrayList[i].equals(other.arrayList[i])) {
                        return false; // if the elements are different
                    }
                }

                return true; // if we reach this then everythings the same
            }
        }

        return false; // if we reach here than they aren't the same
    }

    /**
     * get method - this method takes in an integer and returns the Object stored 
     * at that index in the array if the index is available to choose from.
     */
    public Object get(int index) {
        // returns null if index is an invalid index
        if (index < 0 || index > this.arrayList.length) {
            return null;
        }

        return this.arrayList[index]; // returns object at given index
    }    

    @Override
    @SuppressWarnings("unchecked")
    /**
     * Iterator method - Returns an iterator over a set of elements of type T.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;

            @Override
            /**
             * hasNext() method - this method returns true if the iteration
             * has more elements and false if not.
             */
            public boolean hasNext() {
                if (count < size) {
                    return true;
                }
                return false;
            }

            @Override
            /**
             * next method - this method returns the next element in the 
             * iteration. Throws a NoSuchElementException if there aren't any
             * more elements.
             */
            public T next() {
                if (count > size) {
                    throw new NoSuchElementException();
                }
                // return the element and increase count by 1 
                return (T) arrayList[count++];
            }
        }; 
    }  
}
