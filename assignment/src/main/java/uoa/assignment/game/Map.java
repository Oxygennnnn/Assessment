package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {
//creat an attribute which contains an 2D array that represents the game map.
public String [][] layout;
//creat an array of GameCharacter objects representing the players and monsters in the game.
public GameCharacter characters [] ;
 
  Map (int height, int width) {
     initialiseArray(height,width);
     characters=new GameCharacter[4];

     // Initialize characters
     characters[0]=new Player("Player");
     characters[1]=new Monster("Monster1");
     characters[2]=new Monster("Monster2");
     characters[3]=new Monster("Monster3");

     // Set initial positions for each character
     characters[3].setRow(0);
     characters[3].setColumn(0);
     characters[2].setRow(height-1);
     characters[2].setColumn(0);
     characters[1].setRow(0);
     characters[1].setColumn(width-1);
     characters[0].setRow(height-1);
     characters[0].setColumn(width-1);
  }
  // Method to initialize the map layout
  private void initialiseArray(int height,int width){
    layout=new String[height][width];
    for(int i=0;i<height;i++){
        for(int j=0;j<width;j++){
            layout[i][j]=".";
        }
    }
    // Set specific positions as "%" and "*" to represent player and monster initial positions
    layout[0][0]="%";
    layout[0][width-1]="%";
    layout[height-1][0]="%";
    layout[height-1][width-1]="*";
  }

  // The method that prints the current state of the map by iterating through the layout array and displaying the characters.
  public void printLayout() {
    for(int i=0;i<layout.length;i++){
        for(int j=0;j<layout[i].length;j++){
           System.out.print(layout[i][j] + " ");
        }
        System.out.println();
    }
   }
}
