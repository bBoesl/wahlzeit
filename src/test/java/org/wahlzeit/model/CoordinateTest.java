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

}
