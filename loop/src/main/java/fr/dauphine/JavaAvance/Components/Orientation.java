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
		// TODO Auto-generated method stub
		switch(this) {
		case NORTH: return EAST;
		case EAST: return SOUTH;
		case SOUTH: return WEST;
		case WEST: return NORTH;
		}
		return null;
	}

}
