package cpsc2150.MyDeque;
import java.util.*;


public abstract class AbsDeque implements IDeque {

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
                    ourString = temp+", ";
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
