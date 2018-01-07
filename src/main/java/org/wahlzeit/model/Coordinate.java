package org.wahlzeit.model;

import org.wahlzeit.anonntations.PatternInstance;


public interface Coordinate {
	public Coordinate getCoordinate(double x, double y,double z, boolean cartesian);
	public SphericCoordinate asSphericCoordinate();
	public CartesianCoordinate asCartesianCoordinate();
	 	
	public double getCartesianDistance(Coordinate coordinate);
	public double getSphericDistance(Coordinate coordinate);
	public double getDistance(Coordinate coordinate);
	
	public boolean isEqual(Coordinate coordiante);
	
	
}


