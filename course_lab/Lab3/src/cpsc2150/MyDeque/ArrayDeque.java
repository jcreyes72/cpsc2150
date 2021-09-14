package cpsc2150.MyDeque;

public class ArrayDeque implements IDeque {

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

        Character out = myQ[0];

        myQ[0] = 0;

            for(int i = 0; i < myLength - 1; i++){
                myQ[i] = myQ[i+1];
            }

        myLength--;
        return out;
    }

    /**
     * @param x Character that will be added to the front of the deque
     * @post Adds character to front of deque, length increases by 1
     */
    public void inject(Character x){
        for(int i = 0; i < myLength; i++){
            myQ[i] = myQ[i+1];
        }
        myQ[0]=x;
        myLength++;
    }

    /**
     * @return Character at the end of the deque
     * @post Removes the character at the end of the deque
     * Length decreases by 1
     */
    public Character removeLast(){
        Character out = myQ[myLength];
        myQ[myLength]=0;
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
            myQ[i] = 0;
        }
    }
}






