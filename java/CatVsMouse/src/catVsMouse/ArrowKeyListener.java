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
		boolean isBlock = true;
		boolean isValidMove = true;
		int spaceNum = 0;
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

	        	
	        	if (Main.grid.spaces[y - 1][x] == 'g'){
	        		
	        	
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
	        	}
	        	else if (Main.grid.spaces[y - 1][x] == 'b'){
		        	
	        		while(isBlock){
	        			
	        			
	        			if(Main.grid.spaces[y - 1 - spaceNum][x] == 'g'){
	        				isBlock = false;
	        			}
	        			else if ( y - 1 - spaceNum <= 0){
	        				isBlock = false;
	        				isValidMove = false;
	        			}
	        			else
	        				spaceNum++;

	        		}
	        	
	        		if (isValidMove){
		        		// move empty space to mouse area
		        		Main.images[y][x].setIcon(Main.images[y- 1 - spaceNum][x].getIcon());
		        		Main.grid.spaces[y][x] = Main.grid.spaces[y - 1 - spaceNum][x];
		        		
		        		// move block to old empty
		        		Main.images[y- 1 - spaceNum ][x].setIcon(Main.images[y- 1][x].getIcon());
		        		Main.grid.spaces[y- 1 - spaceNum][x] = Main.grid.spaces[y - 1][x];
		        		
		        		// move the mouse
		        		Main.images[y- 1][x].setIcon(mouseUp);
		        		Main.grid.spaces[y- 1][x] = 'm';
	        		}
	        	}
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 	        	
	        	System.out.println("DOWN");
	        	
	        	if (Main.grid.spaces[y + 1][x] == 'g'){
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
	        	}
	        	else if (Main.grid.spaces[y + 1][x] == 'b'){
		        	
	        		while(isBlock){
	        			
	        			
	        			if(Main.grid.spaces[y + 1 + spaceNum][x] == 'g'){
	        				isBlock = false;
	        			}
	        			else if ( y + 1 + spaceNum <= 0){
	        				isBlock = false;
	        				isValidMove = false;
	        			}
	        			else
	        				spaceNum++;

	        		}
	        	
	        		if (isValidMove){
		        		// move empty space to mouse area
		        		Main.images[y][x].setIcon(Main.images[y+ 1 + spaceNum][x].getIcon());
		        		Main.grid.spaces[y][x] = Main.grid.spaces[y + 1 + spaceNum][x];
		        		
		        		// move block to old empty
		        		Main.images[y+ 1 + spaceNum ][x].setIcon(Main.images[y+ 1][x].getIcon());
		        		Main.grid.spaces[y+ 1 + spaceNum][x] = Main.grid.spaces[y + 1][x];
		        		
		        		// move the mouse
		        		Main.images[y+ 1][x].setIcon(mouseDown);
		        		Main.grid.spaces[y+ 1][x] = 'm';
	        		}
	        	       	
	        	}
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	if (Main.grid.spaces[y][x - 1] == 'g'){
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
	        	}
	        	else if (Main.grid.spaces[y][x - 1] == 'b'){
		        	
	        		while(isBlock){
	        			
	        			
	        			if(Main.grid.spaces[y][x - 1 - spaceNum] == 'g'){
	        				isBlock = false;
	        			}
	        			else if ( x - 1 - spaceNum <= 0){
	        				isBlock = false;
	        				isValidMove = false;
	        			}
	        			else
	        				spaceNum++;

	        		}
	        	
	        		if (isValidMove){
		        		// move empty space to mouse area
		        		Main.images[y][x].setIcon(Main.images[y][x - 1 - spaceNum].getIcon());
		        		Main.grid.spaces[y][x] = Main.grid.spaces[y][x - 1 - spaceNum];
		        		
		        		// move block to old empty
		        		Main.images[y][x - 1 - spaceNum].setIcon(Main.images[y][x - 1].getIcon());
		        		Main.grid.spaces[y][x - 1 - spaceNum] = Main.grid.spaces[y][x - 1];
		        		
		        		// move the mouse
		        		Main.images[y][x - 1].setIcon(mouseRight);
		        		Main.grid.spaces[y][x - 1] = 'm';
	        		}
	        	} 
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	if (Main.grid.spaces[y][x + 1] == 'g'){
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
	        	}
	        	else if (Main.grid.spaces[y][x + 1] == 'b'){
		        	
	        		while(isBlock){
	        			
	        			
	        			if(Main.grid.spaces[y][x + 1 + spaceNum] == 'g'){
	        				isBlock = false;
	        			}
	        			else if ( x + 1 + spaceNum <= 0){
	        				isBlock = false;
	        				isValidMove = false;
	        			}
	        			else
	        				spaceNum++;

	        		}
	        	
	        		if (isValidMove){
		        		// move empty space to mouse area
		        		Main.images[y][x].setIcon(Main.images[y][x + 1 + spaceNum].getIcon());
		        		Main.grid.spaces[y][x] = Main.grid.spaces[y][x + 1 + spaceNum];
		        		
		        		// move block to old empty
		        		Main.images[y][x + 1 + spaceNum].setIcon(Main.images[y][x + 1].getIcon());
		        		Main.grid.spaces[y][x + 1 + spaceNum] = Main.grid.spaces[y][x + 1];
		        		
		        		// move the mouse
		        		Main.images[y][x + 1].setIcon(mouseRight);
		        		Main.grid.spaces[y][x + 1] = 'm';
	        		}
	        	}
	            break;	            	            
	 	     }
	    
		for(int  i = 0; i < 30; i++ ){
			for(int j = 0; j < 30; j++){
			System.out.print(Main.grid.spaces[i][j]);	
				
			}
			System.out.print('\n');
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
