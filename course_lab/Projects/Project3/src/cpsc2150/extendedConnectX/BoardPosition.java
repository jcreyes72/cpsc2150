package cpsc2150.extendedConnectX;

// Julio Reyes
// CPSC 2150
// 003
// 2/07/2021

public class BoardPosition {

    /**
     * @invariant MIN_ROW_COL_WIN <= boardRow < MAX_ROW
     *            MIN_ROW_COL_WIN <= boardCol < MAX_COL
     * Correspondence: Row = boardRow
     *                 Column = boardCol
     */

    // Row position
    private int boardRow;
    // Column Position
    private int boardCol;


    /**
     * This constructor initializes a BoardPosition object containing
     * the specified row and column
     * @param row The row for our BoardPosition
     * @param column The column for our BoardPosition
     * @pre MIN_ROW_COL_WIN <= row < MAX_ROW; MIN_ROW_COL_WIN <= column < MAX_COL
     * @post New BoardPosition consisting of row and column
     */
    BoardPosition(int row, int column){
        boardRow = row;
        boardCol = column;
    }

    /**
     * Used to retrieve the private row variable from our BoardPosition
     * @return The row of our BoardPosition
     * @pre MIN_ROW_COL_WIN <= row < MAX_ROW
     * @post Returns our row for BoardPosition
     */
    public int getRow(){
        return boardRow;
    }


    /**
     * Used to retrieve the private column variable from our BoardPosition
     * @return The column of our BoardPosition
     * @pre MIN_ROW_COL_WIN <= column < MAX_COL
     * @post Returns our column for BoardPosition
     */
    public int getColumn(){
        return boardCol;
    }


    /**
     * Overrides the equals() so that we can compare two separate BoardPositions
     * @param a Right side BoardPosition object we will be comparing
     * @return True or false depending on whether or not our two BoardPositions are equal
     * @pre 0 <= a.getRow() < MAX_ROW; 0 <= a.getColumn() < MAX_COL
     * I know that I wont be able to get the row or column as shown in the precondition
     * above but will instead need to create a BoardPosition object using the "a" parameter
     * but I thought it would be important to provide this precondition anyways
     * @post Returns true if BoardPosition objects are equal, false otherwise
     */
    // Overriding equals() to compare two BoardPositions
    @Override
    public boolean equals(Object a){

        // Creating new BoardPosition with our object a
        BoardPosition b = (BoardPosition) a;

        // Seeing if the column and row are equal
        if (!(b.getColumn() == this.getColumn())){
            return false;
        }
        if (!(b.getRow() == this.getRow())){
            return false;
        }
        // If equal
        return true;
    }


    /**
     * Overrides the toString() so that was can display the row and column for our
     * specific BoardPosition
     * @return String that will represent the location of a BoardPosition object
     * @pre NONE
     * @post Returns a string that will show specific BoardPosition row and column
     */
    // Overriding toString() to display BoardPosition row and column
    @Override
    public String toString(){
        return String.format(this.getRow() + ", " + this.getColumn());
    }

}
