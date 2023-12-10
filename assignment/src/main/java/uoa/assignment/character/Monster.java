package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}

    @Override
    // Overrides the abstract method in GameCharacter class
	public void hurtCharacter(GameCharacter character) {
        boolean defendsuccessfully=character.successfulDefense();
        //Defines the fails and damage were done to the character
        if (!defendsuccessfully){
            int currentHealth=character.getHealth();
            character.setHealth(currentHealth-20);
            System.out.println("!!HIT!! Monster successfully attacked Player");
        }else{
            System.out.println("!!MISS!! Player successfully defended attack from Monster");
            return ;
        }
	}

	@Override
    // Overrides the successfulDefense() method
	public boolean successfulDefense() {
		Random random=new Random();
        //Randomly generate an integer ranging from 0 to 1. Each of them has 50% chance to be picked.
        int randomInt=random.nextInt(2);
		if(randomInt==0) {
			return true;
		} else {
			return false;
		}
	}


	// Method to decide the monster's move
	public String decideMove () {
		Random random=new Random();
        //Randomly generate an integer ranging from 0 to 3. Each of them has 25% chance to be picked.
        int randomInt=random.nextInt(4);
        //Decides the directions to move according to the random integers
        if(randomInt==0){
            return "up";
        }else if(randomInt==1){
            return "down";
        }else if(randomInt==2){
            return "left";
        }else{
            return "right";
        }
	}

}
