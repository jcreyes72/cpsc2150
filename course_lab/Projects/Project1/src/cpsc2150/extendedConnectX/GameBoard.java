package cpsc2150.extendedConnectX;

public class GameBoard {

    // Our number of rows
    private int numRows = 6;
    // Our number of columns
    private int numColumns = 9;
    // Our 2D array for the board
    private char ourBoard[][];


    // Constructor creates new game board with our set
    // row and column lengths
    GameBoard(){
        ourBoard = new char[numRows][numColumns];

            // Initializing our array with spaces so we can
            // print out our board
            for (int i = 0; i < numRows; i++){
                for (int j = 0; j < numColumns; j++){
                    ourBoard[i][j] = ' ';
                }
            }

    }


    // Returns true if column is able to accept another token, false otherwise.
    public boolean checkIfFree(int c){
        // If this position in the board is free
        if (ourBoard[5][c] == ' '){
            return true;
        }
        return false;
    }

    // Places a token p in column c on the game board. The token
    // will be placed in the lowest available row in column c.
    public void placeToken(char p, int c){

        // Going through our column to find the lowest position
        // we can place our token p
        for (int i = 0; i < numRows; i++){
            if (ourBoard[i][c] == ' ') {
                ourBoard[i][c] = p;
                break;
            }
        }

    }


    // Returns true if the last token placed resulted in the player
    // winning by getting 5 in a row horizontally. Otherwise, it returns false.
    public boolean checkHorizWin(BoardPosition pos, char p){

        // Our count to determine if p has been found
        // at 5 spots in a row
        int count = 0;

        // Go through entire row, seeing if we have a win
        for (int i = 0; i < numColumns; i++){
            // If a match is found
            if (ourBoard[pos.getRow()][i] == p){
                count++;
            }
            else {
                count = 0;
            }
            // If we get 5 in a row
            if (count == 5){
                return true;
            }
        }

        return false;
    }




    // Returns true if the last token placed resulted in the player
    // getting 5 in a row vertically. Otherwise, it returns false.
    public boolean checkVertWin(BoardPosition pos, char p){

        // Our count to determine if p has been found
        // at 5 spots in a row
        int count = 0;

        // Go through entire row, seeing if we have a win
        for (int i = 0; i < numRows; i++){
            // If a match is found
            if (ourBoard[i][pos.getColumn()] == p){
                count++;
            }
            else {
                count = 0;
            }
            // If we get 5 in a row
            if (count == 5){
                return true;
            }
        }

        return false;

    }




    // Returns true if the last token placed resulted in the player
    // getting 5 in a row diagonally. Otherwise, it returns false.
    public boolean checkDiagWin(BoardPosition pos, char p){

        // Represent where we are when checking diagonals in relation
        // to original position
        int rowMarker = pos.getRow();
        int colMarker = pos. getColumn();

        // Count to see if we reach 5 in a row
        int count = 0;
        // Amount of spaces we are moving diagonally
        int i = 0;


        // BOTTOM LEFT TO TOP RIGHT CHECK

        // Up and to the right
        while ((rowMarker + i < numRows) && (colMarker + i < numColumns)){
            if (ourBoard[rowMarker + i][colMarker + i] == p){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == 5){
            return true;
        }

        // Down and to the left
        while ((rowMarker - i >= 0) && (colMarker - i >= 0)){
            if (ourBoard[rowMarker - i][colMarker - i] == p){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == 5){
            return true;
        }


        // Reset our count before checking other diagonal
        count = 0;


        // TOP LEFT TO BOTTOM RIGHT CHECK

        // Up and to the left
        while ((rowMarker + i < numRows) && (colMarker - i >= 0)){
            if (ourBoard[rowMarker + i][colMarker - i] == p){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == 5){
            return true;
        }

        // Down and to the right
        while ((rowMarker - i >= 0) && (colMarker + i < numColumns)){
            if (ourBoard[rowMarker - i][colMarker + i] == p){
                count++;
                i++;
            }
            else{
                i = 0;
                break;
            }
        }

        if (count == 5){
            return true;
        }

        // No diagonal win
        return false;
    }


    // returns true if the last token placed (which was placed
    // in column c) resulted in the player winning the game.
    public boolean checkForWin(int c){

        // Variable to locate what row we are in
        int i;

        // Finding our row
        for (i = 0; i < numRows; i++){
            if (ourBoard[i][c] == ' '){
                break;
            }
        }

        // Creating a BoardPosition object with our coordinates
        // so we can use our functions
        BoardPosition spotCheck = new BoardPosition(i-1, c);

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


    // Returns the char that is in position pos of the game board. If there is
    // no token at the spot it should return a blank space character: ‘ ’.
    public char whatsAtPos(BoardPosition pos){

        if (ourBoard[pos.getRow()][pos.getColumn()] == 'X'){
            return 'X';
        }
        if (ourBoard[pos.getRow()][pos.getColumn()] == 'O'){
            return 'O';
        }

        return ' ';
    }


    // Returns true if the player is at that position.
    public boolean isPlayerAtPos(BoardPosition pos, char player){

        if (ourBoard[pos.getRow()][pos.getColumn()] == player){
            return true;
        }

        return false;
    }


    // Overriding toString() to display BoardPosition row and column
    @Override
    public String toString() {
        return "|0|1|2|3|4|5|6|7|8|\n" +
                "|" + ourBoard[5][0] + "|" + ourBoard[5][1] + "|" + ourBoard[5][2] +
                "|" + ourBoard[5][3] + "|" + ourBoard[5][4] + "|" + ourBoard[5][5] +
                "|" + ourBoard[5][6] + "|" + ourBoard[5][7] + "|" + ourBoard[5][8] +
                "|\n|" + ourBoard[4][0] + "|" + ourBoard[4][1] + "|" + ourBoard[4][2] +
                "|" + ourBoard[4][3] + "|" + ourBoard[4][4] + "|" + ourBoard[4][5] +
                "|" + ourBoard[4][6] + "|" + ourBoard[4][7] + "|" + ourBoard[4][8] +
                "|\n|" + ourBoard[3][0] + "|" + ourBoard[3][1] + "|" + ourBoard[3][2] +
                "|" + ourBoard[3][3] + "|" + ourBoard[3][4] + "|" + ourBoard[3][5] +
                "|" + ourBoard[3][6] + "|" + ourBoard[3][7] + "|" + ourBoard[3][8] +
                "|\n|" + ourBoard[2][0] + "|" + ourBoard[2][1] + "|" + ourBoard[2][2] +
                "|" + ourBoard[2][3] + "|" + ourBoard[2][4] + "|" + ourBoard[2][5] +
                "|" + ourBoard[2][6] + "|" + ourBoard[2][7] + "|" + ourBoard[2][8] +
                "|\n|" + ourBoard[1][0] + "|" + ourBoard[1][1] + "|" + ourBoard[1][2] +
                "|" + ourBoard[1][3] + "|" + ourBoard[1][4] + "|" + ourBoard[1][5] +
                "|" + ourBoard[1][6] + "|" + ourBoard[1][7] + "|" + ourBoard[1][8] +
                "|\n|" + ourBoard[0][0] + "|" + ourBoard[0][1] + "|" + ourBoard[0][2] +
                "|" + ourBoard[0][3] + "|" + ourBoard[0][4] + "|" + ourBoard[0][5] +
                "|" + ourBoard[0][6] + "|" + ourBoard[0][7] + "|" + ourBoard[0][8] + "|";
    }


}
