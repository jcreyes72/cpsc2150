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
    //returns character from front of deque but does not remove it
    default public Character peek(){

        // Setting character to the first element in the deque
        Character out = this.dequeue();
        // Putting character back into front of deque
        this.inject(out);

        return out;
    }
    //returns the character at the end of the deque but does not remove it
    default public Character endOfDeque(){

        // Setting character to last element in deque
        Character out = this.removeLast();
        // Putting character back into deque
        this.enqueue(out);
        return out;

    }
    //inserts c at position pos in the deque
    default public void insert(Character c, int pos){

        // Temporary array we will use to store values
        Character[] tempArray = new Character[this.length()+1];

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
    //removes whatever character was in position pos in the deque and returns it
    default public Character remove(int pos){

        // Temporary array we will use to store values
        Character[] tempArray = new Character[this.length()+1];
        // Character we will use to return char at position pos
        Character specificChar;

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

    //returns whatever character was in position pos in the deque without removing it
    default public Character get(int pos){

        // New character array to copy values into
        Character[] temp = new Character[MAX_LENGTH];

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