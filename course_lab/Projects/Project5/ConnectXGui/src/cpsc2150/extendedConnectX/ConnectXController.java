package cpsc2150.extendedConnectX;

/**
 * The controller class will handle communication between our View and our Model (IGameBoard)
 * <p>
 * This is where you will write code
 * <p>
 * You will need to include your IGameBoard interface
 * and both of the IGameBoard implementations from Project 4
 * If your code was correct you will not need to make any changes to your IGameBoard implementation class
 */
public class ConnectXController {

    //our current game that is being played
    private IGameBoard curGame;

    //The screen that provides our view
    private ConnectXView screen;

    public static final int MAX_PLAYERS = 10;
    //our play tokens are hard coded. We could make a screen to get those from the user, but

    private final int numPlayers;
    private int ourPlayer;
    private final char[] ourTokens = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private boolean gameOver;


    /**
     * @param model the board implementation
     * @param view  the screen that is shown
     * @post the controller will respond to actions on the view using the model.
     */
    ConnectXController(IGameBoard model, ConnectXView view, int np) {
        this.curGame = model;
        this.screen = view;
        numPlayers = np;
    }

    /**
     * @param col the column of the activated button
     * @post will allow the player to place a token in the column if it is not full, otherwise it will display an error
     * and allow them to pick again. Will check for a win as well. If a player wins it will allow for them to play another
     * game hitting any button
     */
    public void processButtonClick(int col) {

        int ourRow = 0;

        // New game if we have finished
        if (gameOver) {
            this.newGame();
        }
        else {
            // New board position
            BoardPosition newPosition;

            // Checking our column
            if(!curGame.checkIfFree(col)){
                screen.setMessage("The selected column is full, please pick again");
                return;
            }


                for (int i = 0; i < curGame.getNumRows(); i++){

                    newPosition = new BoardPosition(i, col);
                    if(curGame.whatsAtPos(newPosition) == ' '){
                        ourRow = i;
                        break;
                    }

                }

            BoardPosition newPos = new BoardPosition(ourRow, col);

            // Get tokens...
            curGame.placeToken(ourTokens[ourPlayer], col);
            screen.setMarker(newPos.getRow(), col, ourTokens[ourPlayer]);

                // We are checking for a win...
                if(curGame.checkForWin(col)){

                    screen.setMessage("Player " + ourTokens[ourPlayer] + " has won! Press any button to play again.");
                    // Indicate that our game is complete
                    gameOver = true;

                }
                // Now checking for a tie...
                else if (curGame.checkTie()){
                    screen.setMessage("The game has ended in a tie! Press any button to play again.");
                    // Indicate that our game is complete
                    gameOver = true;
                }
                // If no win or tie has happened yet we will just change players
                else {
                    ourPlayer++;
                    if(ourPlayer >= numPlayers) {
                        ourPlayer = 0;
                    }
                    screen.setMessage("Player " + ourTokens[ourPlayer] + ", it is your turn");
                }
        }
    }

    /**
     * This method will start a new game by returning to the setup screen and controller
     */
    private void newGame() {
        //close the current screen
        screen.dispose();
        //start back at the set up menu
        SetupView screen = new SetupView();
        SetupController controller = new SetupController(screen);
        screen.registerObserver(controller);
    }
}