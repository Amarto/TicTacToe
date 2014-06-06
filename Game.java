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
				board.printBoard();
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
				board.printBoard();
				System.out.println("");
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
				System.out.println("");
			}
			
			random++;
		}
		
	}
	
	/**
	 * CheckWinner
	 * @return true if there is a winner
	 */
	public boolean isWinner()
	{
	
		
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
		System.out.println("Please enter the row index: ");
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
		System.out.println("Please enter the column index: ");
		int column = in.nextInt();
		
		return column;
	}
	


	

}
