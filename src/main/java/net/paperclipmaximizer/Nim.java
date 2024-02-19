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
	public void initGame(){
		System.out.println("Please eneter Player 1's name:");
		//a player is initialized with a name;
		Player player_one = new Player(input.nextLine());
		System.out.println("Please enter Player 2's name:");
		Player player_two = new Player(input.nextLine());
		// start the game cycle
		System.out.println("Please enter upper bound of stone removal:");
		int upperBounds = input.nextInt();
		System.out.println("Please enter initial number of stones:");
		int initStones = input.nextInt();
		// enter game cycle
		boolean playAgain = true;
		while(playAgain){
			Nim game = new Nim();
			String winner = game.play(initStones, player_one, player_two, upperBounds);
			System.out.println("Game Over\n" + winner + " wins!");
			playAgain = queryPlayAgain();
		}
	}
	
	// runs until the game is over
	public String play(int stones, Player player_one, Player player_two, int upperBounds){
		int currentStones = stones;
		// if false it is player ones turn
		boolean playerTwosTurn = false;
		while(currentStones>0) {
			if (playerTwosTurn){
				currentStones = turn(player_two, currentStones, upperBounds);
			}else{				
				currentStones = turn(player_one, currentStones, upperBounds);
			}
			playerTwosTurn = !playerTwosTurn;
		}
		// determine the winner
		if (playerTwosTurn){
			return player_two.getName();
		}else{
			return player_one.getName();
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
