package org.wahlzeit.model;

/**
 * 
 * @author B.Boesl
 *	A simple class to handle spheric coorindates.
 */
public class SphericCoordinate extends AbstractCoordinate{

	

	/**
	 * Spheric north coordinate in degree, for southern coordinates the value is negative
	 */
	public final double longitude;
	
	/**
	 * Spheric east coordinate in degree, for western coordinates the value is negative
	 */
	public final double latitude;
	
	
	/**
	 * 
	 */
	public final double radius;
	/**
	 * Spheric north coordinate in radians, for southern coordinates the value is negative
	 */
	public final double northRadians;
	
	/**
	 * Spheric east coordinate in radians, for western coordinates the value is negative
	 */
	public final double eastRadians;
	
	/**
	 * @methodtype constructor
	 * Constructor for Spheric Coordinates,
	 * @param longitude  in degree, negative for southern
	 * @param latitude in degree, negativ for southern;
	 */
	public SphericCoordinate(double longitude, double latitude, double radius){
		this.longitude = longitude;
		this.latitude  = latitude;
		this.radius = radius;
		northRadians = (longitude / 180) * Math.PI;
		eastRadians  = (latitude / 180) * Math.PI;
		
	}
	
	public CartesianCoordinate asCartesianCoordinate(){
		double x = radius* Math.sin(longitude)* Math.cos(latitude);
		double y = radius* Math.sin(longitude)* Math.sin(latitude);
		double z = radius*Math.cos(longitude);
		return new CartesianCoordinate(x,y,z);
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	
	
	/**
	 * @methodtype get
	 */
	public double getLongitude(){
		return longitude;
	}
	
	/**
	 * @methodtype set
	 */
	public double getlatitude(){
		return latitude;
	}
	
	public double getRadius(){
		return radius;
	}


	



	
	
}


