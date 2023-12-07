package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	// Creates a private integer variable 'health' and initializes it to 100
	private int health=100; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
        // Assigns the passed parameter to the instance variable 'name'
		this.name=name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
        // Method that returns the 'name' instance variable
		return name; 
	}

	public int getHealth() {
        // Method to get the value of 'health'
		return health;
	}

	public void setHealth(int health) {
        // Method to set the value of 'health'
		this.health=health;
	}

	public void setRow(int row){
        // Method to set the value of 'row', accepting an integer parameter
        this.row=row;
    }
    public void setColumn(int column){
        // Method to set the value of 'column', accepting an integer parameter
        this.column=column;
    }
    public int getRow(){
        // Method to get the value of 'row'
        return row;
    }
    public int getColumn(){
        // Method to get the value of 'column'
        return column;
    }
}


 
