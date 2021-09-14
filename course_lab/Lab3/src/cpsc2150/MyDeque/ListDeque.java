package cpsc2150.MyDeque;
import java.util.*;


public class ListDeque implements IDeque {
    // this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<Character> myQ;
    // complete the class
    int length = 0;

    /**
     * @post Creates an empty deque
     */
    ListDeque(){
        myQ = new ArrayList<Character>();
    }

    /**
     * @param x Character that will be added to the end of our deque
     * @post x will be added to deque, length of deque will increase by 1
     */
    public void enqueue(Character x){
        myQ.add(x);
        length++;
    }

    /**
     * @return Character at the front of the deque
     * @post Removes the character at the front of the deque
     * Length decreases by 1
     */
    public Character dequeue(){
        length--;
        return myQ.remove(0);
    }

    /**
     * @param x Character that will be added to the front of the deque
     * @post Adds character to front of deque, length increases by 1
     */
    public void inject(Character x){
        myQ.add(0, x);
        length++;
    }

    /**
     * @return Character at the end of the deque
     * @post Removes the character at the end of the deque
     * Length decreases by 1
     */
    public Character removeLast(){
        length--;
        return myQ.remove(myQ.size()-1);
    }

    /**
     * @return Length of the deque
     * @post Returns the number of characters in the deque
     */
    public int length(){
        return length;
    }

    /**
     * @post Clears the entire deque
     */
    public void clear(){
        myQ.clear();
    }
}