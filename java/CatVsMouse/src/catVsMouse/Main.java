package catVsMouse;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Main  {
	
	public static String sample;
	public static JLabel[][] images = new JLabel[30][30];
	public static PlayingGrid grid = new PlayingGrid();
	public static JFrame gameFrame = new JFrame("Cat Vs. Mouse");
	
	
	
	
	/*********************************************************************************************
	 * MAIN Function
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World!  Here I come!");
		
		// Set up the main frame
		
		
		// Set default action on frame close
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Size
		gameFrame.setSize(1050,1050);
		
		gameFrame.getContentPane().setLayout (new GridLayout(30,30));
		
		gameFrame.addKeyListener(new ArrowKeyListener());
		JPanel panel = new JPanel();
		
		/****************************************************************************
		 * Putting the grid together
		 ****************************************************************************/
		// setup the image icon
		
		sample = "";
		for(int  i = 0; i < 30; i++ ){
			for(int j = 0; j < 30; j++){
			
				sample += grid.spaces[i][j];
				if (grid.spaces[i][j] == 'g')
				{
					ImageIcon icon = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/grass.jpg");
					images[i][j] = new JLabel( icon);
					

					gameFrame.add(images[i][j]);
					
				}
				else if (grid.spaces[i][j] == 'm')
				{
					ImageIcon icon = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/mousedown.JPG");
					images[i][j] = new JLabel(icon);

					gameFrame.add(images[i][j]);
				}
				else if (grid.spaces[i][j] == 'b')
				{
					ImageIcon icon = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/block.JPG");
					images[i][j] = new JLabel(icon);

					gameFrame.add(images[i][j]);
				}
			}
			System.out.println(sample);
			sample = "";
		}	
	

		
		
		

		// A must!
		gameFrame.setVisible(true);
		
		
		
	}
	
	
}
