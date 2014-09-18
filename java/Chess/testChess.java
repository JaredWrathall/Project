import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 
 */

/**
 * @author Jared
 *
 */
public class testChess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// create the board 
		Board board = new Board();
		// test frame
		JFrame frame = new JFrame();
		
		// frame settings
		frame.setDefaultCloseOperation(3);
		frame.setSize(600,700);
		frame.setLocationRelativeTo(null);
		
		
		frame.add(board);
			
		// Eventuall the board will be on half the screen and the moves list and stats on the other side
		frame.setLayout(new GridLayout(1,1));
		frame.setVisible(true);

	}
	
	

}
