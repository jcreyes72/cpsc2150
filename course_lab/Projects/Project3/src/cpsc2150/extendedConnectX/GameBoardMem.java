package cpsc2150.extendedConnectX;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoardMem extends AbsGameBoard implements IGameBoard{


    /**
     * @invariant ourBoard<Character, List<BoardPosition>>
     * Correspondence: GameBoard = ourBoard<Character, List<BoardPosition>>
     *                 Rows = numRow
     *                 Columns = numCol
     *                 Number needed to win = numToWin
     */


    // Our map that will act as our Gameboard
    Map<Character, List<BoardPosition>> ourBoard = new HashMap<>();
    // Our user specified number of rows in our board
    private int numRow;
    // Our user specified number of columns in our board
    private int numCol;
    // Our user specified number of tokens to win in our board
    private int numToWin;


    /**
     * This constructor creates a new game board with our user specified rows,
     * columns, and number of tokens required to win
     * @param row Our number of rows in our gameboard
     * @param col Our number of columns in our gameboard
     * @param win Our number of tokens needed in a row to win
     * @pre MIN_ROW_COL_WIN <= row <= MAX_ROW; MIN_ROW_COL_WIN <= col <= MAX_COL
     * @pre MIN_ROW_COL_WIN <= win <= MAX_NUM_TOWIN
     * @post New Hashmap with specified columns, rows, and tokens required to win
     */
    GameBoardMem(int row, int col, int win){

        // Creating our board using our user specified values
        numRow = row;
        numCol = col;
        numToWin = win;

    }

    /**
     * Places token p in column c on the game board. Token will be placed in lowest
     * available row
     * @param p The token that will be placed on board. Character based on user choice
     * @param c The specific column we will be placing our token in
     * @pre MIN_ROW_COL_WIN <= c < MAX_COL
     * @post Token p will be placed in lowest row of column c
     * No return value
     */
    @Override
    public void placeToken(char p, int c) {

        // Value we will use to determine which row to place token
        int ourRow = 0;
        // Creating a BoardPosition object which will hold values
        BoardPosition newSpace = new BoardPosition(ourRow, c);

            // If we are dealing with a space that is blank
            if (!isPlayerAtPos(newSpace, p)){
                if (whatsAtPos(newSpace) == ' '){
                    List<BoardPosition> tokenAdd = new ArrayList<>(0);
                        // Making our tokenAdd list equal to the list in the map, if this key already exists
                        if (ourBoard.containsKey(p)){
                            tokenAdd = ourBoard.get(p);
                        }
                        // Adding our newSpace to our tokenAdd list
                        tokenAdd.add(newSpace);
                        // Adding our tokenAdd list to our map
                        ourBoard.put(p, tokenAdd);
                        return;
                }
            }

            // Otherwise we look through to find next available space
            // ourRow is 1 since we have already checked the 0th row
            for (ourRow = 1; ourRow < getNumRows(); ourRow++){
                // Create newSpace using new coordinates
                newSpace = new BoardPosition(ourRow, c);
                    if (whatsAtPos(newSpace) == ' '){
                        // Exit loop once we have located blank space
                        break;
                    }

            }

        List<BoardPosition> tokenAdd = new ArrayList<>();


            if (ourBoard.containsKey(p)){
                // Making our tokenAdd list equal to the list in the map, if this key already exists
                tokenAdd = ourBoard.get(p);
            }

        tokenAdd.add(newSpace);
        ourBoard.put(p, tokenAdd);

    }

    /**
     * Returns the char that is in position pos of the game board, if there is no token
     * return blank space character ' '
     * @param pos BoardPosition object containing our specific position
     * @return Char that is located at our position board position, either token or blank space
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post Returns char that is at specific board position; return either token or blank space
     */
    @Override
    public char whatsAtPos(BoardPosition pos) {

        // Creating Character we will use to store value
        Character charReturn = ' ';

            // Iterating over our map keys to find a match
            for (Map.Entry<Character, List<BoardPosition>> tempMap : ourBoard.entrySet()){
                if (isPlayerAtPos(pos, tempMap.getKey())){
                    charReturn = tempMap.getKey();
                    break;
                }
            }

        return charReturn;
    }

    /**
     * Returns true if the player is at the specified position
     * @param pos BoardPosition object specifying exactly where we are checking on the board
     * @param player Char that represents the player we are looking for at this position.
     * @return True or false depending on if player is at board position
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL;
     * @post Returns true if player is at BoardPosition, false otherwise
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char player) {

        // If the player isn't in our map return false
        if (!ourBoard.containsKey(player)){
            return false;
        }

        // Going through our map to see if it contains pos
        for (BoardPosition tempPosition : ourBoard.get(player)){
            if (tempPosition.equals(pos)){
                return true;
            }
        }

        return false;
    }


    /**
     * Returns the number of rows that is in our Game Board
     * @return number of rows in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_ROW
     * @post Returns the number of rows in our Game Board
     */
    @Override
    public int getNumRows() {
        return numRow;
    }

    /**
     * Returns the number of columns that is in our Game Board
     * @return number of columns in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_COL
     * @post Returns the number of columns in our Game Board
     */
    @Override
    public int getNumColumns() {
        return numCol;
    }

    /**
     * Returns the number of tokens placed in a row needed to win the game
     * @return number of tokens in a row needed to win
     * @pre MIN_ROW_COL_WIN <= return < MAX_NUM_TO_WIN
     * @post Returns the number of tokens in a row needed to win the game
     */
    @Override
    public int getNumToWin() {
        return numToWin;
    }
}
