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
    public Integer removeStone(int i){
        System.out.println(name + "'s turn - remove how many?");
        return (i -= Nim.input.nextInt());
    }
}