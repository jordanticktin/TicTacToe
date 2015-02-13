/*
 * Runs and manages the Tic-Tac-Toe game.
 * @author Jordan Ticktin, Griffin Cloonan
 */
public class TicTacToeRunner
{
	/*
	 * Runs game.
	 * @param args
	 */
	public static void main(String [] args)
	{
		TicTacToeFrame frame = new TicTacToeFrame();
		TicTacToeGame game = new TicTacToeGame(frame);

		// while loop to run game
		boolean gameEnd = false;
		while (!gameEnd)
		{
			// check to see if it is X or O's turn
			// when turn number is odd, X goes, when even, O goes
			// X goes first
			if(game.getTurnCounter()%2 == 0) {
				game.setUserSymbol('X');
			}
			else {
				game.setUserSymbol('O');
			}
			
			// respond to button presses
			game.setUserInput(frame.getButtonPressed()); // check which space was selected and increment turnCounter
			game.updateBoard(); // take space in board array
			boolean moved = frame.takeSpace(game.getUserInput(), game.getUserSymbol()); // take space visually
			if(moved)  // if someone took their turn, increment turn counter
				game.incrementTurnCounter();
			gameEnd = game.gameEnd(); // check if game is over (win or cat's game)			
		}
	}
}