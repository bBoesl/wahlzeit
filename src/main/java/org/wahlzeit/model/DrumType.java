package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class DrumType extends DataObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6838474338494838592L;
	private DrumType superType;
	private String company;
	private String productName;
	private boolean electric;
	private boolean accoustic;
	private static int counter;
	private int id;

	public DrumType(String company, String productName, boolean electric, boolean accoustic){
		this.company = company;
		this.productName = productName;
		this.electric = electric;
		this.accoustic = accoustic;
		id = counter;
		counter++;
		DrumManager.getInstance().addType(this);
	}
	
	public boolean isSubtype(DrumType type){
		if(type == this) return true;
		if(superType == null) return false;
		return superType.isSubtype(type);
	}
	
	public void setSuperType(DrumType type){
		superType = type;
	}
	
	public DrumType getSuperType(){
		return superType;
	}

	public String getCompany() {
		return company;
	}

	public String getProductName() {
		return productName;
	}

	public boolean isElectric() {
		return electric;
	}

	public boolean isAccoustic() {
		return accoustic;
	}

	public int getID() {
		return id; 
	}
	
	
}
