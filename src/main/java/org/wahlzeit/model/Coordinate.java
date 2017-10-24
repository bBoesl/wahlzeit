package org.wahlzeit.model;

/**
 * 
 * @author B.Boesl
 *	A simple class to handle spheric coorindates.
 */
public class Coordinate {

	/**
	 * Spheric north coordinate in degree, for southern coordinates the value is negative
	 */
	private final double north;
	
	/**
	 * Spheric east coordinate in degree, for western coordinates the value is negative
	 */
	private final double east;
	
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
	 * @param north  in degree, negative for southern
	 * @param east in degree, negativ for southern;
	 */
	public Coordinate(double north, double east){
		this.north = north;
		this.east  = east;
		northRadians = (north / 180) * Math.PI;
		eastRadians  = (east / 180) * Math.PI;
	}
	
	
	@Override
	/**
	 * @methodtype boolean-query
	 * Two coordinates will be treated as equals 
	 * if and only if both coordinates are the same
	 */
	public boolean equals(Object o){
		if(!(o instanceof Coordinate)){
			return false;
		}
		Coordinate objectToCompare = (Coordinate) o;
		
		if(objectToCompare.north != this.north){
			return false;
		}
		
		if(objectToCompare.east != this.east){
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
	public double distanceTo(Coordinate coord){
		//Done with some trigonometry:
		double radiusEarth = 6378.388;
		double distanceOnUnitsphere;
		
		distanceOnUnitsphere =	
				Math.acos(Math.sin(this.northRadians) * Math.sin(coord.northRadians) +
						Math.cos(this.northRadians) * Math.cos(coord.northRadians) *
						Math.cos(coord.eastRadians - this.eastRadians )
				);
		
		return radiusEarth * distanceOnUnitsphere;
	}
	
	
	/**
	 * @methodtype get
	 */
	public double getNorth(){
		return north;
	}
	
	/**
	 * @methodtype set
	 */
	public double getEast(){
		return east;
	}
	
	
}


