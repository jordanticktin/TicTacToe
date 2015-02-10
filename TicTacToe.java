public class TicTacToe
{
	private char board[][] = new char[3][3]; // the board
	private int userInput; // space taken by player
	private char userSymbol; // symbol of current player
	private int turnCounter; // used to determine whose turn it is
	private TicTacToeFrame frame; // frame to show results in

	// constructor
	public TicTacToe(TicTacToeFrame f)
	{
		frame = f;
		turnCounter = 0;
	}
	
	// checks for valid move and makes change in board accordingly
	public void checkAndChange()
	{
		boolean valid = false; // checks if selection is valid
		int r = 0; // row
		int c = 0; // column

		// check to see if space is occupied, only run while there is not yet a valid result
		// since default button return value is 0, value selection is skipped when game is just starting
		while(!valid && userInput != 0)
		{
			// if userInput is filled, set r and c accordingly
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
			}		

			// check if requested space is blank, notify as valid if it is
			if(board[r][c] == '\0' && valid != true) // \0 = null: checks if space is blank
			{
				board[r][c] = (userSymbol);
				valid = true; // valid space was chosen
			}

			// if no valid space was requested, request a new space
			if(!valid)
			{
				userInput = frame.getButtonPressed();
			}
		}
	}

	// checks to see if game is over
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

	// accessor for userInput 
	public int getUserInput()
	{
		return userInput;
	}
	
	// mutator for userInput
	public void setUserInput(int input)
	{
		userInput = input;
	}
	
	// accessor for userSymbol
	public char getUserSymbol()
	{
		return userSymbol;
	}
	
	// mutator for userSymbol
	public void setUserSymbol(char sym)
	{
		userSymbol = sym;
	}
	
	// accessor for turnCounter
	public int getTurnCounter()
	{
		return turnCounter;
	}
	
	// increments turnCounter
	public void incrementTurnCounter()
	{
		turnCounter++;
	}
}