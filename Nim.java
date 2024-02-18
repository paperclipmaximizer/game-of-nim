// Copyright 2024 Liam Avella-Pisera <liam.avellapisera@gmail.com>

//     Permission is hereby granted, free of charge, to any person obtaining
//     a copy of this software and associated documentation files (the
// 								"Software"), to deal in the Software without restriction, including
//     without limitation the rights to use, copy, modify, merge, publish,
//     distribute, sublicense, and/or sell copies of the Software, and to
//     permit persons to whom the Software is furnished to do so, subject to
// 							       the following conditions:

//     The above copyright notice and this permission notice shall be
// 	included in all copies or substantial portions of the Software.

// 	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// 	EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// 	MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// 	NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// 	LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// 	OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// 	WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
import java.util.Scanner;
/** Generates a variant of the game of Nim in which the goal is to avoid removing the last stone
 * provides NimGame methods
 * inits a game with a Player 1, Player 2 and
 * polls for upper, lowbounds, plays the gameloop (Player, Player, Integer, Integer)
 */
public class Nim{
    public static Scanner input = new Scanner(System.in);
	/** 
	 * Helper function to convert any integer n to an n long concatenation of " *"
	**/
	public static String integerToAsterisk(int number){
	String asterisks = "";
	String end = " *";
	for (int i = 0; i < number; i++){
		asterisks += end;
	}
		return asterisks;
	}
	public static void main(String[] args){
		System.out.println("Welcome to Nim");
		// start the game
		Nim game = new Nim();
		game.initGame(); 
	}
	// initializes the game
	public void initGame(){
		System.out.println("Please eneter Player 1's name:");
		//a player is initialized with a name;
		Player player_one = new Player(input.nextLine());
		System.out.println("Please enter Player 2's name:");
		Player player_two = new Player(input.nextLine());
		// start the game cycle
		//System.out.println("Please enter upper bound of stone removal:");
		//int upperBounds = input.nextInt();
		System.out.println("Please enter initial number of stones:");
		int initStones = input.nextInt();
		// enter game cycle
		var playAgain = true;
		while(playAgain){
			Nim game = new Nim();
			String winner = game.play(initStones, player_one, player_two);
			System.out.println("Game Over\n" + winner + " wins!");
			playAgain = queryPlayAgain();
		}
	}
	// runs until the game is over
	public String play(int stones, Player player_one, Player player_two){
		int currentStones = stones;
		// if false, its player ones turn, otherwise its player twos turn
		boolean playerTwosTurn = false;
		while(currentStones>0) {
			if (playerTwosTurn){
				currentStones = turn(player_two, currentStones);
			}else{				
				currentStones = turn(player_one, currentStones);
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
	private static Integer turn(Player player, int currentStones){
		System.out.println(currentStones + " stones left:" + integerToAsterisk(currentStones));
		return (player.removeStone(currentStones));
	}
	// queries the player for a second game
	private static boolean queryPlayAgain(){
		System.out.println("Do you want to play againt (Y/N):");
		if (!input.next().equals("Y")){
			return false;
		}else{
			return true;
		}
	}
}
