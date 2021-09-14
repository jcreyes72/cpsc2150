// CPSC 2151
// Group Members: Julio Reyes, Ryan Le

package cpsc2150.MyDeque;
import java.util.*;


public abstract class AbsDeque <T> implements IDeque <T> {

    /**
     * Returns a string enabling us to print out our deque in main
     * @return String containing our deque information to print
     * @post Will return a string containing our deque to print
     */
    public String toString() {

        // Making copy of object we can use
        IDeque ourDeque = this;

        // String we will return
        String ourString = " ";

            // Get each value from deque and copy into ourString
            for (int i = 0; i < ourDeque.length(); i++){

                String temp = String.valueOf((ourDeque.get(i)));

                // If ourString is empty
                if (ourString == " "){
                    // If we only have one value in deque
                    if (ourDeque.length() == 1){
                        ourString = temp;
                    }
                    else {
                        ourString = temp+", ";
                    }
                }
                // If ourString is not empty
                else {
                    // If this is our last element, don't add comma to string
                    if (i == ourDeque.length() - 1){
                        ourString = ourString + temp;
                    }
                    // If this is not our last element, add comma to end of string
                    else {
                        ourString = ourString + temp + ", ";
                    }
                }
            }

        return ourString;
    }

}
