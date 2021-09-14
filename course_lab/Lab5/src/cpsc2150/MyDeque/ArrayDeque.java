// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;

public class ArrayDeque<T> extends AbsDeque <T> implements IDeque <T>  {

    /**
     * Invariant: myQ <= MAX_LENGTH
     *            0 <= myLength <= MAX_LENGTH
     *
     * Correspondence: Length_of_deque = myLength
     */


    // where the data is stored. myQ[0] is the front of the deque
    private T[] myQ;

    // tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    /**
     * Constructor
     * @post Creates an empty deque with a max length of 100
     * myLength is set to equal 0
     */
    public ArrayDeque(){
        myQ = (T[]) new Object[MAX_LENGTH];
        myLength = 0;
    }


    public void enqueue(T x){
        myQ[myLength] = x;
        myLength++;
    }


    public T dequeue(){

        // Setting character equal to front of deque for return
        T out = myQ[0];

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


    public void inject(T x){

        // Updating our current deque so we can
        // place character at front position
        for (int i = myLength; i > 0; i--){
            myQ[i] = myQ[i-1];
        }

        myQ[0] = x;
        myLength++;
    }


    public T removeLast(){
        T out = myQ[myLength - 1];
        myQ[myLength - 1] = null;
        myLength--;
        return out;
    }


    public int length() {
        return myLength;
    }


    public void clear(){
        for(int i = 0; i < myLength; i++){
            myQ[i] = null;
        }
        myLength = 0;
    }

}






