/*
 * Manages the game GUI.
 * @author Jordan Ticktin, Griffin Cloonan
 */

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeFrame extends JFrame implements ActionListener
{
	JPanel pane;
	JButton buttonPressed;
	
	// 9 buttons for the playing spots
	JButton TL;
	JButton TM;
	JButton TR;
	JButton ML;
	JButton MM;
	JButton MR;
	JButton BL;
	JButton BM;
	JButton BR;

	/*
	 * Constructor. Creates window. Initializes pane, buttonPressed, and all the buttons.
	 * Register button listeners. Adds buttons to pane. Makes frame visible.
	 * Puts focus on center button. Sets up hotkeys for buttons.
	 */
	TicTacToeFrame()   // the constructor
	{
		pane = new JPanel(); // create pane object
		buttonPressed = new JButton(); // create 
		
		setBounds(100,100,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane(); // inherit main frame
		con.add(pane);
		
		// initialize button objects
		TL = new JButton("");
		TM = new JButton("");
		TR = new JButton("");
		ML = new JButton("");
		MM = new JButton("");
		MR = new JButton("");
		BL = new JButton("");
		BM = new JButton("");
		BR = new JButton("");
		
		// register button listener
		TL.addActionListener(this);
		TM.addActionListener(this);
		TR.addActionListener(this);
		ML.addActionListener(this);
		MM.addActionListener(this);
		MR.addActionListener(this);
		BL.addActionListener(this);
		BM.addActionListener(this);
		BR.addActionListener(this);
		
		// add buttons to pane
		pane.add(TL);
		pane.add(TM);
		pane.add(TR);
		pane.add(ML);
		pane.add(MM);
		pane.add(MR);
		pane.add(BL);
		pane.add(BM);
		pane.add(BR);
		
		setVisible(true); // make frame visible
		
		MM.requestFocusInWindow(); // highlights MM button by default
		
		TL.setMnemonic(KeyEvent.VK_7);
		TM.setMnemonic(KeyEvent.VK_8);
		TR.setMnemonic(KeyEvent.VK_9);
		ML.setMnemonic(KeyEvent.VK_4);
		MM.setMnemonic(KeyEvent.VK_5);
		MR.setMnemonic(KeyEvent.VK_5);
		BL.setMnemonic(KeyEvent.VK_1);
		BM.setMnemonic(KeyEvent.VK_2);
		BR.setMnemonic(KeyEvent.VK_3);
	}
	
	/*
	 * Basic event handler.
	 * @param event the ActionEvent
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event)
	{
		buttonPressed = (JButton) event.getSource();
	}
	
	/*
	 * Override equals method for comparing JButtons.
	 * @param button JButton to compare object to
	 */
	public boolean equals(JButton button)
	{
		boolean areEqualX = (this.getX()==button.getX());
		boolean areEqualY = (this.getY()==button.getY());

		return areEqualX && areEqualY;
	}
	
	/*
	 * Return which button was pressed as an int value.
	 * @return which button was pressed
	 */
	public int getButtonPressed()
	{
		if(buttonPressed.equals(TL))
		{
			return 7;
		}
		else if(buttonPressed.equals(TM))
		{
			return 8;
		}
		else if(buttonPressed.equals(TR))
		{
			return 9;
		}
		else if(buttonPressed.equals(ML))
		{
			return 4;
		}
		else if(buttonPressed.equals(MM))
		{
			return 5;
		}
		else if(buttonPressed.equals(MR))
		{
			return 6;
		}
		else if(buttonPressed.equals(BL))
		{
			return 1;
		}
		else if(buttonPressed.equals(BM))
		{
			return 2;
		}
		else if(buttonPressed.equals(BR))
		{
			return 3;
		}
		else
		{
			return 0;
		}
	}
	
	/*
	 * Sets label to userSymbol and deactivates button for taken space on GUI board.
	 * @param button the button pressed by user
	 * @param player current player's symbol
	 * @return whether a spot was taken
	 */
	public boolean takeSpace(int button, char player)
	{
		boolean moved = false;
		
		if(button == 7 && TL.isEnabled())
		{
			TL.setText("" + player);
			TL.setEnabled(false);
			moved = true;
		}
		else if(button == 8 && TM.isEnabled())
		{
			TM.setText("" + player);
			TM.setEnabled(false);
			moved = true;
		}
		else if(button == 9 && TR.isEnabled())
		{
			TR.setText("" + player);
			TR.setEnabled(false);
			moved = true;
		}
		else if(button == 4 && ML.isEnabled())
		{
			ML.setText("" + player);
			ML.setEnabled(false);
			moved = true;
		}
		else if(button == 5 && MM.isEnabled())
		{
			MM.setText("" + player);
			MM.setEnabled(false);
			moved = true;
		}
		else if(button == 6 && MR.isEnabled())
		{
			MR.setText("" + player);
			MR.setEnabled(false);
			moved = true;
		}
		else if(button == 1 && BL.isEnabled())
		{
			BL.setText("" + player);
			BL.setEnabled(false);
			moved = true;
		}
		else if(button == 2 && BM.isEnabled())
		{
			BM.setText("" + player);
			BM.setEnabled(false);
			moved = true;
		}
		else if(button == 3 && BR.isEnabled())
		{
			BR.setText("" + player);
			BR.setEnabled(false);
			moved = true;
		}
		
		return moved;
	}
	
	/*
	 * Shows end message if game is over.
	 * @param message message to show
	 */
	public void endMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.PLAIN_MESSAGE);
		setVisible(true);
	}
}