/**
 * Game class
 * Describes a game that has a human and a computer player
 * a board
 * Contains play method which plays the game
 * @author amartorajaram
 */
import java.util.Scanner;
public class Game 
{

	private Player humanPlayer;
	private Player computerPlayer;
	private TicTacToeBoard board;
	private boolean isWinner;
	Scanner in;
	
	public Game()
	{
		humanPlayer = new Player();
		computerPlayer = new Player();
		board = new TicTacToeBoard();
		isWinner = false;
		in = new Scanner(System.in);		
	}
	
	/**
	 * Play method. Plays the game
	 * Generates a random number to decide who goes first
	 */
	public void play()
	{ 
		System.out.println("Welcome to Tic Tac Toe! Let's Play! ");
		System.out.println("You are player x");
		int random = (int) (Math.random()*2);
		board.printBoard();
		System.out.println("");
		while (!isWinner)
		{
			
			if (random %2 == 0)
			{
				humanPlayer.getBoard(board);
				if (random != 0)
				{
					board.printBoard();
				}
				System.out.println("");
				int row = promptRow();
				int column = promptColumn();

				
				while (!isLegal(row, column))
				{	
					row = promptRow();
					column = promptColumn();

				}
				
				humanPlayer.move(row, column, 'x');
				board = humanPlayer.updateBoard();
				checkWinner();
				board.printBoard();
				System.out.println("");
				if (isWinner)
				{
					System.out.println("You win!");
				}
			}
			
			if (random % 2 == 1)
			{
				computerPlayer.getBoard(board);
				int row = (int) (Math.random()*3);
				int column = (int) (Math.random()*3);

				char ch = 'o';
				
				while (!isLegal(row, column))
				{
					row = (int) (Math.random()*3);
					column = (int) (Math.random()*3);
				}
				
				computerPlayer.move(row, column, ch);
				board = computerPlayer.updateBoard();
				board.printBoard();
				checkWinner();
				System.out.println("");
				if (isWinner)
				{
					System.out.println("You lose!");
				}
			}
			
			random++;
		}
		
	}
	
	/**
	 * CheckWinner
	 * @return true if there is a winner
	 */
	public boolean checkWinner()
	{

		for (int i = 0; i < 3; i++)
		{
		int j = 0;
					
			if (board.getValue(i, j) == board.getValue(i, j+1) && 
				board.getValue(i, j+1) == board.getValue(i, j+2)
				&& board.getValue(i,j) != '/') 
			{
				isWinner = true;
			}
		}	
		for (int j = 0; j < 3; j++)
		{
		int i = 0;
						
				if (board.getValue(i, j) == board.getValue(i+1, j) && 
					board.getValue(i+1, j) == board.getValue(i+2, j) 
					&& board.getValue(i,j) != '/')  
				{
					isWinner = true;
				}
		
		if (board.getValue(0,0) == board.getValue(1,1) && 
				board.getValue(1,1) == board.getValue(2,2) 	
				&& board.getValue(i,j) != '/') 
		{
			isWinner = true;
		}
		
		if (board.getValue(0,2) == board.getValue(1,1) && 
				board.getValue(1,1) == board.getValue(2,0) 
				&& board.getValue(i,j) != '/') 
		{
			isWinner = true;
		}
		
			
			
		}

		
	
		
		return isWinner;
	}
	
	public boolean isLegal(int row, int column)
	{
		boolean isLegal = true;
		
		if (board.getValue(row, column) != '/')
		{
			isLegal = false;
		}
		
		return isLegal;
		
	}
	
	/**
	 * PromptRow
	 * Prompts the user for input as to the row index
	 * @return row index
	 */
	public int promptRow()
	{
		System.out.println("Please enter the row index: (0-2) ");
		int row = in.nextInt();
		
		return row;
				
	}
	
	/**
	 * PromptColumn
	 * Prompts user for column index
	 * @return column index
	 */
	public int promptColumn()
	{
		System.out.println("Please enter the column index: (0-2) ");
		int column = in.nextInt();
		
		return column;
	}
	


	

}
