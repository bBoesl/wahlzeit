package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class DrumPhoto extends Photo {
	/**
	 * 
	 */
	private Drumset set;
	
	public DrumPhoto(){
		super();
	}
	
	public DrumPhoto(PhotoId id){
		super(id);
	}

	public void setDrumset(Drumset set){
		this.set = set;
	}
	
	public Drumset getDrumset(){
		return set;
	}

	
}
