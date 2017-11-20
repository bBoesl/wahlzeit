package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{

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
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		double difx = x - coord.getX();
		double dify = y - coord.getY();
		double difz = z - coord.getZ();
		return Math.sqrt(difx*difx + dify * dify + difz +difz);
	}
	@Override
	public double getSphericDistance(Coordinate coordinate) {
		return asSphericCoordinate().getSphericDistance(coordinate);
	}
	@Override
	public double getDistance(Coordinate coordinate) {
		return getCartesianDistance(coordinate);
	}
	
	public boolean euqlas(Object o){
		return this.isEqual(o);
	}
	
	public boolean isEqual(Object o){
		if(!(o instanceof CartesianCoordinate)){
			return false;
		}
		CartesianCoordinate toCompare = (CartesianCoordinate) o;
		if(toCompare.getX() - x > EPSILON || toCompare.getY() - y > EPSILON || toCompare.getZ() - z > EPSILON){
			return false;
		}
		return true;
		
	}
	@Override
	public boolean isEqual(Coordinate coordinate) {
		return isEqual((Object) coordinate);
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
