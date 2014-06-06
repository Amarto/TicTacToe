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
	//describes a Game with a board and two players
	//judges whether a move is legal
	
	public Game()
	{
		humanPlayer = new Player();
		computerPlayer = new Player();
		board = new TicTacToeBoard();
		isWinner = false;
		
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
				humanPlayer.getBoard(board);
				board.printBoard();
				System.out.println("Please enter the row index: ");
				int row = in.nextInt();
				System.out.println("Please enter the column index: ");
				int column = in.nextInt();
				System.out.println("Please enter the character (x or o): ");
				String s = in.nextLine();
				char ch = s.charAt(0);
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
	

}
