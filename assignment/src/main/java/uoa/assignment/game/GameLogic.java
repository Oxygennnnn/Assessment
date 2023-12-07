package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map map, GameCharacter character) {
	    switch(input){
            case"up":
                moveUp(character,map);
                break;
            case"down":
                moveDown(character,map);
                break;
            case"left":
                moveLeft(character,map);
                break;
            case"right":
                moveRight(character,map);
                break;
            default:
                System.out.println("Use only keywords up, down, left, right");
                break;
        }	
	}
    private static void moveUp(GameCharacter character,Map map){
        // If the character can move up
        if(character.row>0){
            // If the next position is empty (denoted by ".")
            if(map.layout[character.row-1][character.column].equals(".")){
                //if the current position is player
                if(map.layout[character.row][character.column].equals("*")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row-1][character.column]="*";
                    // Update the character's position after moving up
                    character.setRow(character.row-1);
                    //if the current position is monster
                }else if(map.layout[character.row][character.column].equals("%")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row-1][character.column]="%";
                    // Update the character's position after moving up
                    character.setRow(character.row-1);
                }
            // If the next position is monster (denoted by "%")
            }else if(map.layout[character.row-1][character.column].equals("%")){
                if(map.layout[character.row][character.column].equals("%")){
                    System.out.println("Monster already there so can't move");
                } else if(map.layout[character.row][character.column].equals("*")){
                    // Iterate through characters to find the one to attack
                    for(int i=1;i<map.characters.length;i++){
                        //Identify the monster correspond to the location
                        if (map.characters[i].row==character.row-1 && map.characters[i].column==character.column){
                            character.hurtCharacter(map.characters[i]);
                            if(map.layout[character.row-1][character.column]!="x" && map.characters[i].getHealth()<=0){
                                map.layout[character.row-1][character.column]="x";
                            }
                        }
                    }
                }
            // If the next position is player (denoted by "*")
            }else if(map.layout[character.row-1][character.column].equals("*")) {
                if(map.layout[character.row][character.column].equals("%")){
                    character.hurtCharacter(map.characters[0]);
                } else if(map.layout[character.row][character.column].equals("*")){
                    return;
                }
            // If the next position is dead monster (denoted by "x")
            }else if(map.layout[character.row-1][character.column].equals("x")){
                //consider the situation of the player and monster
                if(map.layout[character.row][character.column].equals("*") || map.layout[character.row][character.column].equals("%")){
                    System.out.println("Character already dead");
                }
            }
        //If the character cannot move up
        }else if(character.row==0){
            System.out.println("You can't go up. You lose a move.");
        }
    }

    private static void moveDown(GameCharacter character,Map map){
        if(character.row<map.layout.length-1){
            if(map.layout[character.row+1][character.column].equals(".")){
                if(map.layout[character.row][character.column].equals("*")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row+1][character.column]="*";
                    character.setRow(character.row+1);
                }else if(map.layout[character.row][character.column].equals("%")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row+1][character.column]="%";
                    character.setRow(character.row+1);
                }
            }else if(map.layout[character.row+1][character.column].equals("%")){
                if(map.layout[character.row][character.column].equals("%")){
                    System.out.println("Monster already there so can't move");
                } else if(map.layout[character.row][character.column].equals("*")){
                    for(int i=1;i<map.characters.length;i++){
                        if (map.characters[i].row==character.row+1 && map.characters[i].column==character.column){
                            character.hurtCharacter(map.characters[i]);
                            if(map.layout[character.row+1][character.column]!="x" && map.characters[i].getHealth()<=0){
                                map.layout[character.row+1][character.column]="x";
                            }
                        }
                    }
                }
            }else if(map.layout[character.row+1][character.column].equals("*")) {
                if(map.layout[character.row][character.column].equals("%")){
                    character.hurtCharacter(map.characters[0]);
                } else if(map.layout[character.row][character.column].equals("*")){
                    return;
                }
            }else if(map.layout[character.row+1][character.column].equals("x")){
                if(map.layout[character.row][character.column].equals("*") || map.layout[character.row][character.column].equals("%")){
                    System.out.println("Character already dead");
                }
            }
        }else if(character.row>=map.layout.length-1){
            System.out.println("You can't go down. You lose a move.");
        }
    }

    private static void moveRight(GameCharacter character,Map map){
        if(character.column<map.layout[0].length-1){
            if(map.layout[character.row][character.column+1].equals(".")){
                if(map.layout[character.row][character.column].equals("*")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row][character.column+1]="*";
                    character.setColumn(character.column+1);
                }else if(map.layout[character.row][character.column].equals("%")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row][character.column+1]="%";
                    character.setColumn(character.column+1);
                }
            }else if(map.layout[character.row][character.column+1].equals("%")){
                if(map.layout[character.row][character.column].equals("%")){
                    System.out.println("Monster already there so can't move");
                } else if(map.layout[character.row][character.column].equals("*")){
                    for(int i=1;i<map.characters.length;i++){
                        if (map.characters[i].row==character.row && map.characters[i].column==character.column+1){
                            character.hurtCharacter(map.characters[i]);
                            if(map.layout[character.row][character.column+1]!="x" && map.characters[i].getHealth()<=0){
                                map.layout[character.row][character.column+1]="x";
                            }
                        }
                    }
                }
            }else if(map.layout[character.row][character.column+1].equals("*")) {
                if(map.layout[character.row][character.column].equals("%")){
                    character.hurtCharacter(map.characters[0]);
                } else if(map.layout[character.row][character.column].equals("*")){
                    return;
                }
            }else if(map.layout[character.row][character.column+1].equals("x")){
                if(map.layout[character.row][character.column].equals("*") || map.layout[character.row][character.column].equals("%")){
                    System.out.println("Character already dead");
                }
            }
        }else if(character.column>=map.layout[0].length-1){
            System.out.println("You can't go right. You lose a move.");
        }
    }

    private static void moveLeft(GameCharacter character,Map map){
        if(character.column>0){
            if(map.layout[character.row][character.column-1].equals(".")){
                if(map.layout[character.row][character.column].equals("*")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row][character.column-1]="*";
                    character.setColumn(character.column-1);
                }else if(map.layout[character.row][character.column].equals("%")){
                    map.layout[character.row][character.column]=".";
                    map.layout[character.row][character.column-1]="%";
                    character.setColumn(character.column-1);
                }
            }else if(map.layout[character.row][character.column-1].equals("%")){
                if(map.layout[character.row][character.column].equals("%")){
                    System.out.println("Monster already there so can't move");
                } else if(map.layout[character.row][character.column].equals("*")){
                    for(int i=1;i<map.characters.length;i++){
                        if (map.characters[i].row==character.row && map.characters[i].column==character.column-1){
                            character.hurtCharacter(map.characters[i]);
                            if(map.layout[character.row][character.column-1]!="x" && map.characters[i].getHealth()<=0){
                                map.layout[character.row][character.column-1]="x";
                            }
                        }
                    }
                }
            }else if(map.layout[character.row][character.column-1].equals("*")) {
                if(map.layout[character.row][character.column].equals("%")){
                    character.hurtCharacter(map.characters[0]);
                } else if(map.layout[character.row][character.column].equals("*")){
                    return;
                }
            }else if(map.layout[character.row][character.column-1].equals("x")){
                if(map.layout[character.row][character.column].equals("*") || map.layout[character.row][character.column].equals("%")){
                    System.out.println("Character already dead");
                }
            }
        }else if(character.column==0){
            System.out.println("You can't go left. You lose a move.");
        }
    }
	
}
