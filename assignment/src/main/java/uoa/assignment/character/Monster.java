package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		super(name);
	}

    @Override
	public void hurtCharacter(GameCharacter character) {
        boolean defendsuccessfully=character.successfulDefense();
        if (!defendsuccessfully){
            int currentHealth=character.getHealth();
            character.setHealth(currentHealth-20);
        }else{
            return;
        }
	}

	@Override
	public boolean successfulDefense() {
		Random random=new Random();
        int randomInt=random.nextInt(2);
		if(randomInt==0) {
			return true;
		} else {
			return false;
		}
	}


	
	public String decideMove () {
		Random random=new Random();
        int randomInt=random.nextInt(4);
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
