package org.wahlzeit.model;
import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	final double earthRadius =6378.388;
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
		Location location1 = new Location("home", new SphericCoordinate(0.0 , 0.0 ,earthRadius) );
		Location location2 = new Location("home");
		assertFalse(location1.equals(location2));
		assertFalse(location2.equals(location1));
	}
	
	@Test
	public void testEqualsWithCoords(){
		SphericCoordinate zeroZero = new SphericCoordinate(0.0, 0.0,earthRadius);
		Location location1 = new Location("home", zeroZero );
		Location location2 = new Location("home", zeroZero );
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
		
		location2 =new Location("somewhereElse", zeroZero );
		assertFalse(location1.equals(location2));
		assertFalse(location2.equals(location1));
		
		location2 = new Location("home", new SphericCoordinate(0.0, 0.0,earthRadius));
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
		
		location2 = new Location("home", new SphericCoordinate(0.0, 0.0000000000001,earthRadius));
		assertTrue(location1.equals(location2));
		assertTrue(location2.equals(location1));
	}

}
