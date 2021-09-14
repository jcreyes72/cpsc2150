// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;
import java.util.*;


public class ListDeque <T> extends AbsDeque <T> implements IDeque <T> {

    /**
     * Invariant: myQ <= MAX_LENGTH
     *            0 <= myLength <= MAX_LENGTH
     *
     * Correspondence: Length_of_deque = myLength
     */

    // Deque
    private List<T> myQ;

    // Keep track of the length of our deque
    private int myLength;


    /**
     * Constructor
     * @post Creates an empty deque with a max length of 100
     * myLength = 0
     */
    public ListDeque(){
        myQ = new ArrayList<T>(MAX_LENGTH);
        myLength = 0;
    }


    public void enqueue(T x){
        myQ.add(x);
        myLength++;
    }


    public T dequeue(){
        myLength--;
        return myQ.remove(0);
    }


    public void inject(T x){
        myQ.add(0, x);
        myLength++;
    }


    public T removeLast(){
        myLength--;
        return myQ.remove(myQ.size()-1);
    }


    public int length(){
        return myLength;
    }


    public void clear(){
        myQ.clear();
        myLength = 0;
    }
}