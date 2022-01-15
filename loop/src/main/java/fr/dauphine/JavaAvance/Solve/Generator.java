package fr.dauphine.JavaAvance.Solve;


import java.io.*;
import java.nio.file.*;
import java.util.*;

import fr.dauphine.JavaAvance.Components.Orientation;
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

	      
	public static void generateLevel(String fileName, Grid inputGrid) throws IOException {
		//different random for Corner and Border situation
		Random random = new Random();
		
		List<PieceType> listC = new ArrayList<PieceType>();
    	listC.add(PieceType.VOID);
    	listC.add(PieceType.ONECONN);
    	listC.add(PieceType.LTYPE);
    	
    	List<PieceType> listB = new ArrayList<PieceType>();
    	listB.add(PieceType.VOID);
    	listB.add(PieceType.ONECONN);
    	listB.add(PieceType.BAR);
    	listB.add(PieceType.TTYPE);
    	listB.add(PieceType.LTYPE);
    	
    	//create the output file and write in this file
    	Path file = Paths.get(fileName);
 	    try {
 	        // Create the empty file 
 	        Files.createFile(file);
 	        
 	    } catch (FileAlreadyExistsException x) {
 	        System.err.format("file named %s" +
 	            " already exists%n", file);
 	    } catch (IOException x) {
 	        
 	        System.err.format("createFile error: %s%n", x);
 	    }
 	    int width = inputGrid.getWidth();
 	    int height = inputGrid.getHeight();
 	    BufferedWriter bw = Files.newBufferedWriter(file,StandardOpenOption.CREATE_NEW);
 	    try {
 	 	    bw.write(Integer.toString(width));
 	 	    bw.newLine();
 	 	    bw.write(Integer.toString(height)); 
			bw.newLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        

		if(inputGrid.getNbcc() == -1) {			
			for (int i=0; i < inputGrid.getHeight(); i++){
			    for (int j=0; j < inputGrid.getWidth(); j++){
			        //if it is a corner		    	
			        if(inputGrid.isCorner(i,j)==true) {
			        	
			        //set the cell , possible pieces are type 0 ,1 or 5
			        	PieceType ptC = listC.get(new Random().nextInt(listC.size())) ;
			        	Orientation orientation = Orientation.values()[random.nextInt(4)];
			        	
			        	inputGrid.setPiece(i, j, new Piece(i, j, ptC, orientation));
			        	try {
			        		bw.write(ptC.getValue()+ "," + orientation.getValue());
							bw.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        
			        //if it is a borderline or a bordercolumn 
			        
			        if(inputGrid.isBorderLine(i,j)==true||inputGrid.isBorderColumn(i,j)==true) {
			        	//set the cell , possible pieces are type 0,1,2,3,5, except type 4
			        	PieceType ptB = listB.get(new Random().nextInt(listB.size())) ;
			        	Orientation orientation2 = Orientation.values()[random.nextInt(4)];

			        	inputGrid.setPiece(i, j, new Piece(i, j, ptB, orientation2));
			        	try {
							bw.write(ptB.getValue()+ "," + orientation2.getValue());
							bw.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	
			        }
			        else {
			        	// set the cell, possible pieces are all the 5 types 
			        	PieceType type = PieceType.values()[random.nextInt(PieceType.values().length)];
			        	Orientation orientation3 = Orientation.values()[random.nextInt(4)];
			        	
			        	inputGrid.setPiece(i, j, new Piece(i, j, type, orientation3));
			        	try {
							bw.write(type.getValue() + orientation3.getValue());
							bw.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			    }
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
