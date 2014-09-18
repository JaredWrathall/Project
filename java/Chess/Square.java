import java.awt.Font;

import javax.swing.*;

/**
 * 
 */

/**
 * @author Jared
 *
 */
public class Square extends JButton{
	
	private char piece;
	private String unicode;
	
	/*********************************
	 * Constructor Overloaded
	 * @param s
	 * @param piece
	 *********************************/
	public Square(String s, char piece)
	{
		super(s);
		this.piece = piece;

	}
	
	/*********************************
	 * Constructor
	 * @param piece
	 *********************************/
	public Square(char piece)
	{
		super();
		this.piece = piece;

	}
	
	public Square()
	{
		super();
		
	}
	
	public Square(String s)
	{
		super(s);
					
	}
	/*****************************
	 * Allows the program to know 
	 * what piece it is.
	 * Uppercase is White
	 * Lowercase is Black
	 * R = Rook
	 * K = Knight
	 * B = Bishop
	 * Q = Queen
	 * K = King
	 * P = Pawn
	 * @return
	 */
	public char getPiece()
	{
		return this.piece;
		
	}
	
	/*****************************
	 * If a piece value ever needs to be changed
	 * @param piece
	 */
	public void setPiece(char piece)
	{
		this.piece = piece;
	}
	
}
