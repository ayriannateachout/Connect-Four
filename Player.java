/*Programmer: Ayrianna, Kaden
 * Date: 10/9/23
 * Purpose:  It has attributes for the player's name and the color of their game pieces. The constructor 
 * initializes these attributes. The getColor method returns the player's chosen game piece color. 
 * The chooseColumn method prompts the player to input a column number (1-7) to place their game piece 
 * and returns their choice, adjusted for the 0-based index used in the game logic. The getName method 
 * returns the player's name. This class is responsible for managing the player's input and attributes 
 * in the Connect Four game.
 */


import java.util.Scanner;

public class Player {
    private String name;
    private char color;

    public Player(String name, char color) {
        this.name = name;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public int chooseColumn() {
        Scanner oScan = new Scanner(System.in);
        System.out.print(name + ", choose a column (1-7): ");
        int column = oScan.nextInt();
        oScan.nextLine(); // Consume the newline character
        return column - 1; // Adjust for 0-based index
    }

    public String getName() {
        return name;
    }
}



