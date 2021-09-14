package cpsc2150.extendedConnectX;
import java.util.Locale;
import java.util.Scanner;
import java.lang.*;

// Julio Reyes
// CPSC 2150
// 003
// 2/07/2021

public class GameScreen {

    /**
     * The only method I could imagine being in the class at least
     * for now would be main so I didn't really know what to add here, but
     * I am nervous about losing points so I decided to just put my best
     * guess at a javadoc contract for this
     */

    /**
     * This is our main function which will control the flow of the game and call
     * our methods in BoardPosition.java and GameBoard.java
     * @param args This parameter was provided in the starter code for the main function
     * but I am not 100% sure why since I don't know what the user would provide when running
     * @pre NONE
     * @post Controls the flow of the extendedConnectX game, calls functions in BoardPosition and
     * GameBoard
     * @return NONE
     */
    public static void main(String[] args)  {

        // CODE CONSTANTS
        // This is the maximum number of rows we can have
        final int MAX_ROW = 100;
        // THis is the maximum number of columns we can have
        final int MAX_COL = 100;
        // This is the maximum number of tokens in row that can win the game
        final int MAX_NUM_TO_WIN = 25;
        // This is the minimum number of rows, columns, and tokens in a row that can win the game
        final int MIN_ROW_COL_WIN = 3;
        // This is the maximum number of players that can be in the game
        final int MAX_PLAYERS = 10;
        // This is the minimum number of players that can be in the game
        final int MIN_PLAYERS = 2;
        // This will reset our "i" variable to -1 so that the loop which runs our game can return
        // to player 1 after reaching the last player. It is -1 and not 0 because our loop concludes by adding
        // 1 to i
        final int RESET_I = -1;


        // The column the user will select to play the game
        int userColumn;
        // Initialize scanner variable to get user input
        Scanner in = new Scanner (System.in);
        // String we will use to store user input
        String userIn;
        // User selected number of rows
        int userRows;
        // User selected number of columns
        int userCols;
        // User selected number of tokens needed to win
        int userWinNum;
        // User selected number of players
        int userPlayerNum;


        // NEW GAME
            while (true) {

                   // PLAYER NUMBER SELECTION
                   while (true) {
                       System.out.println("How many players?");
                       userIn = in.next();


                            // Making sure the user has entered an integer value
                            try {
                               userPlayerNum = Integer.parseInt(userIn);
                            } catch (NumberFormatException e) {
                               System.out.println("Please enter an integer value");
                               continue;
                            }

                            // Checking that the appropriate number of players have
                            // been entered
                            if (userPlayerNum > MAX_PLAYERS){
                                System.out.println("Must be 10 players or fewer");
                                continue;
                            }
                            else if (userPlayerNum < MIN_PLAYERS){
                                System.out.println("Must be at least 2 players");
                                continue;
                            }
                       break;
                   }


                // Creating a character array that will hold tokens for all our players
                char currentPlayer[] = new char[userPlayerNum];


                   // PLAYER TOKEN SELECTION
                   for (int i = 0; i < userPlayerNum; i++){

                       // Boolean value we will use to see if token has already been selected
                       boolean tokenTaken = false;

                       System.out.println("Enter the character to represent player " + (i+1));
                       userIn = in.next();

                            // Making sure the user has entered a character
                            if (!Character.isLetter(userIn.charAt(0))){
                                System.out.println("Your token must be a character value");
                                i--;
                                continue;
                            }

                            // Checking to make sure the token entered is only 1 character
                            if (userIn.length() > 1){
                                System.out.println("Please enter only one character for your token");
                                i--;
                                continue;
                            }

                       // Converting our user selected token to uppercase, and storing it in our char array
                       currentPlayer[i] = Character.toUpperCase(userIn.charAt(0));


                            // Making sure token hasn't already been selected
                            for (int j = 0; j < userPlayerNum; j++){
                                if ((i != j) && (currentPlayer[i] == currentPlayer[j])){
                                    System.out.println(currentPlayer[i] + " is already taken as a player token!");
                                    tokenTaken = true;
                                    break;
                                }
                                tokenTaken = false;
                            }

                            // Re-prompting if token has been taken
                            if (tokenTaken == true){
                                i--;
                            }
                            // Checking to make sure the player has entered a character
                            if (!Character.isLetter(currentPlayer[i])){
                                System.out.println("Player token must be a character");
                                i--;
                            }

                   }



                    // PLAYER ROW SELECTION
                    while (true){

                        System.out.println("How many rows should be on the board?");
                        userIn = in.next();
                        userRows = Integer.parseInt(userIn);

                            // Checking rows
                            if (userRows < MIN_ROW_COL_WIN){
                                System.out.println("Number of rows must be greater than or equal to 3");
                                continue;
                            }
                            else if (userRows > MAX_ROW){
                                System.out.println("Number of rows must be less than or equal to 100");
                                continue;
                            }
                        break;
                    }


                    // PLAYER COLUMN SELECTION
                    while (true){

                        System.out.println("How many columns should be on the board?");
                        userIn = in.next();
                        userCols = Integer.parseInt(userIn);

                        // Checking columns
                        if (userCols < MIN_ROW_COL_WIN){
                            System.out.println("Number of columns must be greater than or equal to 3");
                            continue;
                        }
                        else if (userCols > MAX_COL){
                            System.out.println("Number of columns must be less than or equal to 100");
                            continue;
                        }
                        break;
                    }


                    // PLAYER NUMBER TO WIN SELECTION
                    while (true){

                        System.out.println("How many in a row to win?");
                        userIn = in.next();
                        userWinNum = Integer.parseInt(userIn);

                        // Checking columns
                        if (userWinNum < MIN_ROW_COL_WIN){
                            System.out.println("Number of tokens in a row to win must be greater than or equal to 3");
                            continue;
                        }
                        else if (userWinNum > MAX_NUM_TO_WIN){
                            System.out.println("Number of tokens in a row to win must be less than or equal to 25");
                            continue;
                        }
                        break;
                    }


                    // Creating our game board
                    IGameBoard ourGame = new GameBoard(userRows, userCols, userWinNum);

                    // GAME TYPE SELECTION
                    while (true){
                        System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");

                        userIn = in.next();

                            if ((userIn.charAt(0) == 'F') || (userIn.charAt(0) == 'f')){
                                ourGame = new GameBoard(userRows, userCols, userWinNum);
                                break;
                            }
                            if ((userIn.charAt(0) == 'M') || (userIn.charAt(0) == 'm')){
                                ourGame = new GameBoardMem(userRows, userCols, userWinNum);
                                break;
                            }
                            else {
                                System.out.println("Please enter either F or M");
                            }
                    }


                // PLAYING GAME
                System.out.println(ourGame);

                    // Looping through our game
                    for (int i = 0; i < userPlayerNum; i++) {

                        System.out.println("\nPlayer " + (i+1) + ", what column do you want to place your marker in?");

                        userIn = in.next();

                        // Integer we will use to convert our user inputted string
                        int stringToInt;

                            // Making sure the user has entered an integer value
                            try {
                                stringToInt = Integer.parseInt(userIn);
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter an integer value");
                                i--;
                                continue;
                            }


                            if ((stringToInt < 0) || (stringToInt > userCols)){
                                System.out.println("Column cannot be greater than " + userCols);
                                i--;
                                continue;
                            }


                        // Checking if board position is available
                        if (ourGame.checkIfFree(stringToInt)) {
                            ourGame.placeToken(currentPlayer[i], stringToInt);
                        } else {
                            System.out.println("Sorry, this column is unavailable, please select another column");
                            i--;
                            continue;
                        }

                        // Checking if this move has resulted in a win
                        if (ourGame.checkForWin(stringToInt)) {
                            System.out.println("Player " + (i+1) + " won!");
                            System.out.println(ourGame);
                            break;
                        }

                        // Checking if this move has resulted in a tie
                        if (ourGame.checkTie()) {
                            System.out.println("\nThe game has ended in a tie!");
                            System.out.println(ourGame);
                            break;
                        }

                        // Resetting back to Player 1 if all the players have gone
                        if (i == (userPlayerNum - 1)){
                            i = RESET_I;
                        }

                        System.out.println(ourGame);
                    }


                    // GAME HAS ENDED

                    // Seeing if player wants to play again
                    while (true) {
                        System.out.println("\nWould you like to play again? Y/N");
                        userIn = in.next();

                            if (userIn.charAt(0) == 'Y' || userIn.charAt(0) == 'y' || userIn.charAt(0) == 'N' || userIn.charAt(0) == 'n'){
                                break;
                            }
                            else {
                                System.out.println("Please type either Y or N");
                            }
                    }

                // Ending game if user wants to quit
                if (userIn.charAt(0) == 'N' || userIn.charAt(0) == 'n'){
                    break;
                }

                // Restarting game otherwise...
            }
    }
}
