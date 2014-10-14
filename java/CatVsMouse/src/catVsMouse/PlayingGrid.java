package catVsMouse;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

public class PlayingGrid {

	
	public char[][] spaces = new char[30][30];
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	PlayingGrid(){
		
		// initialize the grid
		for(int  i = 0; i < 30; i++ ){
			for(int j = 0; j < 30; j++){
				spaces[i][j] = 'g';
			}						
		}
		spaces[0][0] = 'm';
	}
	

}
