package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.Monster;
import uoa.assignment.character.GameCharacter;


public class Game {
    private Map map;
    
    Game (int height, int width) {
        map=new Map(height,width);
        map.printLayout();
    }
    			
    public Map getMap() {
        return map;
    }
    
    public boolean nextRound (String input) {
        
        
        // Move monster
        for(int i=1; i<map.characters.length; i++){
            GameCharacter monster = map.characters[i];
            if(monster.getHealth()>0){
                GameLogic.moveCharacter(((Monster)monster).decideMove(),map,monster);
            }
        }

        //// Check if monsters are alive and judge if the player win the game
        boolean livingMonster=false;
        for(int i=1; i<map.characters.length; i++){
                GameCharacter monster=map.characters[i];
                if(monster.getHealth()>0){
                    // Updates livingMonster flag if at least one monster is alive
                    livingMonster=true;
                    break;
                }
        }
        // If no living monsters are found
        if(!livingMonster){
            System.out.println("YOU HAVE WON!");
            return true;
        }
        
        // Player's turn
        GameCharacter player=map.characters[0];
        if(player.getHealth()>0){
            GameLogic.moveCharacter(input,map,player);
        }else{
            System.out.println("YOU HAVE DIED!");
            return true;
        }

        //Print the health of player and monsters
        System.out.println();
        System.out.println("Health Player: " + player.getHealth());
        for(int i=1; i<map.characters.length; i++){
            GameCharacter monster = map.characters[i];
            System.out.println("Health Monster" + i + ": " + monster.getHealth());
        }
        return false;
    }
}