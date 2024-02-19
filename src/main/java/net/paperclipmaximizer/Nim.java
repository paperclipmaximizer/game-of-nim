package net.paperclipmaximizer;

import java.util.Scanner;
/**
 * @author Liam Avella-Pisera a simple "avoid removing the last stone" variant of 
 * Game of Nim. Inits a game with a Player 1, Player 2 and polls for starting stones, 
 * plays the gameloop and turn loop
 */
public class Nim extends Game{
	// static scanner for input
	public static Scanner input = new Scanner(System.in);
	/**
	 * InnerNim
	 */
	Player player_one;
	Player player_two;

    int upperBounds;
    int initStones;
	int currentStones;
	
	private enum playerTurn {
		PLAYER_ONE,
		PLAYER_TWO
	}
	private playerTurn turn = playerTurn.PLAYER_ONE;

	// flag for first session
	private boolean _firstSession = true;
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
	public void initialiseGame(){
		if (_firstSession){
			System.out.println("Welcome to Nim!");
			_firstSession = false;
			System.out.println("Please eneter Player 1's name:");
			//a player is initialized with a name;
			player_one = new Player(input.nextLine());
			System.out.println("Please enter Player 2's name:");
			player_two = new Player(input.nextLine());
			// get game parameters
			System.out.println("Please enter upper bound of stone removal:");
			upperBounds = input.nextInt();
			System.out.println("Please enter initial number of stones:");
			initStones = input.nextInt();
		}

		// enter game cycle

	}

	// TODO: clamp currentStones 
	protected boolean endOfGame(){
		if (currentStones == 0){
			return queryPlayAgain();
		}
		return false;
	}
	// runs until the game is over
	public void nextMove(){
		//while(currentStones>0) {
			if (turn == playerTurn.PLAYER_ONE){
				currentStones = turn(player_one, currentStones, upperBounds);
				return;
			}				
			currentStones = turn(player_two, currentStones, upperBounds);
		}
	//}
	// changes the turn
	protected void changeTurn(){
		if (turn == playerTurn.PLAYER_ONE){
			turn = playerTurn.PLAYER_TWO;
		}else{
			turn = playerTurn.PLAYER_ONE;
		}
	}
	// runs a single turn
	public static Integer turn(Player player, int currentStones, int upperBounds){
		System.out.println(currentStones + " stones left:" + integerToAsterisk(currentStones));
		return currentStones -= player.removeStone(upperBounds);
	}
	
	// queries the player for a second game
	public static boolean queryPlayAgain(){
		System.out.println("Do you want to play againt (Y/N):");
		if (!input.next().equals("Y")){
			return false;
		}else{
		    return true;
		}
	}
}
