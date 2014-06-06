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
	
	public void play()
	{ 
		System.out.println("Welcome to Tic Tac Toe! Let's Play! ");
		Scanner in = new Scanner(System.in);
		while (!isWinner)
		{
			int random = (int) (Math.random()*2);
			
			if (random == 0)
			{
				int row = promptRow();
				int column = promptColumn();
				char ch = promptChar();
				
				while (!isLegal(row, column))
				{	
					row = promptRow();
					column = promptColumn();
					ch = promptChar();
				}
				
				humanPlayer.move(row, column, ch);
				board = humanPlayer.updateBoard();				
			}
			
			if (random == 1)
			{
				computerPlayer.getBoard(board);
				int row = (int) (Math.random()*3);
				int column = (int) (Math.random()*3);
				int choicenum = (int) (Math.random()*3);
				char ch = 'o';
				if (choicenum == 0)
				{
					ch = 'x';
				}
				
				computerPlayer.move(row, column, ch);
				board = computerPlayer.updateBoard();
			}
			
		}
		
	}
	
	public boolean checkWinner()
	{
		
		return isWinner;
	}
	
	public boolean isLegal(int row, int column)
	{
		boolean isLegal = true;
		
		if (board.getValue(row, column) != ' ')
		{
			isLegal = false;
		}
		
		return isLegal;
		
	}
	
	public int promptRow()
	{
		System.out.println("Please enter the row index: ");
		int row = in.nextInt();
		
		return row;
		
		
		
	}
	
	public int promptColumn()
	{
		System.out.println("Please enter the column index: ");
		int column = in.nextInt();
		
		return column;
	}
	
	public char promptChar()
	{
		System.out.println("Please enter the character (x or o): ");
		String s = in.nextLine();
		char ch = s.charAt(0);
		return ch;
	}
	

}
