import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * 
 */

/**
 * @author Jared
 * http://en.wikipedia.org/wiki/Chess_symbols_in_Unicode
 */
public class Board extends JPanel {

	// protected variable
	public Square[][] squares = new Square[8][8];
	public char tempPiece;
	public int pressCount = 0;
	public int startRow;
	public int startCol;
	public char tempPiece2;
	public Border border;

	Board()
	{

		Font piece = new Font("Serif", 35, 35 );


		// panel layout
		setLayout(new GridLayout(8,8));
		border = new LineBorder(Color.YELLOW, 3, false);

		// Lets get this board setup Capital letters are white		
		squares[0][0] = new Square("\u2656", 'R');
		squares[0][0].setFont(piece);
		squares[0][0].setForeground(Color.WHITE);
		squares[0][1] = new Square("\u2658", 'N');
		squares[0][1].setFont(piece);
		squares[0][1].setForeground(Color.WHITE);
		squares[0][2] = new Square("\u2657", 'B');
		squares[0][2].setFont(piece);
		squares[0][2].setForeground(Color.WHITE);
		squares[0][3] = new Square("\u2655",'Q');
		squares[0][3].setFont(piece);
		squares[0][3].setForeground(Color.WHITE);
		squares[0][4] = new Square("\u2654", 'K');
		squares[0][4].setFont(piece);
		squares[0][4].setForeground(Color.WHITE);
		squares[0][5] = new Square("\u2657", 'B');
		squares[0][5].setFont(piece);
		squares[0][5].setForeground(Color.WHITE);
		squares[0][6] = new Square("\u2658", 'N');
		squares[0][6].setFont(piece);
		squares[0][6].setForeground(Color.WHITE);
		squares[0][7] = new Square("\u2656", 'R');
		squares[0][7].setFont(piece);
		squares[0][7].setForeground(Color.WHITE);

		// pawns are all the same so lets just loop through
		for (int i = 0; i < 8; i++)
		{
			squares[1][i] = new Square("\u2659", 'P');
			squares[1][i].setFont(piece);
			squares[1][i].setForeground(Color.WHITE);
		}
		
		// Same Idea for the spaces
		for (int row = 2; row < 6; row++)
		{
			for (int col = 0; col < 8; col++)
			{
				squares[row][col] = new Square(" ", ' ');
				squares[row][col].setFont(piece);
				
			}
		}

		// loop through black pawns
		for (int i = 0; i < 8; i++)
		{
			squares[6][i] = new Square("\u265F", 'p');
			squares[6][i].setFont(piece);
			squares[6][i].setForeground(Color.BLACK);
		}

		squares[7][0] = new Square("\u265C", 'r');
		squares[7][0].setFont(piece);
		squares[7][0].setForeground(Color.BLACK);
		squares[7][1] = new Square("\u265E", 'n');
		squares[7][1].setFont(piece);
		squares[7][1].setForeground(Color.BLACK);
		squares[7][2] = new Square("\u265D", 'b');
		squares[7][2].setFont(piece);
		squares[7][2].setForeground(Color.BLACK);
		squares[7][3] = new Square("\u265A", 'q');
		squares[7][3].setFont(piece);
		squares[7][3].setForeground(Color.BLACK);
		squares[7][4] = new Square("\u265B", 'k');
		squares[7][4].setFont(piece);
		squares[7][4].setForeground(Color.BLACK);
		squares[7][5] = new Square("\u265D", 'b');
		squares[7][5].setFont(piece);
		squares[7][5].setForeground(Color.BLACK);
		squares[7][6] = new Square("\u265E", 'n');
		squares[7][6].setFont(piece);
		squares[7][6].setForeground(Color.BLACK);
		squares[7][7] = new Square("\u265C", 'r');
		squares[7][7].setFont(piece);
		squares[7][7].setForeground(Color.BLACK);

		// initialize the board
		for(int row = 0; row < 8; row++)
		{
			for(int col = 0; col < 8; col++)
			{

				if((col + row) % 2 == 0 )
				{
					// add the black square
					add(squares[row][col]);
					squares[row][col].setBackground(Color.DARK_GRAY);
					squares[row][col].addActionListener(new Move());
				}
				else
				{
					// add the white square

					add(squares[row][col]);
					squares[row][col].setBackground(Color.RED);
					squares[row][col].addActionListener(new Move());

				}
			}

		}


	}
	public void showPossibleMoves(boolean turnOnBorder, int row , int col)
	{
		if(turnOnBorder == true)
		{
		squares[row][col].setBorder(border);
		
		
		// Rook Moves
		if(squares[row][col].getPiece() == 'r' || squares[row][col].getPiece() == 'R' )
		{
			for (int i = row + 1; i >= 7; i++)
			{
				if (squares[i][col].getPiece() == ' ')
					squares[i][col].setBorder(border);
				else
				{
					break;
				}
			}
			for (int i = row - 1; i <= 0; i--)
			{
				if (squares[i][col].getPiece() == ' ')
					squares[i][col].setBorder(border);
				else
				{
					break;
				}
			}
			for (int i = col + 1; i >= 7; i++)
			{
				if (squares[row][i].getPiece() == ' ')
					squares[row][i].setBorder(border);
				else
				{
					break;
				}
			}
			for (int i = col - 1; i <= 0; i--)
			{
				if (squares[row][i].getPiece() == ' ')
					squares[row][i].setBorder(border);
				else
				{
					break;
				}
			}
		}
		}
	}

