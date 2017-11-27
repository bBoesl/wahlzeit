package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private static final double EPSILON = 0.00001;
	final double x,y,z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double r = Math.sqrt( x*x + y*y + z*z);
		double lat = Math.acos(z/r);
		double lon = Math.atan2(y, x);
		return new SphericCoordinate(lat,lon,r);
	}
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	
	
	
	

}
