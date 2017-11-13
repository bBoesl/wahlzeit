package org.wahlzeit.model;

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

/**
 * 
 * Copied mostly of PhotoFactory, and replaced all occurs of PhotoFactory with DrumPhotoFactory,
 * not a very elegant way to do this, but it works.. 
 *
 */
public class DrumPhotoFactory extends PhotoFactory {
	
	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	
	private static DrumPhotoFactory instance = null;
	
	// to preserve the singelton-Pattern and still recieve a DrumFactory
	public static synchronized DrumPhotoFactory getInstance(){
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
			setInstance(new DrumPhotoFactory());
		}

		return instance;
	}
	
	protected DrumPhotoFactory() {
		super();
	}
	
	public DrumPhoto createDrumPhoto(){
		return new DrumPhoto();
	}
	
	
	public DrumPhoto createDrumPhoto(PhotoId id){
		return new DrumPhoto( id);
	}
	
	
	
	
	/**
	 * Method to set the singleton instance of PhotoFactory.
	 */
	protected static synchronized void setInstance(DrumPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}

}
