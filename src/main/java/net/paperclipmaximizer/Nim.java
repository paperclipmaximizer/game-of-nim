package net.paperclipmaximizer;

import java.util.Scanner;
/**
 * @author Liam Avella-Pisera a simple "avoid removing the last stone" variant of 
 * Game of Nim. Inits a game with a Player 1, Player 2 and polls for starting stones, 
 * plays the gameloop and turn loop
 */
public class Nim extends Game{
	
	// players
	private Player player_one;
	private Player player_two;

	// stone parameters
    private int upperBounds;
    private int initStones;
	private int currentStones;
	
	//enum for keeping track of turns
	private enum playerTurn {
		PLAYER_ONE,
		PLAYER_TWO
	}
	private playerTurn turn = playerTurn.PLAYER_ONE;

	// converts Integer n to an n long concatenation of asterisks
	public static String integerToAsterisk(int number){
		String asterisks = "";
		String end = " *";
		for (int i = 0; i < number; i++){
			asterisks += end;
		}
		return asterisks;
	}
	
	// called to initialize the game
	@Override
	public void initialise(){
		System.out.println("Welcome to Nim!");
		System.out.println("Please eneter Player 1's name:");
		//a player is initialized with a name;
		player_one = new Player(input.nextLine());
		System.out.println("Please enter Player 2's name:");
		player_two = new Player(input.nextLine());
		// get game parameters
		System.out.println("Please enter upper bound of stone removal:");
		// TODO: disallow negative numbers
		upperBounds = input.nextInt();
		System.out.println("Please enter initial number of stones:");
		initStones = input.nextInt();
		currentStones = initStones;
	}

	@Override
	protected boolean endOfGame(){
		if (currentStones == 0){
			if (turn == playerTurn.PLAYER_ONE){
				winner = player_two.getName();
				
			}else{
			winner = player_one.getName();
			}
			return true;
		} 
		return false;
	}
	// runs until the game is over
	@Override
	protected void nextMove(){
		//while(currentStones>0) {
			if (turn == playerTurn.PLAYER_ONE){
				turn(player_one);
				return;
			}				
			turn(player_two);
	}

	// changes the turn
	@Override
	protected void changeTurn(){
		if (turn == playerTurn.PLAYER_ONE){
			turn = playerTurn.PLAYER_TWO;
			return;
		}
		turn = playerTurn.PLAYER_ONE;
	}
	// runs a single turn
	private void turn(Player player){
		System.out.println(currentStones + " stones left:" + integerToAsterisk(currentStones));
		currentStones -= player.removeStone(upperBounds);
	}
	@Override
	protected void resetWinCondition() {
		currentStones = initStones;
	}
}
