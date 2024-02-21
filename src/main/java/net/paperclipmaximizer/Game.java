package net.paperclipmaximizer;

import java.util.Scanner;

/**
 * Abstract class for game objects to inherit from
 * it defers most of its method implementations to the child class
 */
abstract class Game {
    //starts as true to allow for the first game to be played
    boolean playAgain = true;
    String winner;
    public String getWinner() {
        return winner;
    }
    // static scanner for input
	public static Scanner input = new Scanner(System.in);
    // runs the game loop
    public final void loop(){
        initialise();
        // this is problematic, we are handling the metagame loop in the game class, 
        // this should be handled elsewhere perhaps in a main loop or by freeing and 
        // initializing a new object
        while (playAgain){
            while (!endOfGame()){
                changeTurn();
                nextMove();
            }
            winnerDialogue();
            
            if (queryPlayAgain()){
                resetWinCondition();
            }

        }
    }
    // queries the player for a second round
	private static boolean queryPlayAgain(){
		System.out.println("Do you want to play againt (Y/N):");
		if (!input.next().equals("Y")){
			return false;
		}else{
		    return true;
		}
	}

    private void winnerDialogue(){
        System.out.println("Congratulations " + winner + " you have won!");
    }

    protected abstract void initialise();
    protected abstract void nextMove();
    protected abstract boolean endOfGame();
    protected abstract void changeTurn();
    protected abstract void resetWinCondition();    
}
