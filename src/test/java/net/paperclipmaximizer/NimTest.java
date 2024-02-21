package net.paperclipmaximizer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * test for Nim game object state
 */

public class NimTest extends Nim{
    //    public static int testUserInput(InputStream in,PrintStream out) {
    //    Scanner keyboard = new Scanner(in);
    //    out.println("Give a number between 1 and 10");
    //    int input = keyboard.nextInt();
//
    //    while (input < 1 || input > 10) {
    //        out.println("Wrong number, try again.");
    //        input = keyboard.nextInt();
    //    }
//
    //    return input;
    //}
    int currentStones;
    Player player_one;
    Player player_two;
    private NimTest game;
    
    @BeforeEach public void setUp() {
        game = new NimTest();
        player_one = new Player("test");
        player_two = new Player("test");
    }

    class Player {
        public String name;
        public Player(String _name){
            this.name = _name;
        }
        public String getName(){ 
            return name;
        }
        public Integer removeStone(int stonesToRemove){
            return (stonesToRemove);
        }
    }
    @Test
    public void testInitialisation() {
        NimTest game = null;
        assertNotNull(game);
    }

    @Test
    public void testChangeTurn() {
        Nim game = new NimTest();
        game.changeTurn();
    }

    @Test
    public void testResetWinCondition() {
        Nim game = new NimTest();
        game.resetWinCondition();
    }

}

