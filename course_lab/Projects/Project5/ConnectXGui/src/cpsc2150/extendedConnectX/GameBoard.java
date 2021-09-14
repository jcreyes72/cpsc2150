package cpsc2150.extendedConnectX;

// Julio Reyes
// CPSC 2150
// 003
// 2/07/2021

public class GameBoard extends AbsGameBoard implements IGameBoard {

    /**
     * @invariant ourBoard[numRow][numCol]
     *            ourBoard[][] elements == ' ' at initialization
     * Correspondence: GameBoard = ourBoard[][]
     *                 Rows = numRow
     *                 Columns = numCol
     *                 Number needed to win = numToWin
     * These correspondences seem a little redundant but I wanted to
     * add something and couldn't think of anything else since I only
     * have one private variable
     */

    // Our 2D array for the board
    private char ourBoard[][];
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
     * @post New 2D array w/ set row and column size
     */
    GameBoard(int row, int col, int win){

        // Creating our board using our user specified values
        numRow = row;
        numCol = col;
        numToWin = win;
        ourBoard = new char[numRow][numCol];

        // Initializing our array with spaces so we can
        // print out our board
        for (int i = 0; i < numRow; i++){
            for (int j = 0; j < numCol; j++){
                ourBoard[i][j] = ' ';
            }
        }

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
    public void placeToken(char p, int c){

        // Going through our column to find the lowest position
        // we can place our token p
        for (int i = 0; i < numRow; i++){
            if (ourBoard[i][c] == ' ') {
                ourBoard[i][c] = p;
                break;
            }
        }

    }

    /**
     * Returns the char that is in position pos of the game board, if there is no token
     * return blank space character ' '
     * @param pos BoardPosition object containing our specific position
     * @return Char that is located at our position board position, either token or blank space
     * @pre MIN_ROW_COL_WIN <= pos.getRow() < MAX_ROW; MIN_ROW_COL_WIN <= pos.getColumn < MAX_COL
     * @post Returns char that is at specific board position; return either token or blank space
     */
    public char whatsAtPos(BoardPosition pos){

        return ourBoard[pos.getRow()][pos.getColumn()];

    }

    /**
     * Returns the number of rows that is in our Game Board
     * @return number of rows in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_ROW
     * @post Returns the number of rows in our Game Board
     */
    public int getNumRows (){ return numRow; }

    /**
     * Returns the number of columns that is in our Game Board
     * @return number of columns in game board
     * @pre MIN_ROW_COL_WIN <= return < MAX_COL
     * @post Returns the number of columns in our Game Board
     */
    public int getNumColumns (){ return numCol; }

    /**
     * Returns the number of tokens placed in a row needed to win the game
     * @return number of tokens in a row needed to win
     * @pre MIN_ROW_COL_WIN <= return < MAX_NUM_TO_WIN
     * @post Returns the number of tokens in a row needed to win the game
     */
    public int getNumToWin (){ return numToWin; }


}
