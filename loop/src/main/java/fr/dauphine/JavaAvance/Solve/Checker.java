package fr.dauphine.JavaAvance.Solve;

import java.io.IOException;
//import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.Iterator;
import java.util.List;

import fr.dauphine.JavaAvance.Components.Piece;
import fr.dauphine.JavaAvance.GUI.Grid;


public class Checker {

// To be implemented
	private Grid myGrid;
	private Path inputFile;
	private boolean solved;
	
	List<String> lines; 
	int w,h;
	List<String> gridList;
	
	public Checker(String input, boolean solved) throws IOException{
		super();
		this.inputFile = Paths.get(input);
		this.solved = solved;
		if(!Files.isReadable(this.inputFile) || !Files.isDirectory(this.inputFile)) {
			throw new IOException ("Invalid file!");
		}
		this.readFile();
	}
	
	
	public void readFile() throws IOException {
		lines = Files.readAllLines(this.inputFile); //put every line of file in a list of String
		w = Integer.parseInt(lines.get(0));
		h = Integer.parseInt(lines.get(1));
		gridList = lines.subList(2, -1);
	}
	
	/***
	 * Transform an input file into a grid and filled it with pieces according to the file
	 * 
	 * @param fileName path of the file
	 */
	public void generateCheckLevel() {
		int indexgridList = 0;
		myGrid = new Grid(h,w);
		for(int x = 0; x < h ; x++) {
			for(int y = 0; y < w ; y++) {
				String[] values = gridList.get(indexgridList).split(",");
				int typeValue = Integer.parseInt(values[0]);
				int orientationValue = Integer.parseInt(values[1]);
				Piece piece = new Piece(x, y, typeValue, orientationValue);
				myGrid.setPiece(x, y, piece);
				
				indexgridList++;
			}
		}
	}
	
	/***
	 * check if all the pieces in the grid are connected
	 * 
	 * @return true if connected or false if any of it is not connected
	 */
	public boolean isSolution() {
		int validPiece = 0;
		for(int x = 0; x < h ; x++) {
			for(int y = 0; y < w ; y++) {
				if(myGrid.isTotallyConnected(myGrid.getPiece(h, w))) {
					validPiece++;
				}
			}
		}	
		if(validPiece == gridList.size()) 
			solved = true; 
		return solved;
	}
}
