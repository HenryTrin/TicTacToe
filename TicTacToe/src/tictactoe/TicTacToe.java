/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

/**11/13/2020 Basic Tic Tac Toe Game
 *
 * @author Trinh
 */
public class TicTacToe {
    
    
    public static final int ROWS = 3, COLS = 3;
    public String p1 = "Player 1";
    public String p2 =  "Player 2";
    //3 x 3 2D array that is the board
    public static Scanner input;
    public static String[] gameBoard = new String[9];
    public static String currentTurn;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        input = new Scanner(System.in);
        currentTurn = "X";
        
	String winner = null;
        populateEmptyBoard();        
        drawBoard();
        System.out.println("2 player Tic Tac Toe");
        
        
        //Function that will check if the move is the winnte or not
        while(winner == null){
            //2 cases where the number inputed is out of bounce or already taken
            int playerInput = 0;            
            try{
               playerInput = input.nextInt(); 
                if(!(playerInput > 0 && playerInput <= 9)) {
                    System.out.println("Invalid input");
               
                }
            } catch(InputMismatchException e) {
                System.out.println("Invalid input;");
            }
            
            //Put the input into the board
            if(gameBoard[playerInput-1].equals(String.valueOf(playerInput))){
                gameBoard[playerInput-1] = currentTurn;
                if("X".equals(currentTurn)) {
                    currentTurn = "0";
             } else{
                currentTurn = "X";
                }
                drawBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken; re-enter slot number:");
            } 
        }
        if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
    }
    /**
     *
     */
    public static void drawBoard() {
	System.out.println("/---|---|---\\");
	System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
	System.out.println("|-----------|");
	System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
	System.out.println("|-----------|");
	System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
	System.out.println("/---|---|---//");
    }
    
    static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			gameBoard[a] = String.valueOf(a+1);
		}
	}
    
    static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = gameBoard[0] + gameBoard[1] + gameBoard[2];
				break;
			case 1:
				line = gameBoard[3] + gameBoard[4] + gameBoard[5];
				break;
			case 2:
				line = gameBoard[6] + gameBoard[7] + gameBoard[8];
				break;
			case 3:
				line = gameBoard[0] + gameBoard[3] + gameBoard[6];
				break;
			case 4:
				line = gameBoard[1] + gameBoard[4] + gameBoard[7];
				break;
			case 5:
				line = gameBoard[2] + gameBoard[5] + gameBoard[8];
				break;
			case 6:
				line = gameBoard[0] + gameBoard[4] + gameBoard[8];
				break;
			case 7:
				line = gameBoard[2] + gameBoard[4] + gameBoard[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(gameBoard).contains(String.valueOf(i))) {
				break;
			}
			else if (i == 8) return "draw";
		}

		System.out.println(currentTurn + "'s turn; enter a slot number to place " + currentTurn + " in:");
		return null;
	}
}
 





