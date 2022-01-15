package fr.dauphine.JavaAvance.Components;

import java.util.HashMap;

/**
 * 
 * Orientation of the piece enum
 * 
 */
public enum Orientation {
	/* Implement all the possible orientations and 
	 *  required methods to rotate
	 */
	
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	private int value;
	private int[] oppoCoordinates;
	
	Orientation(int i) {
		this.value = i;
	}
	
	public int getValue() {
		return value;
	}
	
	static Orientation getOrifromValue(int orientationValue) {
		// TODO Auto-generated method stub
		switch(orientationValue) {
		case 0: return NORTH;
		case 1: return EAST;
		case 2: return SOUTH;
		case 3: return WEST;
		}
		return null;
	}
	
	Orientation turn90() {
		// All shapes are rotated clockwise
		switch(this) {
		case NORTH: return EAST;
		case EAST: return SOUTH;
		case SOUTH: return WEST;
		case WEST: return NORTH;
		}
		return null;
	}

	//return the coordinates (x,y) of opposed piece indicated by input piece, y at int[0], x at int[1]
	public int[] getOpposedPieceCoordinates(Piece p) {
		oppoCoordinates = null;
		switch(this) {
		case NORTH: 
			oppoCoordinates[0] = p.getPosY() - 1;
			oppoCoordinates[1] = p.getPosX();
			break;
		case EAST:
			oppoCoordinates[0] = p.getPosY();
			oppoCoordinates[1] = p.getPosX() + 1;
			break;
		case SOUTH:
			oppoCoordinates[0] = p.getPosY() + 1;
			oppoCoordinates[1] = p.getPosX();
			break;
		case WEST:
			oppoCoordinates[0] = p.getPosY();
			oppoCoordinates[1] = p.getPosX() - 1;
		}
		return oppoCoordinates;
	}

	Orientation getOpposedOrientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
