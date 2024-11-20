/*Programmers: Ayrianna, Kaden
 * Date: 10/11/23
 * Purpose:  It initializes and maintains the game's essential components, including the game board, two 
 * players, the current player, and a flag to determine if the game is over. The startGame method runs 
 * the game loop, which displays the current game state, lets the current player choose a column to place 
 * their game piece, validates the move, checks for a win condition or a draw, and switches turns to the 
 * other player. If a player wins, their name is displayed, and in the case of a draw, it announces a draw. 
 * The class effectively manages the flow and logic of the Connect Four game, coordinating with the 
 * ConnectFourBoard and Player classes to provide a complete gaming experience.
*/

public class ConnectFourGame {
    // Declarations
    private ConnectFourBoard board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private boolean gameOver;
    private int player1Wins;
    private int player2Wins;

    public ConnectFourGame(String player1Name, String player2Name) {
        board = new ConnectFourBoard();
        player1 = new Player(player1Name, 'R');
        player2 = new Player(player2Name, 'Y');
        gameOver = false;
        player1Wins = 0;
        player2Wins = 0;
    }

    public void startGame() {
        while (player1Wins < 2 && player2Wins < 2) {
            resetGame();
            playSingleGame();
            if (board.isConnectFour(player1)) {
                player1Wins++;
            } else if (board.isConnectFour(player2)) {
                player2Wins++;
            }
            displayScore();
        }
        displayOverallWinner();
    }

    private void playSingleGame() {
        while (!gameOver) {
            board.displayBoard();
            int column = currentPlayer.chooseColumn();
            if (column >= 0 && column < 7 && !board.isColumnFull(column)) {
                if (board.dropPiece(currentPlayer, column)) {
                    if (board.isConnectFour(currentPlayer)) {
                        board.displayBoard();
                        System.out.println(currentPlayer.getName() + " wins the match!");
                        gameOver = true;
                    } else if (board.isBoardFull()) {
                        board.displayBoard();
                        System.out.println("It's a draw!");
                        gameOver = true;
                    } else {
                        currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    }
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private void resetGame() {
        board.initializeBoard();
        currentPlayer = player1;
        gameOver = false;
    }

    private void displayScore() {
        System.out.println("Score - " + player1.getName() + ": " + player1Wins + ", " + player2.getName() + ": " + player2Wins);
    }

    private void displayOverallWinner() {
        if (player1Wins > player2Wins) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2Wins > player1Wins) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}


