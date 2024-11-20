/*Programmers:Ayrianna, Kaden
 * Date:10/11/2023
 * Purpose: It contains a 6x7 grid (the game board), initializes the board, allows players to drop game pieces
 *  into columns, checks if a column is full, displays the current state of the board, checks for a Connect 
 *  Four win condition (horizontal, vertical, or diagonal), and determines if the entire board is full, 
 *  resulting in a draw. It serves as the core data structure and game mechanics for a Connect Four game.
 */

public class ConnectFourBoard {
    private char[][] board;

    public ConnectFourBoard() {
        board = new char[6][7]; //Create board
        initializeBoard();
    }

    public void initializeBoard() { //Board logic
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean dropPiece(Player player, int column) { //Displaying the game piece
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = player.getColor();
                return true;
            }
        }
        return false; // The column is full
    }

    public boolean isColumnFull(int column) { 
        return board[0][column] != ' ';
    }

    public void displayBoard() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public boolean isConnectFour(Player player) {  //Check for Win
    	char color = player.getColor();

        // Check for a horizontal win
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                if (board[row][col] == color &&
                    board[row][col + 1] == color &&
                    board[row][col + 2] == color &&
                    board[row][col + 3] == color) {
                    return true;
                }
            }
        }

        // Check for a vertical win
        for (int row = 0; row <= 2; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == color &&
                    board[row + 1][col] == color &&
                    board[row + 2][col] == color &&
                    board[row + 3][col] == color) {
                    return true;
                }
            }
        }

        // Check for a diagonal win (ascending)
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                if (board[row][col] == color &&
                    board[row - 1][col + 1] == color &&
                    board[row - 2][col + 2] == color &&
                    board[row - 3][col + 3] == color) {
                    return true;
                }
            }
        }

        // Check for a diagonal win (descending)
        for (int row = 0; row <= 2; row++) {
            for (int col = 0; col <= 3; col++) {
                if (board[row][col] == color &&
                    board[row + 1][col + 1] == color &&
                    board[row + 2][col + 2] == color &&
                    board[row + 3][col + 3] == color) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int col = 0; col < 7; col++) {
            if (board[0][col] == ' ') {
                return false; // The board is not full
            }
        }
        return true; // All columns are full, and it's a draw.
    }
}
