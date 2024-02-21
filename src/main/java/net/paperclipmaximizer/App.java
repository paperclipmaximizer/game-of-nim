package net.paperclipmaximizer;

/**
 * Hello world!
 *
 */
public class App 
{
	//boolean playAgain = true;
	// main method
	public static void main(String[] args){
		Nim game = new Nim();
		game.loop(); 
			//String winner = game.getWinner();
			//System.out.println("Game Over\n" + winner + " wins!");
			//playAgain = queryPlayAgain();
		//}
	}

}
