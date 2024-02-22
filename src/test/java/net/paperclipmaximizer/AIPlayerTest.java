package net.paperclipmaximizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AIPlayerTest {
    
    @Test
    void testTakeTurn() {
        // Create an AI player
        Player aiPlayer = new AIPlayer();
        
        // Make a move
        assertTrue(aiPlayer.removeStone(10) <= 10);
        assertTrue(aiPlayer.removeStone(10) < 0);
    }
    
}
