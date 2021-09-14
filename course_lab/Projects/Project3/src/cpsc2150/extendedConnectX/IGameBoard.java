package cpsc2150.extendedConnectX;

/**
 * This object will hold the information about our Game Board, and will handle running
 * and identifying the status of the game
 *
 * Defines: Rows: Z - The number of rows in our game board
 *          Columns: Z - The number of columns in our game board
 *          NeededToWin: Z - The number of tokens in a row a player needs to win the game
 *          GameBoard - Z - The board we will use to play the game
 *
 * Initialization Ensures: [New game board is created]
 *                         [Each game board space initialized to ' ']
 *                         [Row does not exceed MAX_ROW, column does not exceed MAX_COL]
 *
 * Constraints: MIN_ROW_COL_WIN <= Rows <= MAX_ROW
 *              MIN_ROW_COL_WIN <= Columns <= MAX_COL
 *              MIN_ROW_COL_WIN <= NeededToWin <= MAX_NUM_TO_WIN
 */

/**
 * I was questioning whether or not to put my contracts above every method in my code or
 * to just leave them in the interface. I decided to play it safe and just put the contracts
 * wherever my methods were as I didn't want to lose points for not having them in a specific
 * place. Hopefully this is ok
 */


public interface IGameBoard {

    // Some constants we will use for our code
    static final int MAX_ROW = 100;
    static final int MAX_COL = 100;
    static final int MAX_NUM_TO_WIN = 25;
    static final int MIN_ROW_COL_WIN = 3;
    static final int LAST_SINGLE_DIGIT = 9;

    /**
     * Places token p in column c on the game board. Token will be placed in lowest
     * available row
     * @param p The token that will be placed on board. Character based on user choice
     * @param c The specific column we will be placing our token in
     * @pre MIN_ROW_COL_WIN <= c < MAX_COL
     * @post Token p will be placed in lowest row of column c
     * No return value
     */
    public void placeToken(char p, int c);

    /**
     * Returns the char that is in position pos of the game board, if there is no token
     * return blank space character ' '
     * @param pos BoardPosition object containing our specific position
     * @return Char that is located at our position board position, either token or blank space
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post Returns char that is at specific board position; return either token or blank space
     */
    public char whatsAtPos(BoardPosition pos);


    /**
     * Returns the number of rows that is in our Game Board
     * @return number of rows in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_ROW
     * @post Returns the number of rows in our Game Board
     */
    public int getNumRows();

    /**
     * Returns the number of columns that is in our Game Board
     * @return number of columns in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_COL
     * @post Returns the number of columns in our Game Board
     */
    public int getNumColumns();

    /**
     * Returns the number of tokens placed in a row needed to win the game
     * @return number of tokens in a row needed to win
     * @pre MIN_ROW_COL_WIN <= return < MAX_NUM_TO_WIN
     * @post Returns the number of tokens in a row needed to win the game
     */
    public int getNumToWin();



    // DEFAULT FUNCTIONS----------------------------------------------------------------------

    /**
     * Returns true if column is able to accept another token, otherwise false
     * @param c The specific column we are checking
     * @return True if column can accept token, false if it cannot
     * @pre MIN_ROW_COL_WIN <= c < MAX_COL
     * @post Returns true or false depending on column availability
     */
    default public boolean checkIfFree(int c){

        // Creating copy of board
        IGameBoard boardCopy = this;
        // Getting board position to check if free
        BoardPosition spotCheck = new BoardPosition(getNumRows()-1, c);

        // If this position in the board is free
        if (boardCopy.whatsAtPos(spotCheck) == ' '){
            return true;
        }

        return false;
    }



    /**
     * Returns true if the last token placed resulted in a horizontal win, false otherwise
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won horizontally.
     * @return True if a horizontal win has occurred, false otherwise
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post True or false returned depending on if horizontal win has occurred
     */
    default public boolean checkHorizWin(BoardPosition pos, char p){

        // Our count to determine if p has been found
        // at 5 spots in a row
        int count = 0;

        // Creating copy of board to check positions
        IGameBoard boardCopy = this;

        // BoardPosition object we will use to travel through row
        BoardPosition spotCheck;


            // Go through entire row, seeing if we have a win
            for (int i = 0; i < getNumColumns(); i++){
                spotCheck = new BoardPosition(pos.getRow(), i);
                // If a match is found
                if (boardCopy.isPlayerAtPos(spotCheck, p)){
                    count++;
                }
                else {
                    count = 0;
                }
                // If we get our required number of tokens in a row
                if (count == getNumToWin()){
                    return true;
                }
            }

            return false;

    }


    /**
     * Returns true if the last token placed resulted in a vertical win
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won vertically.
     * @return True if a vertical win has occurred, false otherwise
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post True or false returned depending on if vertical win has occurred
     */
    default public boolean checkVertWin(BoardPosition pos, char p){

        // Our count to determine if p has been found
        // at the specified number of spots in a row
        int count = 0;

        // Creating copy of board to check positions
        IGameBoard boardCopy = this;

        // BoardPosition object we will use to travel through column
        BoardPosition spotCheck;

            // Go through entire column, seeing if we have a win
            for (int i = 0; i < getNumRows(); i++){
                spotCheck = new BoardPosition(i, pos.getColumn());
                // If a match is found
                if (boardCopy.isPlayerAtPos(spotCheck, p)){
                    count++;
                }
                else {
                    count = 0;
                }
                // If we get our required number of tokens in a row
                if (count == getNumToWin()){
                    return true;
                }
            }

            return false;

    }



