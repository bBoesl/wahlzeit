package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {
	
	SphericCoordinate spherical = new SphericCoordinate(1.0,2.0,3.0);
	CartesianCoordinate cartesian = new CartesianCoordinate(1.0, 2.0, 3.0);
	
	@Test
	public void testAsMethods() {
		assertTrue(spherical.asCartesianCoordinate().asSphericCoordinate().equals(spherical));
		assertTrue(cartesian.asSphericCoordinate().asCartesianCoordinate().equals(cartesian));
	}
	/*
	@Test
	public void testEquals() {
		Coordinate erlangen1 = new Coordinate(49.597843, 11.004728);
		Coordinate erlangen2 = new Coordinate(49.597843, 11.004728);
		
		assertTrue(erlangen1.equals(erlangen2));
		assertEquals(erlangen1.getNorth(), erlangen2.getNorth(),0.0);
		assertEquals(erlangen1.getEast(), erlangen2.getEast(),0.0);
		
	}
	
	@Test
	public void testDistanceTo(){
		Coordinate schlossplatz1 = new Coordinate(49.597843, 11.004728);
		Coordinate schlossplatz2 = new Coordinate(49.597843, 11.004728);
		
		assertEquals( 0.0,schlossplatz1.distanceTo(schlossplatz2), 0.00000001);
		
		Coordinate roterPlatz = new Coordinate(49.574768, 11.029101);
		assertEquals(3.13,schlossplatz1.distanceTo(roterPlatz), 0.1);
		
		Coordinate yale = new Coordinate(41.316030, -72.928773);
		assertEquals(6272.41,schlossplatz1.distanceTo(yale), 0.1);
		
		
	}
	*/

}
