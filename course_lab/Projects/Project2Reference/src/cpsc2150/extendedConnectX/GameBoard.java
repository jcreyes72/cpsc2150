package cpsc2150.extendedConnectX;

// Julio Reyes
// CPSC 2150
// 003
// 2/07/2021

public class GameBoard {

    /**
     * @invariant ourBoard[numRows][numColumns]
     */

    // Our number of rows
    private int numRows = 6;
    // Our number of columns
    private int numColumns = 9;
    // Our 2D array for the board
    private char ourBoard[][];


    /**
     * This constructor creates a new game board with our set row and
     * column lengths
     * @pre NONE
     * @post New 2D array w/ set row and column size
     */
    GameBoard(){


    }


    /**
     * Returns true if column is able to accept another token, otherwise false
     * @param c The specific column we are checking
     * @return True if column can accept token, false if it cannot
     * @pre 0 <= c <= 8
     * @post Returns true or false depending on column availability
     */
    public boolean checkIfFree(int c){


    }


    /**
     * Places token p in column c on the game board. Token will be placed in lowest
     * available row
     * @param p The token that will be placed on board. Either 'X' or 'O'
     * @param c The specific column we will be placing our token in
     * @pre p == 'X' || 'O'; 0 <= c <= 8
     * @post Token p will be placed in lowest row of column c
     * No return value
     */
    public void placeToken(char p, int c){



    }


    /**
     * Returns true if the last token placed resulted in a horizontal win, false otherwise
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won horizontally. Either 'X' or 'O'
     * @return True if a horizontal win has occurred, false otherwise
     * @pre p == 'X' || 'O'; 0 <= pos.getRow() <= 5; 0 <= pos.getColumn <= 8
     * @post True or false returned depending on if horizontal win has occurred
     */
    public boolean checkHorizWin(BoardPosition pos, char p){


    }


    /**
     * Returns true if the last token placed resulted in a vertical win
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won vertically. Either 'X' or 'O'
     * @return True if a vertical win has occurred, false otherwise
     * @pre p == 'X' || 'O'; 0 <= pos.getRow() <= 5; 0 <= pos.getColumn <= 8
     * @post True or false returned depending on if vertical win has occurred
     */
    public boolean checkVertWin(BoardPosition pos, char p){



    }


    /**
     * Returns true if the last token placed resulted in a diagonal win
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won diagonally. Either 'X' or 'O'
     * @return True if a diagonal win has occurred, false otherwise
     * @pre p == 'X' || 'O'; 0 <= pos.getRow() <= 5; 0 <= pos.getColumn <= 8
     * @post True or false returned depending on if diagonal win has occurred
     */
    public boolean checkDiagWin(BoardPosition pos, char p){


    }


    /**
     * Returns true if the last token placed resulted in the player winning the game
     * @param c The specific column we are checking
     * @return True if the token placed in column c resulted in a win, false otherwise
     * @pre 0 <= c <= 8
     * @post True or false returned depending on if last token resulted in a win
     */
    // returns true if the last token placed (which was placed
    // in column c) resulted in the player winning the game.
    public boolean checkForWin(int c){


    }


    /**
     * Returns the char that is in position pos of the game board, if there is no token
     * return blank space character ' '
     * @param pos BoardPosition object containing our specific position
     * @return Char that is located at our position board position, either 'X', 'O', or ' '
     * @pre 0 <= pos.getRow() <= 5; 0 <= pos.getColumn <= 8
     * @post Returns char that is at specific board position; return == 'X' || 'O' || ' '
     */
    public char whatsAtPos(BoardPosition pos){


    }


    /**
     * Returns true if the player is at the specified position
     * @param pos BoardPosition object specifying exactly where we are checking on the board
     * @param player Char that represents the player we are looking for at this position. Either 'X' or 'O'
     * @return True or false depending on if player is at board position
     * @pre 0 <= pos.getRow() <= 5; 0 <= pos.getColumn <= 8; player == 'X' || 'O'
     * @post Returns true if player is at BoardPosition, false otherwise
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player){

    }


    /**
     * Returns true if the game board results in a tie game, otherwise it
     * returns false.
     * @return True or false depending upon whether or not the board is full
     * @pre NONE
     * @post Returns true if there is a tie game, false otherwise
     */
    public boolean checkTie(){


    }


    /**
     * Overriding toString() to display our game board
     * @return String that will represent our board
     * @pre NONE
     * @post Returns string that will display the game board to the user
     */
    @Override
    public String toString() {

    }


}
