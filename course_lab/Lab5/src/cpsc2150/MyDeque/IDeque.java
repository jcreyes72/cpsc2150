// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 *
 * Initialization ensures: Deque contains nothing, maximum length of 100
 *
 * Constraints: Length of deque <= MAX_LENGTH
 */
public interface IDeque <T>{
    public static final int MAX_LENGTH = 100;

    /**
     * Adds x to the end of the deque
     * @pre myLength < MAX_LENGTH
     * @param x Value that will be added to the end of our deque
     * @post x will be added to deque
     * myLength = myLength + 1
     */
    public void enqueue(T x);


    /**
     * Removes and returns the value at the front of the deque
     * @pre myLength > 0
     * @return Value at the front of the deque
     * @post Removes the value at the front of the deque
     * myLength = myLength - 1
     */
    public T dequeue();


    /**
     * Adds x to the front of the deque
     * @param x Value that will be added to the front of the deque
     * @post Adds value to front of deque
     * myLength = myLength + 1
     */
    public void inject(T x);



    /**
     * Removes and returns the value at the end of the deque
     * @return Value at the end of the deque
     * @pre myLength > 0
     * @post Removes the value at the end of the deque
     * myLength = myLength - 1
     */
    public T removeLast();



    /**
     * Returns the number of values in the deque
     * @return myLength (length of the deque)
     * @post Returns the number of values in the deque
     */
    public int length();



    /**
     * Clears the entire deque
     * @post Deque will be emptied
     * myLength = 0
     */
    public void clear();


    /**
     * Returns the value from front of deque but does not remove it
     * @return Value at the front of the deque
     * @pre myLength > 0
     * @post Value at the front of the deque is returned without removing from deque
     */
    default public T peek(){

        // Setting character to the first element in the deque
        T out = this.dequeue();
        // Putting character back into front of deque
        this.inject(out);

        return out;
    }


    /**
     * Returns the value at the end of the deque but does not remove it
     * @return Value at the end of the deque
     * @pre myLength > 0
     * @post Value at the end of the deque is returned without removing from deque
     */
    default public T endOfDeque(){

        // Setting character to last element in deque
        T out = this.removeLast();
        // Putting character back into deque
        this.enqueue(out);
        return out;

    }


    /**
     * Inserts c at position pos in the deque
     * @param c Value that we will be inserting into deque
     * @param pos Position in deque where our value, c, will be placed
     * @pre pos <= myLength + 1 (so that you can't place at position 15 if deque only has 4 values)
     * @post c will be inserted into deque at position pos
     * myLength = myLength + 1
     */
    //inserts c at position pos in the deque
    default public void insert(T c, int pos){

        // Temporary array we will use to store values
        T[] tempArray = (T[]) new Object[this.length()+1];

        // Getting a copy of our length to use in for loops
        int length = this.length();

            // Looping through to copy array values
            for (int i = 0; i < length; i++){
                tempArray[i] = this.dequeue();
            }

            // Making room at our position to insert value
            for (int i = length; i >= pos; i--){
                tempArray[i] = tempArray[i - 1];
                tempArray[i - 1] = null;
            }

        // Putting our character in this position of array
        tempArray[pos - 1] = c;

            // Copying array values back into our deque
            for (int i = 0; i < tempArray.length; i++){
                this.enqueue(tempArray[i]);
            }

    }


    /**
     * Removes whatever value was in position pos in the deque and returns it
     * @param pos Position in deque that we will be removing value from
     * @return T Value that we have removed from the deque
     * @pre pos <= myLength
     * myLength > 0
     * @post Value at position pos in the deque is removed and returned
     */
    default public T remove(int pos){

        // Temporary array we will use to store values
        T[] tempArray = (T[]) new Object[this.length()+1];
        // Character we will use to return char at position pos
        T specificChar;

        //Getting a copy of our length to use for for loops
        int length = this.length();

        // Looping through to copy array values
        for (int i = 0; i < length; i++){
            tempArray[i] = this.dequeue();
        }

        // Getting the value of our character
        specificChar = tempArray[pos-1];

        // Adding our values back into our deque, except for pos

        // Different for loop specifications based on what position
        // is put in by user
        if (pos == length) {
            for (int i = 0; i < tempArray.length - 2; i++) {
                if (i == pos - 1) {
                    i++;
                }
                this.enqueue(tempArray[i]);
            }
        }
        else {
            for (int i = 0; i < tempArray.length - 1; i++) {
                if (i == pos - 1) {
                    i++;
                }
                this.enqueue(tempArray[i]);
            }
        }

        return specificChar;
    }


    /**
     * Returns whatever value was in position pos in the deque without removing it
     * @param pos Position in the deque whose value will be returned
     * @return T value at position pos in the deque
     * @pre pos <= myLength
     * myLength > 0
     * @post Value at position pos in the deque is returned but not removed
     */
    default public T get(int pos){

        // New character array to copy values into
        T[] temp = (T[]) new Object[MAX_LENGTH];

        // Getting a copy of our deque length
        int length = this.length();

            // Copying deque values into our character array
            for (int i = 0; i < length; i++){
                temp[i] = this.dequeue();
            }

            // Putting values back into our deque
            for (int i = 0; i < length; i++){
                this.enqueue(temp[i]);
            }

        return temp[pos];

    }
}