package test.java.net.paperclipmaximizer;

import org.junit.jupiter.api.Test;

import main.java.net.paperclipmaximizer.AIPlayer;

import static org.junit.jupiter.api.Assertions.*;
public class AIPlayerTest {
    
    @Test
    public void testTakeTurn() {
        // Create an AI player
        Player aiPlayer = new AIPlayer();
        
        // Make a move
        assertTrue(aiPlayer.removeStone(10) <= 10);
        assertTrue(aiPlayer.removeStone(10) < 0);
    }
    
}
