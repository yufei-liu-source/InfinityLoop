package fr.dauphine.JavaAvance.Solve;


import java.util.Random;

import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.Components.PieceType;
import fr.dauphine.JavaAvance.GUI.Grid;

/**
 * Generate a solution, number of connexe composant is not finished
 *
 */

public class Generator {

	private static Grid filledGrid;

	/**
	 * @param output
	 *            file name
	 * @throws IOException
	 *             - if an I/O error occurs.
	 * @return a File that contains a grid filled with pieces (a level)
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void generateLevel(String fileName, Grid inputGrid) {
      
		// To be implemented
		if(inputGrid.getNbcc == -1) {
			
			for (int i=0; i < inputGrid.getHeight(); i++)
			{
			    for (int j=0; j < inputGrid.getWidth(); j++)
			    {
			        //if it is a corner
			    	
			        if(inputGrid.isCorner(i,j)==True) {
			        	
			        //set the cell , possible pieces are type 0 ,1 or 5
			        
			    }
			        
			        //if it is a borderline or a bordercolumn 
			        
			        if(inputGrid.isBorderLine(i,j)==True||inputGrid.isBorderColumn(i,j)==True) {
			        	//set the cell , possible pieces are type 0,1,2,3,5, except type 4
			        }
			       
			        else {
			        	// set the cell, possible pieces are all the 5 types 
			        }
			        	
			        }
			}
		 }
			else {
				
			}
		}
		
	}
	public static int[] copyGrid(Grid filledGrid, Grid inputGrid, int i, int j) {
		Piece p;
		int hmax = inputGrid.getHeight();
		int wmax = inputGrid.getWidth();

		if (inputGrid.getHeight() != filledGrid.getHeight())
			hmax = filledGrid.getHeight() + i; // we must adjust hmax to have the height of the original grid
		if (inputGrid.getWidth() != filledGrid.getWidth())
			wmax = filledGrid.getWidth() + j;

		int tmpi = 0;// temporary variable to stock the last index
		int tmpj = 0;

		// DEBUG System.out.println("copyGrid : i =" + i + " & j = " + j);
		// DEBUG System.out.println("hmax = " + hmax + " - wmax = " + wmax);
		for (int x = i; x < hmax; x++) {
			for (int y = j; y < wmax; y++) {
				// DEBUG System.out.println("x = " + x + " - y = " + y);
				p = filledGrid.getPiece(x - i, y - j);
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(p);
				inputGrid.setPiece(x, y, new Piece(x, y, p.getType(), p.getOrientation()));
				// DEBUG System.out.println("x = " + x + " - y = " +
				// y);System.out.println(inputGrid.getPiece(x, y));
				tmpj = y;
			}
			tmpi = x;
		}
		//DEBUGSystem.out.println("tmpi =" + tmpi + " & tmpj = " + tmpj);
		return new int[] { tmpi, tmpj };
	}

}