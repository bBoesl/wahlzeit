package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DrumPhotoFactoryTest extends PhotoFactoryTest {

	static DrumPhotoFactory drumFactory;
	
	@BeforeClass
	public static void startUp(){
		DrumPhotoFactory.getInstance();
	}
	
	@Test
	public void testCreateDrumPhoto(){
		assertTrue(drumFactory.createPhoto() != null);
		PhotoId id = PhotoId.getNextId();
		Photo photo = drumFactory.createPhoto(id);
		assertTrue(photo != null);
		assertTrue(photo.getId() == id);
		
	}

}
