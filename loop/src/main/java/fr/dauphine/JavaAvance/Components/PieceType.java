package fr.dauphine.JavaAvance.Components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * Type of the piece enum
 * 
 */
public enum PieceType {
	// Each Type has a number of connectors and a specific value

	VOID(0,0),
	ONECONN(1,1),
	BAR(2,2),
	TTYPE(3,3),
	FOURCONN(4,4),
	LTYPE(2,5);
	
	private int nbConnectors;
	private int value;

	PieceType(int i, int j) {
		// TODO Auto-generated constructor stub
		this.nbConnectors = i;
		this.value = j;
	}

	public void setNbConnectors(int nbConnectors) {
		this.nbConnectors = nbConnectors;
	}

	public int getNbConnectors() {
		return nbConnectors;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Orientation getOrientation(Orientation ori) {
		return ori;
	}

	public LinkedList<Orientation> setConnectorsList(Orientation ori) {
		LinkedList<Orientation> connectors = new LinkedList<Orientation>();
		switch(this) {
		case VOID:
			break;
		case ONECONN:
			connectors.add(ori);
			break;
		case BAR:
			switch(ori) {
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);
				break;
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.NORTH);
				break;
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.EAST);
				break;
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);
				break;
			}
			break;
		case TTYPE:
			switch(ori) {
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);	
				break;
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);	
				break;
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);
				break;
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);
				break;
			}
			break;
		case FOURCONN:
			connectors.add(Orientation.WEST);	
			connectors.add(Orientation.NORTH);
			connectors.add(Orientation.SOUTH);
			connectors.add(Orientation.EAST);
			break;
		case LTYPE:
			switch(ori) {
			//Take the left side of L to define it's orientation
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.EAST);	
				break;
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.WEST);
				break;
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.NORTH);
				break;
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.SOUTH);	
				break;
			}break;
		}
		return connectors;
	}

	public ArrayList<Orientation> getListOfPossibleOri() {
		// TODO Auto-generated method stub
		ArrayList<Orientation> possibleOrientations = new ArrayList<Orientation>();

		possibleOrientations.add(Orientation.NORTH);
		possibleOrientations.add(Orientation.EAST);
		possibleOrientations.add(Orientation.SOUTH);
		possibleOrientations.add(Orientation.WEST);

		return possibleOrientations;
		
	}

	static PieceType getTypefromValue(int typeValue) {
		// TODO Auto-generated method stub
		switch(typeValue) {
		case 0: return VOID;
		case 1: return ONECONN;
		case 2: return BAR;
		case 3: return TTYPE;
		case 4: return FOURCONN;
		case 5: return LTYPE;
		}
		return null;
	}
}
