import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeFrame extends JFrame implements ActionListener
{
	JPanel pane = new JPanel(); // create pane object
	JButton buttonPressed = new JButton();
	
	// 9 buttons for the playing spots
	JButton TL = new JButton("");
	JButton TM = new JButton("");
	JButton TR = new JButton("");
	JButton ML = new JButton("");
	JButton MM = new JButton("");
	JButton MR = new JButton("");
	JButton BL = new JButton("");
	JButton BM = new JButton("");
	JButton BR = new JButton("");

	TicTacToeFrame()   // the constructor
	{
		setBounds(100,100,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane(); // inherit main frame
		con.add(pane);
		
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
	}
	
	// basic event handler
	public void actionPerformed(ActionEvent event)
	{
		buttonPressed = (JButton) event.getSource();
	}
	
	// override equals method for JButtons
	public boolean equals(JButton button)
	{
		boolean areEqual = false;
		
		if(button instanceof JButton)
		{
			areEqual = (this.getX()==button.getX());
			areEqual = (this.getY()==button.getY());
		}
		
		return areEqual;
	}
	
	// return which button was pressed as an int value
	public int getButtonPressed()
	{
		if(buttonPressed.equals(TL))
			return 7;
		else if(buttonPressed.equals(TM))
			return 8;
		else if(buttonPressed.equals(TR))
			return 9;
		else if(buttonPressed.equals(ML))
			return 4;
		else if(buttonPressed.equals(MM))
			return 5;
		else if(buttonPressed.equals(MR))
			return 6;
		else if(buttonPressed.equals(BL))
			return 1;
		else if(buttonPressed.equals(BM))
			return 2;
		else if(buttonPressed.equals(BR))
			return 3;
		else
			return 0;
	}
	
	// shows end message if game is over
	public void endMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.PLAIN_MESSAGE);
		setVisible(true);
	}
	
	public boolean takeSpace(int button, char player)
	{
		boolean moved = false;
		
		if(button == 7 && TL.isEnabled()) {
			TL.setText("" + player);
			TL.setEnabled(false);
			moved = true;
		}
		else if(button == 8 && TM.isEnabled()) {
			TM.setText("" + player);
			TM.setEnabled(false);
			moved = true;
		}
		else if(button == 9 && TR.isEnabled()) {
			TR.setText("" + player);
			TR.setEnabled(false);
			moved = true;
		}
		else if(button == 4 && ML.isEnabled()) {
			ML.setText("" + player);
			ML.setEnabled(false);
			moved = true;
		}
		else if(button == 5 && MM.isEnabled()) {
			MM.setText("" + player);
			MM.setEnabled(false);
			moved = true;
		}
		else if(button == 6 && MR.isEnabled()) {
			MR.setText("" + player);
			MR.setEnabled(false);
			moved = true;
		}
		else if(button == 1 && BL.isEnabled()) {
			BL.setText("" + player);
			BL.setEnabled(false);
			moved = true;
		}
		else if(button == 2 && BM.isEnabled()) {
			BM.setText("" + player);
			BM.setEnabled(false);
			moved = true;
		}
		else if(button == 3 && BR.isEnabled()) {
			BR.setText("" + player);
			BR.setEnabled(false);
			moved = true;
		}
		
		return moved;
	}
}