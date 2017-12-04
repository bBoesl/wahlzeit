package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SphericCoordinateTest {

	final double earthRadius =6378.388;
	@Test
	public void testEquals() {
		SphericCoordinate erlangen1 = new SphericCoordinate(Math.toRadians(49.597843), Math.toRadians(11.004728),earthRadius);
		SphericCoordinate erlangen2 = new SphericCoordinate(Math.toRadians(49.597843), Math.toRadians(11.004728),earthRadius);
		
		assertTrue(erlangen1.equals(erlangen2));
		assertEquals(erlangen1.getlatitude(), erlangen2.getlatitude(),0.0);
		assertEquals(erlangen1.getLongitude(), erlangen2.getLongitude(),0.0);
		
	}
	
	@Test
	public void testGetDistance(){
		SphericCoordinate schlossplatz1 = new SphericCoordinate(Math.toRadians(49.597843), Math.toRadians(11.004728),earthRadius );
		SphericCoordinate schlossplatz2 = new SphericCoordinate(Math.toRadians(49.597843), Math.toRadians(11.004728),earthRadius);
		
		assertEquals( 0.0,schlossplatz1.getDistance(schlossplatz2), 0.00000001);
		
		SphericCoordinate roterPlatz = new SphericCoordinate(Math.toRadians(49.574768), Math.toRadians(11.029101),earthRadius);
		assertEquals(3.13,schlossplatz1.getSphericDistance(roterPlatz), 0.1);
		
		SphericCoordinate yale = new SphericCoordinate(Math.toRadians(41.316030), Math.toRadians(-72.928773),earthRadius);
		assertEquals(6272.41,schlossplatz1.getSphericDistance(yale), 0.1);
		
		
	}
	

}
