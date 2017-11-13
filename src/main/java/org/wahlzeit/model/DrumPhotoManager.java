package org.wahlzeit.model;

import java.util.logging.Logger;

/**
 * 
 */
public class DrumPhotoManager extends PhotoManager {
	
	protected static final PhotoManager instance = new DrumPhotoManager();
	
	private static final Logger log = Logger.getLogger(DrumPhotoManager.class.getName());


	public DrumPhotoManager() {
		photoTagCollector = DrumPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 * In Future some features especially for DrumPhotos may be added,
	 *  at this point i don't see a point to do so
	 */
	

}
