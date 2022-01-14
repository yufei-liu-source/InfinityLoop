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
	
	private int nbConn;
	private int value;
	
	private Orientation o;

	PieceType(int i, int j) {
		// TODO Auto-generated constructor stub
		this.nbConn = i;
		this.value = j;
	}

	public int getNbConn() {
		return nbConn;
	}

	public void setNbConn(int nbConn) {
		this.nbConn = nbConn;
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
		case BAR:
			switch(ori) {
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);	
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.NORTH);
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.EAST);
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);	
			}
		case TTYPE:
			switch(ori) {
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);	
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.WEST);	
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.SOUTH);
			}
		case FOURCONN:
			connectors.add(Orientation.WEST);	
			connectors.add(Orientation.NORTH);
			connectors.add(Orientation.SOUTH);
			connectors.add(Orientation.EAST);
		case LTYPE:
			switch(ori) {
			//Take the left side of L to define it's orientation
			case NORTH:
				connectors.add(Orientation.NORTH);
				connectors.add(Orientation.EAST);	
			case SOUTH:
				connectors.add(Orientation.SOUTH);	
				connectors.add(Orientation.WEST);
			case WEST:
				connectors.add(Orientation.WEST);	
				connectors.add(Orientation.NORTH);
			case EAST:
				connectors.add(Orientation.EAST);
				connectors.add(Orientation.SOUTH);	
			}
		}
		return connectors;
	}

	ArrayList<Orientation> getListOfPossibleOri() {
		// TODO Auto-generated method stub
		ArrayList<Orientation> possibleOrientations = new ArrayList<Orientation>();
		switch(this) {
		case VOID:
			break;
		case ONECONN:

		case BAR:
			
		case TTYPE:
			
		case FOURCONN:
			
		case LTYPE:
		}
		return null;
		
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
