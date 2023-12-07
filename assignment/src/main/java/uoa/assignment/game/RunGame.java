package uoa.assignment.game;

import java.util.Scanner;

public class RunGame {
	
	private static boolean gameOver = false;

	public static void main(String[] args) {
        // Check if height and width are provided as arguments
		if(args.length!=2){
			System.out.println("Please provide height and width as arguments.");
		}
        //Get the height and width
		int height=Integer.parseInt(args[0]);
		int width=Integer.parseInt(args[1]);
		
        Game game=new Game(height,width);
         
        int round=1;
        // Main game loop - continue until the game is over
        while (!gameOver) {
			System.out.println("Round "+round);
            Scanner scanner=new Scanner(System.in);
			String input = scanner.nextLine();
            // Execute the next round and check if the game is over
            gameOver=game.nextRound(input);
            round++;
            // Print the current map layout after each round
            game.getMap().printLayout();
		}
	}

}
