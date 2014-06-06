/**
 * Player class
 * Describes a player
 * Has a board 
 * Can 'move'
 * Contains methods to pass board between Player and Game
 * @author amartorajaram
 *
 */
public class Player 
{
	private TicTacToeBoard board;
	
	//describes a human or computer player
	//with the ability to make moves
	//computer player randomly generates a legal move
	//human player makes move
	
	public Player()
	{
		this.board = new TicTacToeBoard();
			
	}
	
	/**
	 * Gets the board from the Game class
	 * @param passedBoard
	 */
	public void getBoard(TicTacToeBoard passedBoard)
	{
		this.board = passedBoard;
	}
	
	/**
	 * Passes the board back to the game class
	 */
	public TicTacToeBoard updateBoard()
	{
		return board;
	}
	
	public void move (int row, int column, char choice)
	{
		if (choice == 'x')
		{
			board.addX(row, column);
		}
		
		if (choice == 'o')
		{
			board.addO(row, column);
		}
	}
}
