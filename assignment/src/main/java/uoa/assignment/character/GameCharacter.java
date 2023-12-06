package uoa.assignment.character;

public abstract class GameCharacter {
    
	private String name ="";
	
	private int health=100; 
	
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		this.name=name;
	}
	
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	
	public String sayName() {
		return name; 
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health=health;
	}

	public void setRow(int row){
        this.row=row;
    }
    public void setColumn(int column){
        this.column=column;
    }
    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}


 
