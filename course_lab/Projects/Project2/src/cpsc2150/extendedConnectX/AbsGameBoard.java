package cpsc2150.extendedConnectX;
import java.util.*;

public abstract class AbsGameBoard implements IGameBoard {

    /**
     * Overriding toString() to display our game board
     * @return String that will represent our board
     * @pre NONE
     * @post Returns string that will display the game board to the user
     */
    @Override
    public String toString() {

        // Temporary gameBoard we will use to print
        IGameBoard printBoard = this;

        // String we will store our info in and return
        String ourString = "| ";

            // Filling our string with the correct number of columns to start (single digits)
            for (int i = 0; i < this.getNumColumns(); i++){
                // Accounting for single digit vs double digit rows
                if (i < LAST_SINGLE_DIGIT){
                    ourString = ourString + String.valueOf(i) + "| ";
                }
                else {
                    ourString = ourString + String.valueOf(i) + "|";
                }
            }

        ourString = ourString + "\n";

        // BoardPosition object we will use to access
        // specific coordinates
        BoardPosition spotCheck;

            // Going through our 2D array, storing values into string
            // that we will return
            for (int i = this.getNumRows() - 1; i >= 0; i--){
                for (int j = 0; j < this.getNumColumns(); j++){
                    spotCheck = new BoardPosition(i, j);
                    String temp = String.valueOf(printBoard.whatsAtPos(spotCheck));
                    ourString = ourString + "| " + temp;
                }
                // Adding newline for each row
                ourString = ourString + "|\n";
            }

        return ourString;
    }
}
