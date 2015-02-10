public class TicTacToeRunner
{
	public static void main(String [] args)
	{
		TicTacToeFrame frame = new TicTacToeFrame();
		TicTacToe game = new TicTacToe(frame);

		// while loop to run game
		boolean gameEnd = false;
		while (!gameEnd)
		{
			// check to see if it is X or O's turn
			// when turn number is odd, X goes, when even, O goes
			// X goes first
			if(game.getTurnCounter()%2 == 0)
				game.setUserSymbol('X');
			else
				game.setUserSymbol('O');

			
			System.out.println("Turn counter: " + game.getTurnCounter()); // temporary ÐÊused for debugging
			
			
			// respond to button presses
			game.setUserInput(frame.getButtonPressed()); // check which space was selected and increment turnCounter
			game.incrementTurnCounter(); // increment turn counter
			game.checkAndChange(); // take space in board array
			frame.takeSpace(game.getUserInput(), game.getUserSymbol()); // take space visually
			gameEnd = game.gameEnd(); // check if game is over (win or cat's game)
		}
	}
}