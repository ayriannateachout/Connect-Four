/*Programmers:Ayrianna, Kaden
 * Date: 10/12/23
 * Purpose: It initializes the game by taking input for the names of Player 1 (Red) and Player 2 (Yellow) 
 * from the user, creates a ConnectFourGame instance using these names, and then starts the game. The user 
 * is prompted to enter the names of the players, and the game logic is encapsulated in the ConnectFourGame 
 * class. Once the game is finished, the scanner is closed.
*/

import java.util.Scanner;
public class ConnectFourMain {
    public static void main(String[] args) {
    	System.out.print("This is Connect Four. The Game is best 2 out of 3.");
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter the name of Player 1 (Red): "); //Assigns player 1 a name
        String player1Name = scanner.nextLine();
        System.out.print("Enter the name of Player 2 (Yellow): "); //Assigns player 2 a name



String player2Name = scanner.nextLine();

        ConnectFourGame game = new ConnectFourGame(player1Name, player2Name);
        game.startGame();

        scanner.close();
    }
}