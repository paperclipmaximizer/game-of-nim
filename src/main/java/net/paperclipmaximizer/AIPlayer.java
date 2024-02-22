package net.paperclipmaximizer;

public class AIPlayer extends Player{
    public AIPlayer(){
        super("AI" + (int)(Math.random() * 1000));
    }
    @Override
    public Integer removeStone(int upperBounds){
    System.out.println(name + "'s turn - remove how many?");
    int stonesToRemove = Math.clamp(0,(int)(Math.random() * (upperBounds + 1)),upperBounds);
    // Make it look like a non-ai turn
    System.out.println(stonesToRemove);
    return (stonesToRemove);
    }
}