	/****************************************
	 * moveOne
	 * @param row
	 * @param col
	 ****************************************/
	public void moveOne(int row, int col)
	{
		tempPiece = squares[row][col].getPiece();
		showPossibleMoves(true, row, col);
		squares[row][col].setBorder(border);
		pressCount++;
		startRow = row;
		startCol = col;
	}
	
	
	/****************************************
	 * moveTwo
	 * @param row
	 * @param col
	 ****************************************/
	public void moveTwo(int row, int col)
	{
		// assign the second selected piece
		tempPiece2 = squares[row][col].getPiece();
		
		// remove the border
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			squares[i][j].setBorder(null);
		}
		
		//put the first selected piece into the second selected piece
		switch (tempPiece)
		{
		case 'R': squares[row][col].setText("\u2656");
		squares[row][col].setPiece('R');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'N': squares[row][col].setText("\u2658");
		squares[row][col].setPiece('N');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'B': squares[row][col].setText("\u2657");
		squares[row][col].setPiece('B');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'Q': squares[row][col].setText("\u2655");
		squares[row][col].setPiece('Q');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'K': squares[row][col].setText("\u2654");
		squares[row][col].setPiece('K');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'P': squares[row][col].setText("\u2659");
		squares[row][col].setPiece('P');
		squares[row][col].setForeground(Color.WHITE);
		break;
		case 'r': squares[row][col].setText("\u265C");
		squares[row][col].setPiece('r');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case 'n': squares[row][col].setText("\u265E");
		squares[row][col].setPiece('n');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case 'b': squares[row][col].setText("\u265D");
		squares[row][col].setPiece('b');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case 'q': squares[row][col].setText("\u265A");
		squares[row][col].setPiece('q');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case 'k': squares[row][col].setText("\u265B");
		squares[row][col].setPiece('k');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case ' ': squares[row][col].setText(" ");
		squares[row][col].setPiece(' ');
		squares[row][col].setForeground(Color.BLACK);
		break;
		case 'p': squares[row][col].setText("\u265F");
		squares[row][col].setPiece('p');
		squares[row][col].setForeground(Color.BLACK);
		break;
		default:
		break;
		}
		switch (tempPiece2)
		{
		case 'R': squares[startRow][startCol].setText(" ");
		break;
		case 'N': squares[startRow][startCol].setText(" ");
		break;
		case 'B': squares[startRow][startCol].setText(" ");
		break;
		case 'Q': squares[startRow][startCol].setText(" ");
		break;
		case 'K': squares[startRow][startCol].setText(" ");
		break;
		case 'P': squares[startRow][startCol].setText(" ");
		break;
		case 'r': squares[startRow][startCol].setText(" ");
		break;
		case 'n': squares[startRow][startCol].setText(" ");
		break;
		case 'b': squares[startRow][startCol].setText(" ");
		break;
		case 'q': squares[startRow][startCol].setText(" ");
		break;
		case 'k': squares[startRow][startCol].setText(" ");
		break;
		case 'p': squares[startRow][startCol].setText(" ");
		break;
		case ' ': squares[startRow][startCol].setText(" ");
		break;
		default:
		break;
		}
		
		// move the game along
		pressCount++;

		
		
	}

	class Move implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			for(int row = 0; row < 8; row++)
			{
				for(int col = 0; col < 8; col++)
				{
					if(e.getSource() == squares[row][col])
					{
						squares[row][col].getText();
						
						if(pressCount == 2)
						{
							pressCount = 0;
						}
							
						
						System.out.println(tempPiece);
						System.out.println(pressCount);
						if(pressCount == 1)
						{
							moveTwo(row, col);
							
						}
						if(pressCount == 0)
						{
							moveOne(row, col);
						}
							
							
					}
				}
			}
		}
	}
}
