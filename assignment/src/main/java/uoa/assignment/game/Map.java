package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

public String [][] layout;
public GameCharacter characters [] ;
 
  Map (int height, int width) {
     initialiseArray(height,width);
     characters=new GameCharacter[4];

     characters[0]=new Player("Player");
     characters[1]=new Monster("Monster1");
     characters[2]=new Monster("Monster2");
     characters[3]=new Monster("Monster3");

     characters[3].setRow(0);
     characters[3].setColumn(0);
     characters[2].setRow(height-1);
     characters[2].setColumn(0);
     characters[1].setRow(0);
     characters[1].setColumn(width-1);
     characters[0].setRow(height-1);
     characters[0].setColumn(width-1);
  }

  private void initialiseArray(int height,int width){
    layout=new String[height][width];
    for(int i=0;i<height;i++){
        for(int j=0;j<width;j++){
            layout[i][j]=".";
        }
    }
    layout[0][0]="%";
    layout[0][width-1]="%";
    layout[height-1][0]="%";
    layout[height-1][width-1]="*";
  }


  public void printLayout() {
    for(int i=0;i<layout.length;i++){
        for(int j=0;j<layout[i].length;j++){
           System.out.print(layout[i][j] + " ");
        }
        System.out.println();
    }
   }
}
