package org.wahlzeit.model;
import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testEqualsWithoutCoords() {
		Location location1 = new Location("home");
		Location location2 = new Location("home");
		assertTrue(location1.equals(location2));
		
		location2 = new Location("somewhereElse");
		assertFalse(location1.equals(location2));
		
	}
	
	@Test
	public void testEqualsMixedCoords(){
		Location location1 = new Location("home", new Coordinate(0.0 , 0.0 ) );
		Location location2 = new Location("home");
		assertFalse(location1.equals(location2));
		assertFalse(location2.equals(location1));
	}
	
	@Test
	public void testEqualsWithCoords(){
		Coordinate zeroZero = new Coordinate(0.0, 0.0);
		Location location1 = new Location("home", zeroZero );
		Location location2 = new Location("home", zeroZero );
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
		
		location2 =new Location("somewhereElse", zeroZero );
		assertFalse(location1.equals(location2));
		assertFalse(location2.equals(location1));
		
		location2 = new Location("home", new Coordinate(0.0, 0.0));
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
		
		location2 = new Location("home", new Coordinate(0.0, 0.0000000000001));
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
	}

}
