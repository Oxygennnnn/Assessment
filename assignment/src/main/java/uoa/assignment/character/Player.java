package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		super(name);
	}

	@Override
    // Overrides the abstract method in GameCharacter class
	public void hurtCharacter(GameCharacter character) {
		boolean defencesuccessfully=character.successfulDefense();
        if (!defencesuccessfully){
            int currentHealth=character.getHealth();
            character.setHealth(currentHealth-50);
            System.out.println("!!HIT!! Player successfully attacked " + character.sayName());
        }else{
            System.out.println("!!MISS!!" + character.sayName() + "successfully defended attack from Player");
            return;
        }
	}

	@Override
    // Overrides the successfulDefense() method
	public boolean successfulDefense() {
        Random random=new Random();
        //Randomly generate an integer ranging from 0 to 9. Three of them have 30% chance to be picked.
        int randomInt=random.nextInt(10);
        if(randomInt<=2){
			return true;
		}else{
			return false;
		}
    }
}
