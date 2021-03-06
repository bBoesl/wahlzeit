package org.wahlzeit.model;

public interface Coordinate {

	public SphericCoordinate asSphericCoordinate();
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate coordinate);
	public double getSphericDistance(Coordinate coordinate);
	public double getDistance(Coordinate coordinate);
	
	public boolean isEqual(Coordinate coordiante);
}
