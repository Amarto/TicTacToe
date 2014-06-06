
public class TicTacToeBoard 
{
	private char[][] tictactoeboard;
	/**
	 * 
	 */
	public TicTacToeBoard()
	{
		tictactoeboard = new char[3][3];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				tictactoeboard[i][j] = ' ';
			}
		}	
	}
	
	/**
	 * adds an x at the given indices
	 * @param i the row
	 * @param j the column
	 */
	public void addX(int i, int j)
	{
		tictactoeboard[i][j] = 'x';
	}
	
	/**
	 * Adds an o at the given indices
	 * @param i
	 * @param j
	 */
	public void addO(int i, int j)
	{
		tictactoeboard[i][j] = 'o';
	}
	
	/**
	 * Returns the value of the board at given index
	 * @param i row index
	 * @param j column index
	 * @return The char at that index
	 */
	public char getValue(int i, int j)
	{
		return tictactoeboard[i][j];
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard()
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(tictactoeboard[i][j] + "");
			}
			System.out.println("");
		}
	}
//stores a 3x3 array of char values
//filled with 'x' 'o' or space characters
}
