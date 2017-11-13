package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PhotoFactoryTest {

	/**
	 * since PhotoFacotry is a Singleton, without any internal states
	 * there is no need to create a new PhotoFactory for each Test.
	 */
	static PhotoFactory factory;
	
	@BeforeClass
	public static void startUp(){
		factory = PhotoFactory.getInstance();
	}
	
	
	@Test
	public void testCreatePhoto(){
		 Photo  photo = factory.createPhoto();
		 assertTrue(photo  != null);
		 
		 PhotoId id = PhotoId.getNextId();
		 photo =factory.createPhoto(id);
		 assertTrue(photo.getId() == id);
	}
	
	@Test
	public void testLoadPhoto(){
		// method currently returns null...
		fail("not yet implemented");
	}
	
	public void testCreatePhotoFilter(){
		assertTrue(factory.createPhotoFilter() != null);
	}
	
	public void testCreatePhotoTagCollector(){
		assertTrue(factory.createPhotoTagCollector() != null);
	}

}
