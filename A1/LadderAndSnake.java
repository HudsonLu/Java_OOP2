/**
* Written by: Hudson Xingcheng Lu 40254326
* COMP249
* Assignment # 1
* Due Date Friday 03 February
*/

import java.util.Scanner;

public class LadderAndSnake {

public static int board[][] = new int [10][10]; //Array representing the board of the game.
public static int numberofplayers; 
public static int firststarting;
private int steps = 0; //steps of each player
public static int finalstep = 100; 


/**
 * Default constructor LadderAndSnake() with all the Snakes and Ladders programmed on the board referred by a static int variable.  
 * A default constructor for each player.
 */
	public LadderAndSnake()
	{ 
		
		steps = 0;
		
		//ladder 
		board[0][0] = 1;
		board[0][3] = 4;
		board[0][8] = 9;
		board[2][0] = 21;
		board[2][7] = 28;
		board[3][5] = 36;
		board[5][0] = 51;
		board[7][0] = 71;
		board[7][9] = 80;
		
		//snake
		
		board[1][5] = 16;
		board[7][8] = 79;
		board[9][4] = 95;
		board[4][7] = 48;
		board[6][3] = 64;
		board[9][2] = 93;
		board[9][6] = 97;
		board[9][7] = 98;
	
		
	}
	
	/**
	 * Constructor LadderAndSnake() which initializes the number of players to 2 players.  
	 *  @param int x represents the input of the number of players.
	 */
	
	public LadderAndSnake(int x)
	{ 
		do {
		if (x > 2)
			System.out.println("Initialization was attempted for x member of players; "
					+ "however, this is only expected for an extended version the game. "
					+ "Value will be set to 2.");
		else if (x < 2)
		{
			System.out.println("Error: Cannot execute the game with less than 2 players! Will exit.");
			System.exit(0);
		}
		if (x != 2)
			{
			System.out.print("Prompt the number of players: ");
			Scanner keyboard = new Scanner(System.in);
			x= keyboard.nextInt();
			}
		}
		while (x != 2);		
		numberofplayers = x;
		
    }
	
	/**
	 * Method flipDice() 
	 * @return a number between 1 and 6 like when we roll a dice.
	 */
	
	public int flipDice()
	{
		return (int)(6.0 * Math.random()) + 1; 
		// Math.random() returns a positive double value between 0 and less than 1 
	
	}
	
	/**
	 * Static void method firstplaying(LadderAndSnake player1, LadderAndSnake player2) 
	 * Each player roll the dice using flipDice() method and the one with the highest number starts.
	 * @paramLadderAndSnake player1
	 * @paramLadderAndSnake player2
	 * @return the first player to start.
	 */
	
