package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class Drumset extends DataObject {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -504103652641517534L;
	private DrumType type;
	private String owner;
	private int numOfToms;
	private boolean doubleBass;
	private int numOfSnares;
	private static int counter;
	private int id;
	
	public Drumset(DrumType type, String owner, int toms, boolean doublebass,int snares){
		this.type = type;
		this.owner = owner;
		this.numOfToms = toms;
		this.doubleBass = doublebass;
		this.numOfSnares = snares;
		id = counter;
		counter++;
		DrumManager.getInstance().addSet(this);
	}
	
	public int getID(){
		return id;
	}

	public DrumType getType() {
		return type;
	}

	public String getOwner() {
		return owner;
	}

	public int getNumOfToms() {
		return numOfToms;
	}

	public boolean isDoubleBass() {
		return doubleBass;
	}

	public int getNumOfSnares() {
		return numOfSnares;
	}
	
	
	
}
