package net.paperclipmaximizer;

import java.util.Scanner;

/**
 * Abstract class for game objects to inherit from
 * it defers all of its method implementations to the child class
 */
abstract class Game {
    String winner;
    public String getWinner() {
        return winner;
    }
    // runs the game loop
    public final void gameloop(){
        initialiseGame();
        while (!endOfGame()){
            changeTurn();
            nextMove();
        }
    }

    protected abstract void initialiseGame();
    protected abstract void nextMove();
    protected abstract boolean endOfGame();
    protected abstract void changeTurn();    
}
