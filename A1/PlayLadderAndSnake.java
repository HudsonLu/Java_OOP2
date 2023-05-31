/**
* Written by: Hudson Xingcheng Lu 40254326
* COMP249
* Assignment # 1
* Due Date Friday 03 February
*/

import java.util.Scanner;

public class PlayLadderAndSnake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Rules();	
		Scanner keyboard = new Scanner(System.in);
		int x = keyboard.nextInt(); // Input the number of players
		LadderAndSnake y = new LadderAndSnake(x);
		
		LadderAndSnake player1 = new LadderAndSnake();
		LadderAndSnake player2 = new LadderAndSnake();

		LadderAndSnake.firstplaying(player1, player2); // Decide who is the first to start
		System.out.print("\nPrompt '1' to start the game: ");
		
		int z = keyboard.nextInt();
		// Start the game by prompting the user '1'
		do
		{
			if (z == 1)	
				break;
				
			else 
				{
				System.out.print("You did not enter '1'. Please Prompt '1' to start the game: ");
				z = keyboard.nextInt();
				}
		} while (z != 1);
		
		LadderAndSnake.play(player1, player2); // Start the game
	}
	
	
	/**
	 * Welcome game method
	 */
	
	public static void Rules(){

		System.out.println("Welcome to Snakes and Ladders game! It is played only by 2 players.\n");
		System.out.print("Prompt the number of players: ");

	}

	
/**	
Bottom of a ladder, then the player moves up to the square that has the 
top of the ladder. 

Ladders:
* (1, 38)
* (4, 14)
* (9, 31)
* (21, 42)
* (28, 84)
* (36, 44)
* (51, 67)
* (71, 91)
* (80, 100)

Head of a snake, then the player moves down the square that has the tail of the snake. 
Snakes:
* (16, 6)
* (79, 19)
* (95, 24)
* (48, 30)
* (64, 60)
* (93, 68)
* (97, 76)
* (98, 78) 
Special Condition: If one player is in the same case as the second player then the player in the case before goes to down to 0: the beginning line.
*/
}

