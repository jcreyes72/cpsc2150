package cpsc2150.extendedConnectX;

public class BoardPosition {

    // Row position
    private int boardRow;
    // Column Position
    private int boardCol;

    // Constructor
    BoardPosition(int row, int column){
        boardRow = row;
        boardCol = column;
    }


    public int getRow(){
        return boardRow;
    }

    public int getColumn(){
        return boardCol;
    }

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

    // Overriding toString() to display BoardPosition row and column
    @Override
    public String toString() {
        return String.format(this.getRow() + ", " + this.getColumn());
    }


}
