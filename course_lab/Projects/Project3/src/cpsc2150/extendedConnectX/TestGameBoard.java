package cpsc2150.extendedConnectX;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGameBoard {

    // Constant that will help us with our boardDisplay() function
    static final int DOUBLE_DIGIT = 10;
    // Constant that indicates largest possible row and column value
    static final int MAX_ROW_COL = 100;
    // Constant that indicates largest possible num_to_win value
    static final int MAX_NUM_WIN = 25;
    // Constant that indicates smallest possible row and column value
    static final int MIN_ROW_COL = 3;

    // This private function will simply return a new Gameboard
    private IGameBoard boardMaker(int rows, int columns, int wins) {
        return new GameBoard(rows, columns, wins);
    }

    // This function will create a board print that we will use to compare for our tests
    private String boardDisplay(char[][] boardArray, int rows, int columns) {

        String ourBoard = "";

        // Adding the columns for our board
        for (int i = 0; i < columns; i++) {
            // This accounts for the extra space needed in our board if
            // the column number is single digit
            if (i < DOUBLE_DIGIT) {
                ourBoard += "| " + i;
            } else {
                ourBoard += "|" + i;
            }
        }

        ourBoard += "|\n";

        // Completing the rest of our board
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                ourBoard += "| " + boardArray[i][j];
            }
            ourBoard += "|\n";
        }

        return ourBoard;
    }

    //--------------//
    //  TEST CASES  //
    //--------------//


    //---------------------//
    //  constructor tests  //
    //---------------------//

    // This test case is unique and distinct because we are creating a board using the largest
    // possible values for row, column, and wins
    @Test
    public void test_Constructor_Large(){

        char[][] boardArray;

        boardArray = new char[MAX_ROW_COL][MAX_ROW_COL];

            // Filling board array with open spaces
            for(int i = 0; i < MAX_ROW_COL; i++){
                for(int j = 0; j < MAX_ROW_COL; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(MAX_ROW_COL, MAX_ROW_COL, MAX_NUM_WIN);

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, MAX_ROW_COL, MAX_ROW_COL));
        assertEquals(MAX_NUM_WIN, ourBoard.getNumToWin());
    }

    // This test case is unique and distinct because we are creating a board using the largest
    // possible values for row and the smallest value for column
    @Test
    public void test_Constructor_Mix(){

        char[][] boardArray;

        boardArray = new char[MAX_ROW_COL][MIN_ROW_COL];

        /* Filling board array with open spaces */
            for(int i = 0; i < MAX_ROW_COL; i++){
                for(int j = 0; j < MIN_ROW_COL; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(MAX_ROW_COL, MIN_ROW_COL, MAX_NUM_WIN);

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, MAX_ROW_COL, MIN_ROW_COL));
        assertEquals(MAX_NUM_WIN, ourBoard.getNumToWin());
    }

    // This test case is unique and distinct because we are creating a board using the
    // smallest possible values for row, column, and wins
    @Test
    public void test_Constructor_Small(){

        char[][] boardArray;

        boardArray = new char[MIN_ROW_COL][MIN_ROW_COL];

            // Filling board array with open spaces
            for(int i = 0; i < MIN_ROW_COL; i++){
                for(int j = 0; j < MIN_ROW_COL; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(MIN_ROW_COL, MIN_ROW_COL, 3);

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, MIN_ROW_COL, MIN_ROW_COL));
        assertEquals(3, ourBoard.getNumToWin());
    }


    //---------------------//
    //  checkIfFree tests  //
    //---------------------//


    // This test case is unique and distinct because it tests for when checkIfFree should
    // return true, with an empty board
    @Test
    public void test_CheckIfFree_empty(){

        char[][] boardArray;
        boardArray = new char[8][5];

            // Filling board with a some spaces
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(8, 5, 3);

        // Performing check on random space since our entire board is free
        assertTrue(ourBoard.checkIfFree(4));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 8, 5));
    }

    // This test case is unique and distinct because it tests a condition in which checkIfFree
    // should return false, when the entire column is full
    @Test
    public void test_CheckIfFree_notFree() {

        char[][] boardArray;
        boardArray = new char[8][5];

        IGameBoard ourBoard = boardMaker(8, 5, 3);

            // Filling our board with spaces, filling our specified column with token
            // for tests
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    // Filling our specified column
                    if(j == 3){
                        boardArray[i][3] = 'X';
                        ourBoard.placeToken('X', 3);
                    }
                    else {
                        boardArray[i][j] = ' ';
                    }

                }
            }

        assertFalse(ourBoard.checkIfFree(3));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 8, 5));

    }

    // This test case is unique and distinct because we are testing a condition in which
    // a token is in a column but that column is still free
    @Test
    public void test_CheckIfFree_tokenPresent(){

        char[][] boardArray;
        boardArray = new char[8][5];

            // Filling board with a some spaces
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 5; j++) {
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(8, 5, 3);

        // Placing a token in our second column so we can checkIfFree()
        ourBoard.placeToken('X', 2);
        // Putting this same token in our boardArray
        boardArray[0][2] = 'X';

        assertTrue(ourBoard.checkIfFree(2));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 8, 5));
    }


    //-----------------------//
    //  checkHorizWin tests  //
    //-----------------------//


    // This test case is unique and distinct because we are testing a condition in which
    // a horizontal win has occurred
    @Test
    public void test_CheckHorizWin_winCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

            // Filling our board, adding tokens for HorizWin check when necessary
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){

                    boardArray[i][j] = ' ';
                    // Token adding for horizontal check
                    if(i == 0 && j < 3)
                        boardArray[i][j] = 'X';

                }
            }

        IGameBoard ourBoard = boardMaker(8,5,3);

            // Placing tokens at same spot in our board
            for(int i = 0; i < 3; i++){
                ourBoard.placeToken('X', i);
            }

        assertTrue(ourBoard.checkHorizWin(new BoardPosition(0,3), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray,8,5)));
    }


    // This test case is unique and distinct because we are testing a condition in
    // which there is NOT a horizontal win, because the board is empty
    @Test
    public void test_CheckHorizWin_noWinCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard board = boardMaker(8, 5, 3);

        assertFalse(board.checkHorizWin(new BoardPosition(1, 2), 'X'));
        assertEquals(board.toString(), boardDisplay(boardArray, 8, 5));

    }

    // This test case is unique and distinct because we are testing a condition in which
    // enough tokens exist for a horizontal win, but they are not the same tokens
    @Test
    public void test_CheckHorizWin_tokenMix(){

        char[][] boardArray;
        boardArray = new char[8][5];

        // Filling our board, adding tokens for HorizWin check when necessary
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){

                boardArray[i][j] = ' ';
                // Token adding for horizontal check
                if(i == 0 && j < 3)
                    // Putting in false token, to see if our check recognizes it
                    if (j == 1){
                        boardArray[i][j] = 'O';
                    }
                    else {
                        boardArray[i][j] = 'X';
                    }

            }
        }

        IGameBoard ourBoard = boardMaker(8,5,3);

        // Placing tokens at same spot in our board
        for(int i = 0; i < 3; i++){
            if (i == 1){
                ourBoard.placeToken('O', i);
            }
            else {
                ourBoard.placeToken('X', i);
            }
        }

        assertFalse(ourBoard.checkHorizWin(new BoardPosition(0,3), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray,8,5)));
    }

    // This test case is unique and distinct because we are testing a condition in which
    // there are tokens in a row present but not enough to win
    @Test
    public void test_CheckHorizWin_almostWinCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

        // Filling our board, adding tokens for HorizWin check when necessary
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){

                boardArray[i][j] = ' ';
                // Token adding for horizontal check
                if(i == 0 && j < 3)
                    boardArray[i][j] = 'X';

            }
        }

        IGameBoard ourBoard = boardMaker(8,5,4);

        // Placing tokens at same spot in our board
        for(int i = 0; i < 3; i++){
            ourBoard.placeToken('X', i);
        }

        assertFalse(ourBoard.checkHorizWin(new BoardPosition(0,3), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray,8,5)));
    }



    //------------------------//
    //   checkVertWin tests   //
    //------------------------//

    // This test case is unique and distinct because we are testing a condition in which
    // there is no vertical win
    @Test
    public void test_CheckVertWin_noWinCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(8, 5, 3);

        assertFalse(ourBoard.checkVertWin(new BoardPosition(3, 2), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray, 8, 5)));

    }


    // This test case is unique and distinct because we are testing a condition in which
    // a vertical win has occurred
    @Test
    public void test_CheckVertWin_winCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

            // Filling boardArray, adding vertical tokens when necessary
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    boardArray[i][j] = ' ';
                    // Adding tokens for vertical win
                    if(i < 3 && j == 1)
                        boardArray[i][j] = 'X';
                }
            }

        IGameBoard ourBoard = boardMaker(8,5,3);

            for(int i = 0; i < 3; i++){
                ourBoard.placeToken('X', 1);
            }

        assertTrue(ourBoard.checkVertWin(new BoardPosition(2,1), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray,8,5)));
    }

    // This test case is unique and distinct because we are testing a condition in which
    // a vertical win has ALMOST occurred
    @Test
    public void test_CheckVertWin_almostWinCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

        // Filling boardArray, adding vertical tokens when necessary
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                boardArray[i][j] = ' ';
                // Adding tokens for vertical win
                if(i < 3 && j == 1)
                    boardArray[i][j] = 'X';
            }
        }

        IGameBoard ourBoard = boardMaker(8,5,4);

        for(int i = 0; i < 3; i++){
            ourBoard.placeToken('X', 1);
        }

        assertFalse(ourBoard.checkVertWin(new BoardPosition(2,1), 'X'));
        assertTrue(ourBoard.toString().equals(boardDisplay(boardArray,8,5)));
    }





    // This test case is unique and distinct because we are testing a condition in which
    // enough tokens exist for a vertical win, but they are not the same tokens
    @Test
    public void test_CheckVertWin_tokenMix(){

        char[][] boardArray;
        boardArray = new char[5][5];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){

                    boardArray[i][j] = ' ';
                    if(i < 4 && j == 2) {
                        boardArray[i][j] = 'X';
                    }
                }
            }

        boardArray[2][2] = 'O';

        IGameBoard ourBoard = boardMaker(5,5,3);

            for(int i = 0; i < 4; i++){

                if(i == 2)
                    ourBoard.placeToken('O', 2);
                else
                    ourBoard.placeToken('X', 2);


            }

        assertFalse(ourBoard.checkVertWin(new BoardPosition(3, 2), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 5));
    }


    //------------------------//
    //   checkDiagWin tests   //
    //------------------------//


    // This test case is unique and distinct because we are testing a condition in
    // which there is no diagonal win
    @Test
    public void test_CheckDiagWin_noWinCase(){

        char[][] boardArray;
        boardArray = new char[8][5];

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 5; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard board = boardMaker(8, 5, 3);

        assertFalse(board.checkDiagWin(new BoardPosition(0, 0), 'X'));
        assertEquals(board.toString(), boardDisplay(boardArray, 8, 5));
    }


    // This test case is unique and distinct because we are testing a condition in which
    // there is a diagonal win that goes from bottom left to top right
    @Test
    public void test_CheckDiagWin_leftWinCase(){

        char[][] boardArray;
        boardArray = new char[5][8];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 8; j++){
                boardArray[i][j] = ' ';
            }
        }

        // Adding tokens to specific slots for our left win
        boardArray[0][0] = 'X';
        boardArray[0][1] = 'O';
        boardArray[1][1] = 'X';
        boardArray[0][2] = 'O';
        boardArray[1][2] = 'X';
        boardArray[1][0] = 'O';
        boardArray[2][2] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,3);

        // Doing the same thing to our actual board to compare
        ourBoard.placeToken('X', 0);
        ourBoard.placeToken('O', 1);
        ourBoard.placeToken('X', 1);
        ourBoard.placeToken('O', 2);
        ourBoard.placeToken('X', 2);
        ourBoard.placeToken('O', 0);
        ourBoard.placeToken('X', 2);

        assertTrue(ourBoard.checkDiagWin(new BoardPosition(0, 0), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }

    // This test case is unique and distinct because we are testing a condition in which
    // there is ALMOST a diagonal win going from the bottom left to the top right
    @Test
    public void test_CheckDiagWin_almostLeftWinCase(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i ++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Adding tokens to specific slots for our left win
        boardArray[0][0] = 'X';
        boardArray[0][1] = 'O';
        boardArray[1][1] = 'X';
        boardArray[0][2] = 'O';
        boardArray[1][2] = 'X';
        boardArray[1][0] = 'O';
        boardArray[2][2] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,4);

        // Doing the same thing to our actual board to compare
        ourBoard.placeToken('X', 0);
        ourBoard.placeToken('O', 1);
        ourBoard.placeToken('X', 1);
        ourBoard.placeToken('O', 2);
        ourBoard.placeToken('X', 2);
        ourBoard.placeToken('O', 0);
        ourBoard.placeToken('X', 2);

        assertFalse(ourBoard.checkDiagWin(new BoardPosition(0, 0), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }

    // This test case is unique and distinct because we are testing a condition in which
    // there are tokens in a row diagonally from left to right but they are not all the same token
    @Test
    public void test_CheckDiagWin_mixedTokensLeft(){

        char[][] boardArray;
        boardArray = new char[5][8];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 8; j++){
                boardArray[i][j] = ' ';
            }
        }

        // Adding tokens to specific slots for our left win
        boardArray[0][0] = 'X';
        boardArray[0][1] = 'O';
        boardArray[1][1] = 'M';
        boardArray[0][2] = 'O';
        boardArray[1][2] = 'X';
        boardArray[1][0] = 'O';
        boardArray[2][2] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,3);

        // Doing the same thing to our actual board to compare
        ourBoard.placeToken('X', 0);
        ourBoard.placeToken('O', 1);
        ourBoard.placeToken('M', 1);
        ourBoard.placeToken('O', 2);
        ourBoard.placeToken('X', 2);
        ourBoard.placeToken('O', 0);
        ourBoard.placeToken('X', 2);

        assertFalse(ourBoard.checkDiagWin(new BoardPosition(0, 0), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }


    // This test case is unique and distinct because we are testing a condition in which
    // there is a diagonal win going from the bottom right to the top left
    @Test
    public void test_CheckDiagWin_rightWinCase(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i ++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        boardArray[0][6] = 'X';
        boardArray[0][5] = 'O';
        boardArray[1][5] = 'X';
        boardArray[0][4] = 'O';
        boardArray[1][4] = 'O';
        boardArray[2][4] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,3);

        ourBoard.placeToken('X', 6);
        ourBoard.placeToken('O', 5);
        ourBoard.placeToken('X', 5);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('X', 4);

        assertTrue(ourBoard.checkDiagWin(new BoardPosition(0,6), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }
        
    // This test case is unique and distinct because we are testing a condition in which
    // there is ALMOST a diagonal win going from the bottom right to the top left
    @Test
    public void test_CheckDiagWin_almostRightWinCase(){

        char[][] boardArray;
        boardArray = new char[5][8];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 8; j++){
                boardArray[i][j] = ' ';
            }
        }

        boardArray[0][6] = 'X';
        boardArray[0][5] = 'O';
        boardArray[1][5] = 'X';
        boardArray[0][4] = 'O';
        boardArray[1][4] = 'O';
        boardArray[2][4] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,4);

        ourBoard.placeToken('X', 6);
        ourBoard.placeToken('O', 5);
        ourBoard.placeToken('X', 5);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('X', 4);

        assertFalse(ourBoard.checkDiagWin(new BoardPosition(2,1), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }

    // This test case is unique and distinct because we are testing a condition in which
    // there are tokens in a row diagonally from right to left but they are not all the same token
    @Test
    public void test_CheckDiagWin_mixedTokensRight(){

        char[][] boardArray;
        boardArray = new char[5][8];

        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 8; j++){
                boardArray[i][j] = ' ';
            }
        }

        boardArray[0][6] = 'X';
        boardArray[0][5] = 'O';
        boardArray[1][5] = 'M';
        boardArray[0][4] = 'O';
        boardArray[1][4] = 'O';
        boardArray[2][4] = 'X';

        IGameBoard ourBoard = boardMaker(5,8,3);

        ourBoard.placeToken('X', 6);
        ourBoard.placeToken('O', 5);
        ourBoard.placeToken('M', 5);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('O', 4);
        ourBoard.placeToken('X', 4);

        assertFalse(ourBoard.checkDiagWin(new BoardPosition(0,6), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));

    }

    //------------------------//
    //    checkTie tests      //
    //------------------------//

    // This test case is unique and distinct because we are testing a condition
    // in which our board is empty and therefore cannot have a tie
    @Test
    public void test_CheckTie_boardEmpty(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        assertFalse(ourBoard.checkTie());
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is distinct and unique because we are testing a
    // condition in which our board has tokens but is not full, this
    // ensures that are program is effectively checking every column
    @Test
    public void test_CheckTie_boardOccupied(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    if(j == 7) {
                        boardArray[i][j] = ' ';
                    }
                    else {
                        boardArray[i][j] = 'X';
                    }
                }
            }

        IGameBoard ourBoard = boardMaker(5,8,3);


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    if (j != 7) {
                        ourBoard.placeToken('X', j);
                    }
                }
            }

        assertFalse(ourBoard.checkTie());
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }



    // This test case is unique and distinct because we are testing a condition in which
    // our board is full without any wins and should therefore result in a tie game
    @Test
    public void test_CheckTie_boardFull(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = 'X';
                }
            }

        IGameBoard ourBoard = boardMaker(5,8,3);

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    ourBoard.placeToken('X', j);
                }
            }

        assertTrue(ourBoard.checkTie());
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition in which
    // every space is filled but one. This will allow us to ensure every single space
    // is being checked
    @Test
    public void test_CheckTie_oneSpace(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = 'X';
                }
            }

        boardArray[4][7] = ' ';

        IGameBoard ourBoard = boardMaker(5,8,3);


            // Filling every column in our board but one
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 7; j++){
                    ourBoard.placeToken('X', j);
                }
            }

        // Filling the last column in our board, leaving one space
        ourBoard.placeToken('X',7);
        ourBoard.placeToken('X',7);
        ourBoard.placeToken('X',7);
        ourBoard.placeToken('X',7);

        assertFalse(ourBoard.checkTie());
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }



    //------------------------//
    //    whatsAtPos test     //
    //------------------------//

    // This test case is unique and distinct because we are testing a condition in which
    // our board is empty and thus our method should always return false
    @Test
    public void test_WhatsAtPos_boardEmpty(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        assertEquals(' ', ourBoard.whatsAtPos(new BoardPosition(0, 0)));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition in which
    // there is a player located at the specified position that we need to return
    @Test
    public void test_WhatAtPos_playerAtPlace(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'X';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('X',3);

        assertEquals('X', ourBoard.whatsAtPos(new BoardPosition(0, 3)));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }

    // This test case is unique and distinct because we are testing a condition in which
    // there is a player located at position but not the one we are checking. This will
    // ensure our function is checking the right location
    @Test
    public void test_WhatAtPos_playerAtWrongPlace(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'X';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('X',3);

        assertEquals(' ', ourBoard.whatsAtPos(new BoardPosition(3, 3)));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition in which
    // our function needs to return a token that is not a ' ', 'X', or 'O'
    @Test
    public void test_WhatsAtPos_uniqueChar(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'M';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('M',3);

        assertEquals('M', ourBoard.whatsAtPos(new BoardPosition(0, 3)));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }

    // This test case is unique and distinct because we are testing a condition in which
    // there are multiple players on our board and our method must return
    // the correct one
    @Test
    public void test_WhatsAtPos_multiplePlayers() {

        char[][] boardArray;
        boardArray = new char[5][8];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    boardArray[i][j] = ' ';
                }
            }

        boardArray[0][2] = 'M';
        boardArray[0][3] = 'X';
        boardArray[0][4] = 'O';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('M', 2);
        ourBoard.placeToken('X', 3);
        ourBoard.placeToken('O', 4);

        assertEquals('X', ourBoard.whatsAtPos(new BoardPosition(0, 3)));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    //--------------------------//
    //    isPlayerAtPos test    //
    //--------------------------//


    // This test case is unique and distinct because we are testing a condition in which
    // our board is completely empty and should thus always return false when calling isPlayer
    @Test
    public void test_isPlayerAtPos_boardEmpty(){

        char[][] boardArray;
        boardArray = new char[5][8];


            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        assertFalse(ourBoard.isPlayerAtPos(new BoardPosition(3, 5), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }

    // This test case is unique and distinct because we are testing a condition in which
    // there is a player located at the specified position
    @Test
    public void test_IsPlayerAtPos_playerAtPlace(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'X';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('X',3);

        assertTrue(ourBoard.isPlayerAtPos(new BoardPosition(0, 3), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }



    // This test case is unique and distinct because we are testing a condition in which
    // our function needs to return a token that is not a ' ', 'X', or 'O'
    @Test
    public void test_IsPlayerAtPos_uniqueChar(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'M';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('M',3);

        assertTrue(ourBoard.isPlayerAtPos(new BoardPosition(0, 3), 'M'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }




    // This test case is unique and distinct because we are testing a condition in which
    // there are multiple players on our board
    @Test
    public void test_isPlayerAtPos_multiplePlayers() {

        char[][] boardArray;
        boardArray = new char[5][8];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    boardArray[i][j] = ' ';
                }
            }

        boardArray[0][2] = 'M';
        boardArray[0][3] = 'X';
        boardArray[0][4] = 'O';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('M', 2);
        ourBoard.placeToken('X', 3);
        ourBoard.placeToken('O', 4);

        assertTrue(ourBoard.isPlayerAtPos(new BoardPosition(0, 3), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition in which
    // there is a player located at position but not the one we are checking. This will
    // ensure our function is checking the right location
    @Test
    public void test_isPlayerAtPos_playerAtWrongPlace(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = ' ';
                }
            }

        // Putting player at random position
        boardArray[0][3] = 'X';

        IGameBoard ourBoard = boardMaker(5, 8, 3);

        ourBoard.placeToken('X',3);

        assertFalse(ourBoard.isPlayerAtPos(new BoardPosition(3, 3), 'X'));
        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    //-----------------------//
    //    placeToken test    //
    //-----------------------//


    // This test case is unique and distinct because we are testing a condition in which
    // our placeToken function needs to fill the entire board
    @Test
    public void test_PlaceToken_boardFull(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][j] = 'X';
                }
            }

        IGameBoard ourBoard = boardMaker(5,8,3);


            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    ourBoard.placeToken('X', j);
                }
            }

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct be we are testing a condition in which
    // we need to fill our entire board using multiple different characters
    @Test
    public void test_PlaceToken_boardFullMultChars(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    boardArray[i][0] = 'A';
                    boardArray[i][1] = 'B';
                    boardArray[i][2] = 'C';
                    boardArray[i][3] = 'D';
                    boardArray[i][4] = 'E';
                    boardArray[i][5] = 'F';
                    boardArray[i][6] = 'G';
                    boardArray[i][7] = 'H';
                }
            }

        IGameBoard ourBoard = boardMaker(5,8,3);

            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 8; j++){
                    ourBoard.placeToken('A', 0);
                    ourBoard.placeToken('B', 1);
                    ourBoard.placeToken('C', 2);
                    ourBoard.placeToken('D', 3);
                    ourBoard.placeToken('E', 4);
                    ourBoard.placeToken('F', 5);
                    ourBoard.placeToken('G', 6);
                    ourBoard.placeToken('H', 7);
                }
            }

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }

    // This test case is unique and distinct because we are testing a condition in
    // which are placing a single token in the first column of our board
    @Test
    public void test_PlaceToken_firstColumn(){

        char[][] boardArray;
        boardArray = new char[5][8];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                boardArray[i][j] = ' ';
            }
        }

        boardArray[0][0] = 'X';

        IGameBoard ourBoard = boardMaker (5,8,3);
        ourBoard.placeToken('X',0);

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition
    // in which there are multiple players that need to be placed onto the board
    @Test
    public void test_PlaceToken_multiplePlayers(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    boardArray[i][j] = ' ';
                }
            }

        boardArray[0][4] = 'X';
        boardArray[0][5] = 'O';
        boardArray[0][6] = 'M';

        IGameBoard board = boardMaker(5, 8, 3);

        board.placeToken('X', 4);
        board.placeToken('O', 5);
        board.placeToken('M', 6);

        assertEquals(board.toString(), boardDisplay(boardArray, 5, 8));
    }


    // This test case is unique and distinct because we are testing a condition in
    // which are placing a single token in the last column of our board
    @Test
    public void test_PlaceToken_finalColumn(){

        char[][] boardArray;
        boardArray = new char[5][8];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    boardArray[i][j] = ' ';
                }
            }

        boardArray[0][7] = 'X';

        IGameBoard ourBoard = boardMaker (5,8,3);
        ourBoard.placeToken('X',7);

        assertEquals(ourBoard.toString(), boardDisplay(boardArray, 5, 8));
    }

}