    /**
     * Returns true if the last token placed resulted in a diagonal win
     * @param pos BoardPosition object containing our specific position
     * @param p Token we are checking to see has won diagonally.
     * @return True if a diagonal win has occurred, false otherwise
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post True or false returned depending on if diagonal win has occurred
     */
    default public boolean checkDiagWin(BoardPosition pos, char p){

        // Represent where we are when checking diagonals in relation
        // to original position
        int rowMarker = pos.getRow();
        int colMarker = pos.getColumn();

        // Creating copy of board to check positions
        IGameBoard boardCopy = this;
        // BoardPosition object we will use to travel through row
        BoardPosition spotCheck;

        // Count to see if we reach 5 in a row
        int count = 0;
        // Amount of spaces we are moving diagonally
        int i = 0;


        // BOTTOM LEFT TO TOP RIGHT CHECK

        // Up and to the right check
        while ((rowMarker + i < getNumRows()) && (colMarker + i < getNumColumns())){
            spotCheck = new BoardPosition(rowMarker + i, colMarker + i);
            if (boardCopy.isPlayerAtPos(spotCheck, p)){
                count++;
                i++;
            }
            else{
                // We set i to 1 instead of 0 here because we have already checked BoardPosition(0, 0) and don't
                // want to a second time
                i = 1;
                break;
            }
        }

        if (count == getNumToWin()){
            return true;
        }

        // Down and to the left check
        while ((rowMarker - i >= 0) && (colMarker - i >= 0)){
            spotCheck = new BoardPosition(rowMarker - i, colMarker - i);
            if (boardCopy.isPlayerAtPos(spotCheck, p)){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == getNumToWin()){
            return true;
        }


        // Reset our count and i before checking other diagonal
        count = 0;
        i = 0;


        // TOP LEFT TO BOTTOM RIGHT CHECK

        // Up and to the left
        while ((rowMarker + i < getNumRows()) && (colMarker - i >= 0)){
            spotCheck = new BoardPosition(rowMarker + i, colMarker - i);
            if (boardCopy.isPlayerAtPos(spotCheck, p)){
                count++;
                i++;
            }
            else{
                // We set i to 1 instead of 0 here because we have already checked BoardPosition(0, 0) and don't
                // want to a second time
                i = 1;
                break;
            }
        }

        if (count == getNumToWin()){
            return true;
        }

        // Down and to the right
        while ((rowMarker - i >= 0) && (colMarker + i < getNumColumns())){
            spotCheck = new BoardPosition(rowMarker - i, colMarker + i);
            if (boardCopy.isPlayerAtPos(spotCheck, p)){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == getNumToWin()){
            return true;
        }

        // No diagonal win
        return false;
    }


    /**
     * Returns true if the last token placed resulted in the player winning the game
     * @param c The specific column we are checking
     * @return True if the token placed in column c resulted in a win, false otherwise
     * @pre MIN_ROW_COL_WIN <= c < MAX_COL
     * @post True or false returned depending on if last token resulted in a win
     */
    default public boolean checkForWin(int c){

        // Variable to locate what row we are in
        int i;

        // Creating copy of board
        IGameBoard boardCopy = this;
        // Creating BoardPosition object so we can locate
        // exact coordinates
        BoardPosition spotCheck;

        // Finding our row
        for (i = 0; i < getNumRows(); i++){
            spotCheck = new BoardPosition(i, c);
            if (boardCopy.whatsAtPos(spotCheck) == ' '){
                break;
            }
        }

        // Updating spotCheck with our coordinates
        // If we are NOT at the first row, go one below, otherwise update spotCheck wherever we are at
        if (i > 0) {
            spotCheck = new BoardPosition(i - 1, c);
        }
        else {
            spotCheck = new BoardPosition(i, c);
        }

        // Getting the character for our BoardPosition
        char p = whatsAtPos(spotCheck);

        // Checking if we have a win at this position
        if (checkVertWin(spotCheck, p)){
            return true;
        }
        if (checkHorizWin(spotCheck, p)){
            return true;
        }
        if (checkDiagWin(spotCheck, p)){
            return true;
        }

        // If there is no win...
        return false;
    }


    /**
     * Returns true if the player is at the specified position
     * @param pos BoardPosition object specifying exactly where we are checking on the board
     * @param player Char that represents the player we are looking for at this position.
     * @return True or false depending on if player is at board position
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL;
     * @post Returns true if player is at BoardPosition, false otherwise
     */
    default public boolean isPlayerAtPos(BoardPosition pos, char player){

        // Creating copy of our board
        IGameBoard boardCopy = this;
        // Creating BoardPosition for coordinates
        BoardPosition spotCheck = new BoardPosition(pos.getRow(), pos.getColumn());

        if (boardCopy.whatsAtPos(spotCheck) == player){
            return true;
        }

        return false;
    }


    /**
     * Returns true if the game board results in a tie game, otherwise it
     * returns false.
     * @return True or false depending upon whether or not the board is full
     * @pre NONE
     * @post Returns true if there is a tie game, false otherwise
     */
    default public boolean checkTie(){

        // Loop through checkIfFree() for each column
        // if we get true there is no tie
        for (int i = 0; i < getNumColumns(); i++){
            if (checkIfFree(i)){
                return false;
            }
        }

        return true;
    }



}
