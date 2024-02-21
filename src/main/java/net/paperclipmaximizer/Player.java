package net.paperclipmaximizer;

public class Player {
    /**
     * Player(String name)
     * initializes a player with an encapsulated name field
     * exposes hidden field with setter and getter methods
     */
    private String name;
    public Player(String _name){
        this.name = _name;
    }
//    private Integer score; // can't remember if this is required
    public String getName(){ 
        return name;
    }
    public void setName(String newName) {
	    this.name = newName;
    }
    /**
     * This method returns the number of stones the player wants to remove in their turn
     * use stones to check if the move is legal
     */
    public Integer removeStone(int upperBounds){
        System.out.println(name + "'s turn - remove how many?");
        int stonesToRemove = Nim.input.nextInt();
        if (stonesToRemove > upperBounds){
            stonesToRemove = upperBounds;
            System.out.println("You must remove at most respect the upperbounds.\nDefaulting to " + upperBounds + " stones removed");
        }else if (stonesToRemove < 1){
            stonesToRemove = 1;
            System.out.println("You must remove at least one stone\nDefaulting to 1 stones removed");
        }
        return (stonesToRemove);
    }
}