	public static void firstplaying(LadderAndSnake player1, LadderAndSnake player2)
	{
		int count = 0;
		System.out.println("Now deciding which player will start playing;");
		
		do
		{
		int first = player1.flipDice();
		int second = player2.flipDice();
		System.out.println("Player 1 got a dice value of "+first);
		System.out.println("Player 2 got a dice value of "+second);
			
		if (first < second)
			{
			System.out.println("Reached final decision on order of playing: Player 2 then Player 1. "
					+"\nIt took "+ (count+1) + " attempts before a decision could be made.");
			firststarting = 2;
			break;
			}
		else if (first > second)
			{
			System.out.println("Reached final decision on order of playing: Player 1 then Player 2. "
					+"\nIt took "+ (count+1) + " attempts before a decision could be made.");
			firststarting = 1;
			break;
			}
		else 
			{
			System.out.println("A tie was achieved between Player 1 and Player 2. Attempting to break the tie");
			count ++;
			}
			
		} while (true);
		
	}
	
/**
 * Boolean equals(LadderAndSnake player) method
 * @param LadderAndSnakeplayer
 * @return a boolean result of the comparison between the steps of Player 1 and Player 2.
 */
	public boolean equals(LadderAndSnake player)
	{
		return this.steps ==  player.steps;
	}
	

	
	/**
	 * Static void play(LadderAndSnake player1, LadderAndSnake player2) method
	 * Compass all the game rules.
	 * @paramLadderAndSnake player1
	 * @paramLadderAndSnake player2
	 * @return the winner of the game.
	 */
	public static void play(LadderAndSnake player1, LadderAndSnake player2)
	{
		System.out.println();
		while(player1.steps < 100 && player2.steps < 100)
		{
			int rollplayer1 = 0 ;
			int rollplayer2 = 0 ;
			if (firststarting == 1)	
			{
				
				if (player1.steps < 100 && player2.steps < 100)	
				{
					rollplayer1 = player1.flipDice();
					rollplayer2 = player2.flipDice();
					
					player1.steps += rollplayer1;
					if (player2.equals(player1) && player2.steps !=0 && player1.steps !=0 ) // Special condition
						player1.steps= 0;
					
					if (player1.steps == 100)
					{
						System.out.print("- Player "+ firststarting +" got a dice value of "+ rollplayer1+"; now in square "+ player1.steps + "\n");
						break;
					}
					
					player2.steps += rollplayer2;					
					if (player2.equals(player1) && player2.steps !=0 && player1.steps !=0 ) // Special condition
						player2.steps= 0;	
					
					if ((player1.steps) > 100)
						{
						int difference = (player1.steps)-100;	
						player1.steps = 100 - difference;
						}
						
					if ((player2.steps) > 100)
						{
						int difference = (player2.steps)-100;	
						player2.steps = 100 - difference;
						}
					
					
						
					
					System.out.print("- Player "+ firststarting +" got a dice value of "+ rollplayer1+"; now in square "+ player1.steps + snake(player1) + ladder(player1)+ "\n");
	
					System.out.print("- Player "+ (firststarting+1) +" got a dice value of "+ rollplayer2+"; now in square "+ player2.steps+ snake(player2) + ladder(player2)+ "\n" );
	
				
				}
				if (player1.steps < 100 && player2.steps < 100)
					System.out.print("Game not over; flipping again\n");
				
			}
			else if (firststarting == 2)	
			
			{		
				if (player1.steps < 100 && player2.steps < 100)	
				{
					rollplayer1 = player2.flipDice();
					rollplayer2 = player1.flipDice();
					
						
					player2.steps += rollplayer1;
					if (player2.equals(player1) && player2.steps !=0 && player1.steps !=0 ) // Special condition
						player2.steps= 0;
					
					if (player2.steps == 100)
					{
						
						System.out.print("- Player "+ firststarting +" got a dice value of "+ rollplayer1+"; now in square "+ player2.steps + "\n");
						break;
					}
					player1.steps += rollplayer2;
					if (player2.equals(player1) && player2.steps !=0 && player1.steps !=0 ) // Special condition
						player1.steps= 0;
					
						if ((player2.steps) > 100)
						{
						int difference = (player2.steps)-100;	
						player2.steps = 100- difference;
						}
						
						if ((player1.steps) > 100)
						{
						int difference = (player1.steps)-100;	
						player1.steps = 100- difference;
						}
			
			
				System.out.print("- Player "+ firststarting +" got a dice value of "+ rollplayer1+";"+" now in square "+ player2.steps +  snake(player2) + ladder(player2)+"\n");

				System.out.print("- Player "+ (firststarting-1) +" got a dice value of "+ rollplayer2+"; now in square "+ player1.steps+  snake(player1) + ladder(player1)+"\n");
			
				}
				if (player1.steps < 100 && player2.steps < 100)
					System.out.print("Game not over; flipping again\n");
					
			}
		}
		
		if (player1.steps == 100)
			System.out.println("Player 1 win.");
		else if (player2.steps == 100)
			System.out.println("Player 2 wins.");
	

	}
	/**
	 * static String ladder(LadderAndSnake player) method
	 * @param player
	 * @return a String with the message of the steps of the player after ascending a ladder.
	 */
	public static String ladder(LadderAndSnake player)
	{
		
		if (player.steps  == board[0][0])
		{
			board[3][7] = 38;
			player.steps = board[0][7];
			return " then up to square 38";
		}
		
		else if (player.steps  == board[0][3])
		{
			board[1][3] = 14;
			player.steps = board[1][3];
			return " then up to square 14";
		}
		
		else if (player.steps  == board[0][8])
		{
			board[3][0] = 31;
			player.steps = board[3][0];
			return " then up to square 31";
		}
		
		else if (player.steps  == board[2][0])
		{
			board[4][1] = 42;
			player.steps = board[3][0];
			return " then up to square 42";
		}
		
		else if (player.steps  == board[2][7])
		{
			board[8][3] = 84;
			player.steps = board[8][3];
			return " then up to square 84";
		}
		
		else if (player.steps  == board[3][5])
		{
			board[4][3] = 44;
			player.steps = board[4][3];
			return " then up to square 44";
		}
		
		else if (player.steps  == board[5][0])
		{
			board[6][6] = 67;
			player.steps = board[6][6];
			return " then up to square 67";
		}
		
		else if (player.steps  == board[7][0])
		{
			board[9][0] = 91;
			player.steps = board[9][0];
			return " then up to square 91";
		}
		else if (player.steps  == board[7][9])
		{
			board[9][9] = 100;
			player.steps = board[9][0];
			return " then up to square 100";
		}
		else
		{return "";}

		
	}
	
	/**
	 * static String snake(LadderAndSnake player) method
	 * @param player
	 * @return a String with the message of the steps of the player after descending a snake.
	 */
	public static String snake(LadderAndSnake player)
	{
		
		//snake
		 if (player.steps  == board[1][5])	 
		 {
			 	board[0][5] = 6;
				player.steps = board[0][5];
				return " then down to square 6";
				
		 }
		 
		 else if (player.steps  == board[7][8])	 
		 {
			 	board[1][8] = 19;
				player.steps = board[1][8];
				return " then down to square 19";
				
		 }
		 else if (player.steps  == board[9][4])	 
		 {
			 	board[2][3] = 24;
				player.steps = board[2][3];
				return " then down to square 24";
				
		 }
		 
		 else if (player.steps  == board[4][7])	 
		 {
			 	board[2][9] = 30;
				player.steps = board[2][9];
				return " then down to square 30";
				
		 }
		 else if (player.steps  == board[6][3])	 
		 {
			 board[5][9] = 60;
				player.steps = board[5][9];
				return " then down to square 60";
				
		 }
		 else if (player.steps  == board[9][2])	 
		 {
			 board[6][7] = 68;
				player.steps = board[6][7];
				return " then down to square 68";
				
		 }
		 else if (player.steps  == board[9][6])	 
		 {
			 board[7][5] = 76;
				player.steps = board[7][5];
				return " then down to square 76";
				
		 }
		 else if (player.steps  == board[9][7])	 
		 {
			 board[7][7] = 78;
				player.steps = board[7][7];
				return " then down to square 78";
				
		 }
		 else
			{return "";}

	}
	
	
	
	
	
	
	
}
