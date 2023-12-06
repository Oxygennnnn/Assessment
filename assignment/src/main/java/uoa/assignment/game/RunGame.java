package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {
	
	private static boolean gameOver = false;

	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("Please provide height and width as arguments.");
		}
		int height=Integer.parseInt(args[0]);
		int width=Integer.parseInt(args[1]);
		
        Game game=new Game(height,width);
         
        int round=1;
        while (!gameOver) {
			System.out.println("Round "+round);
            Scanner scanner=new Scanner(System.in);
			String input = scanner.nextLine();
            gameOver=game.nextRound(input);
            round++;
            //print map layout
            game.getMap().printLayout();
		}
	}

}
