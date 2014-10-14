package catVsMouse;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ArrowKeyListener implements KeyListener {
	
	public static Icon mouseDown = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/mousedown.JPG");
	public static Icon mouseLeft = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/mouseleft.JPG");
	public static Icon mouseRight = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/mouseright.JPG");
	public static Icon mouseUp = new ImageIcon("C:/Users/Jared/workspace/catVsMouse/mouseup.JPG");
	
	public void keyPressed(KeyEvent e) {
		
		// initialize the swapping icon
		Icon tempIcon = new ImageIcon();
		

		
		// initialize the swapping char in the logical mapping
		char tempChar = '!';
		
		// save coordinates on the grid
		int x = 0;
		int y = 0;
		
		//find the mouse!
		for(int  i = 0; i < 30; i++ ){
			for(int j = 0; j < 30; j++){
			
			if (Main.grid.spaces[i][j] == 'm')
			{
				x = j;
				y = i;
			}
			}
		}
		
		
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up 
	        	System.out.println("UP");
	        	// set the icon for swap
	        	System.out.println("DOWN");
	        	
	        	// set the char for logical swap
	        	tempChar = Main.grid.spaces[y - 1][x];
	        	
	        	
	        	// fix logical board
	        	
	        	// move mouse logical
	        	Main.grid.spaces[y - 1][x] = Main.grid.spaces[y][x];
	        	
	        	// move etc
	        	Main.grid.spaces[y][x]= tempChar;
	        	
	        	// move icons
	        	
	        	// move etc
	        	Main.images[y][x].setIcon(Main.images[y - 1][x].getIcon()); 
	        	
	        	// move mouse 
	        	Main.images[y - 1][x].setIcon(mouseUp); 
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 	        	
	        	System.out.println("DOWN");
	        	        	
	        	// set the char for logical swap
	        	tempChar = Main.grid.spaces[y + 1][x];
	        	
	        	// fix logical board
	        	
	        	// move mouse logical
	        	Main.grid.spaces[y + 1][x] = Main.grid.spaces[y][x];
	        	
	        	// move etc
	        	Main.grid.spaces[y][x]= tempChar;
	        	
	        	// move icons
	        	
	        	// move etc
	        	Main.images[y][x].setIcon(Main.images[y + 1][x].getIcon()); 
	        	
	        	// move mouse 
	        	Main.images[y + 1][x].setIcon(mouseDown); 
	        	       	
	        	 
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	// set the char for logical swap
	        	tempChar = Main.grid.spaces[y][x - 1];
	        		        	
	        	// fix logical board
	        	
	        	// move mouse logical
	        	Main.grid.spaces[y][x - 1] = Main.grid.spaces[y][x];
	        	
	        	// move etc
	        	Main.grid.spaces[y][x]= tempChar;
	        	
	        	// move icons
	        	
	        	// move etc
	        	Main.images[y][x].setIcon(Main.images[y][x - 1].getIcon()); 
	        	
	        	// move mouse 
	        	Main.images[y][x - 1].setIcon(mouseLeft); 
	        	 
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	
	        	tempChar = Main.grid.spaces[y][x + 1];
	        	        	
	        	// fix logical board
	        	
	        	// move mouse logical
	        	Main.grid.spaces[y][x + 1] = Main.grid.spaces[y][x];
	        	
	        	// move etc
	        	Main.grid.spaces[y][x]= tempChar;
	        	
	        	// move icons
	        	
	        	// move etc
	        	Main.images[y][x].setIcon(Main.images[y][x + 1].getIcon()); 
	        	
	        	// move mouse 
	        	Main.images[y][x + 1].setIcon(mouseRight); 
	            break;
	            
	            
	 	     }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	} 

}
