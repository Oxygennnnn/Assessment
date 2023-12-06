package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	@Override
	public
	void hurtCharacter(GameCharacter character) {
		boolean defencesuccessfully=character.successfulDefense();
        if (!defencesuccessfully){
            int currentHealth=character.getHealth();
            character.setHealth(currentHealth-50);
        }else{
            return;
        }
	}

	@Override
	public
	boolean successfulDefense() {
        Random random=new Random();
        int randomInt=random.nextInt(10);
        if(randomInt<=2){
			return true;
		}else{
			return false;
		}
    }
}
