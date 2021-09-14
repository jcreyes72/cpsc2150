package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 *
 * Define:
 *
 * Initialization ensures: Deque contains nothing, maximum length of 100
 *
 * Constraints: Length of deque <= MAX_LENGTH
 */
public interface IDeque {
    public static final int MAX_LENGTH = 100;
    // Adds x to the end of the deque
    public void enqueue(Character x);
    //removes and returns the Character at the front of the deque
    public Character dequeue();
    // Adds x to the front of the deque
    public void inject(Character x);
    //removes and returns the Character at the end of the deque
    public Character removeLast();
    //returns the number of Characters in the deque
    public int length();
    //clears the entire deque
    public void clear();
}