package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class DrumPhoto extends Photo {
	/**
	 * 
	 */
	private String company;
	private String productName;
	private String owner;
	private int numOfToms;
	private boolean doubleBass;
	private boolean electric;
	private boolean acoustic;
	
	public DrumPhoto(){
		super();
	}
	
	public DrumPhoto(PhotoId id){
		super(id);
	}

	public String getCompany() {
		return company;
	}

	public String getProductName() {
		return productName;
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

	public void setCompany(String company) {
		this.company = company;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setNumOfToms(int numOfToms) {
		this.numOfToms = numOfToms;
	}

	public void setDoubleBass(boolean doubleBass) {
		this.doubleBass = doubleBass;
	}
	
	public boolean isElectric() {
		return electric;
	}

	public boolean isAcoustic() {
		return acoustic;
	}

	public void setElectric(boolean electric) {
		this.electric = electric;
	}

	public void setAcoustic(boolean acoustic) {
		this.acoustic = acoustic;
	}

	
}
