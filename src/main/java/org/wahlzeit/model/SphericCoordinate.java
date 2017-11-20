package org.wahlzeit.model;

/**
 * 
 * @author B.Boesl
 *	A simple class to handle spheric coorindates.
 */
public class SphericCoordinate implements Coordinate{

	private static final double EPSILON = 0.00001;

	/**
	 * Spheric north coordinate in degree, for southern coordinates the value is negative
	 */
	private final double longitude;
	
	/**
	 * Spheric east coordinate in degree, for western coordinates the value is negative
	 */
	private final double latitude;
	
	
	/**
	 * 
	 */
	private final double radius;
	/**
	 * Spheric north coordinate in radians, for southern coordinates the value is negative
	 */
	private final double northRadians;
	
	/**
	 * Spheric east coordinate in radians, for western coordinates the value is negative
	 */
	private final double eastRadians;
	
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
	
	
	@Override
	/**
	 * @methodtype boolean-query
	 * Two coordinates will be treated as equals 
	 * if and only if both coordinates are the same
	 * is forwarded to isEqual(), because of the assignment...
	 */
	public boolean equals(Object o){
		return isEqual(o);
	}
	
	private boolean isEqual(Object o){
		if(!(o instanceof SphericCoordinate)){
			return false;
		}
		SphericCoordinate objectToCompare = (SphericCoordinate) o;
		
		if(objectToCompare.longitude -  this.longitude < EPSILON){
			return false;
		}
		
		if(objectToCompare.latitude - this.latitude < EPSILON){
			return false;
		}
		
		if(objectToCompare.radius - this.radius < EPSILON){
			return false;
		}
		return true;
	}
	
	/**
	 * @methodtype double-query
	 * Returns the distance across the surface of the earth to the given coordinate
	 * @param coord Coordinate to calculate the distance to.
	 * @return distance in Km
	 */
	public double getSphericDistance(Coordinate coordinate){
		SphericCoordinate coord = coordinate.asSphericCoordinate();
		//Done with some trigonometry:
		double distanceOnUnitsphere;
		
		distanceOnUnitsphere =	
				Math.acos(Math.sin(this.northRadians) * Math.sin(coord.northRadians) +
						Math.cos(this.northRadians) * Math.cos(coord.northRadians) *
						Math.cos(coord.eastRadians - this.eastRadians )
				);
		
		return radius * distanceOnUnitsphere;
	}
	
	public CartesianCoordinate asCartesianCoordinate(){
		double x = radius* Math.sin(longitude)* Math.cos(latitude);
		double y = radius* Math.sin(longitude)* Math.sin(latitude);
		double z = radius*Math.cos(longitude);
		return new CartesianCoordinate(x,y,z);
	}
	
	public double getCartesianDistance(Coordinate coord){
		return coord.getCartesianDistance(asCartesianCoordinate());
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


	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}


	@Override
	public double getDistance(Coordinate coordinate) {
		return getSphericDistance(coordinate);
	}


	@Override
	public boolean isEqual(Coordinate coordinate) {
		
		return isEqual((Object)coordinate);
	}
	
	
}


