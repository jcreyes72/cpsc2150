package cpsc2150.MyDeque;

public class ArrayDeque extends AbsDeque implements IDeque {

    /**
     * Invariant: myQ <= MAX_LENGTH
     *
     * Correspondence: Deque = Character[] myQ
     * Correspondence: Length_of_deque = myLength
     */

    // where the data is stored. myQ[0] is the front of the deque
    private Character[] myQ;

    // tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    /**
     * @post Creates an empty deque with a max length of 100
     */
    ArrayDeque(){
        myQ = new Character[MAX_LENGTH];
        myLength = 0;
    }

    /**
     * @param x Character that will be added to the end of our deque
     * @post x will be added to deque, length of deque will increase by 1
     */
    public void enqueue(Character x){
        myQ[myLength] = x;
        myLength++;
    }

    /**
     * @return Character at the front of the deque
     * @post Removes the character at the front of the deque
     * Length decreases by 1
     */
    public Character dequeue(){

        // Setting character equal to front of deque for return
        Character out = myQ[0];

        // Clear front of deque
        myQ[0] = null;

        // Fix deque values now that front position is null
        for(int i = 0; i < myLength - 1; i++){
            myQ[i] = myQ[i+1];
            myQ[i+1] = null;
        }

        myLength--;
        return out;
    }

    /**
     * @param x Character that will be added to the front of the deque
     * @post Adds character to front of deque, length increases by 1
     */
    public void inject(Character x){

        // Updating our current deque so we can
        // place character at front position
        for (int i = myLength; i > 0; i--){
            myQ[i] = myQ[i-1];
        }

        myQ[0] = x;
        myLength++;
    }

    /**
     * @return Character at the end of the deque
     * @post Removes the character at the end of the deque
     * Length decreases by 1
     */
    public Character removeLast(){
        Character out = myQ[myLength - 1];
        myQ[myLength - 1] = 0;
        myLength--;
        return out;
    }

    /**
     * @return Length of the deque
     * @post Returns the number of characters in the deque
     */
    public int length(){
        return myLength;
    }

    /**
     * @post Clears the entire deque
     */
    public void clear(){
        for(int i = 0; i < myLength; i++){
            myQ[i] = null;
        }
        myLength = 0;
    }

}






