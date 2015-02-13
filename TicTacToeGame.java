/*
 * Manages the board and calculations for the back end.
 * @author Jordan Ticktin, Griffin Cloonan
 */
public class TicTacToeGame
{
	private char board[][]; // the board
	private int userInput; // space taken by player
	private char userSymbol; // symbol of current player
	private int turnCounter; // used to determine whose turn it is
	private TicTacToeFrame frame; // frame to show results in

	/*
	 * Constructor. Initializes frame, board, and turnCounter.
	 * @param f TicTacToeFrame used by GUI
	 */
	public TicTacToeGame(TicTacToeFrame f)
	{
		frame = f;
		board = new char[3][3];
		turnCounter = 0;
	}
	
	/*
	 * Updates board array with moves.
	 */
	public void updateBoard()
	{
		int r; // row
		int c; // column
		switch(userInput)
		{
			case 1:
				r = 2;
				c = 0;
				break;
			case 2:
				r = 2;
				c = 1;
				break;
			case 3:
				r = 2;
				c = 2;
				break;
			case 4:
				r = 1;
				c = 0;
				break;
			case 5:
				r = 1;
				c = 1;
				break;
			case 6:
				r = 1;
				c = 2;
				break;
			case 7:
				r = 0;
				c = 0;
				break;
			case 8:
				r = 0;
				c = 1;
				break;
			case 9:
				r = 0;
				c = 2;
				break;
			default:
				return;
		}		

		// check if requested space is blank, notify as valid if it is
		if(board[r][c] == '\0' ) // \0 = null: checks if space is blank
		{
			board[r][c] = (userSymbol);
		}
	}

	/*
	 * Checks to see if game is over.
	 * @return whether the game is over
	 */
	public boolean gameEnd()
	{
		// check for win, and if applicable check who won
		if(board[0][0] == userSymbol && board[0][1] == userSymbol && board[0][2] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[1][0] == userSymbol && board[1][1] == userSymbol && board[1][2] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[2][0] == userSymbol && board[2][1] == userSymbol && board[2][2] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[0][0] == userSymbol && board[1][0] == userSymbol && board[2][0] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[0][1] == userSymbol && board[1][1] == userSymbol && board[2][1] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[0][2] == userSymbol && board[1][2] == userSymbol && board[2][2] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[0][0] == userSymbol && board[1][1] == userSymbol && board[2][2] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else if(board[0][2] == userSymbol && board[1][1] == userSymbol && board[2][0] == userSymbol)
		{
			frame.endMessage("Congratulations, player " +userSymbol+ ", you won the game!");
			return true;
		}
		else // check for cat's game
		{
			// checks if any open spaces are left on the board
			int counter = 0; // will be incremented if any spaces are left to play
			for (int t = 0; t < 3; t++)
			{
				for (int i = 0; i < 3; i++)
				{
					if(board[t][i] == '\0')
						counter++;
				}
			}

			// if there are no more open spaces on board, end with Cat's Game
			if(counter == 0)
			{	
				frame.endMessage("Cat's Game :(");
				return true;
			}
		}
		
		return false; // only returns false if game is not yet over
	}

	/*
	 * Returns value of userInput.
	 * @return userInput 
	 */
	public int getUserInput()
	{
		return userInput;
	}
	
	/*
	 * Sets new value for userInput.
	 * @param input new value for userInput
	 */
	public void setUserInput(int input)
	{
		userInput = input;
	}
	
	/*
	 * Returns value of userSymbol.
	 * @return userSymbol
	 */
	public char getUserSymbol()
	{
		return userSymbol;
	}
	
	/*
	 * Sets new value for userSymbol.
	 * @param sym new value for userSymbol
	 */
	public void setUserSymbol(char sym)
	{
		userSymbol = sym;
	}
	
	/*
	 * Returns value of turnCounter.
	 * @return turnCounter
	 */
	public int getTurnCounter()
	{
		return turnCounter;
	}
	
	/*
	 * Increments turnCounter.
	 */
	public void incrementTurnCounter()
	{
		turnCounter++;
	}
	
	/*
	 * Prints out currents values in board to console for debugging purposes.
	 */
	public void printBoard()
	{
		System.out.println("Current board: ");
		for (int t = 0; t < 3; t++)
		{
			for (int i = 0; i < 3; i++)
			{
				if(board[t][i] == '\0')
					System.out.print("-");
				else
					System.out.print(board[t][i]);
			}
			System.out.println();
		}
		
		System.out.println();
	}
}