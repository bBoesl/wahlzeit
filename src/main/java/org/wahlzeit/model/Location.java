package org.wahlzeit.model;

/**
 * 
 * @author B.Boesl
 * Class to link a Location-name to some geographic Coordinates
 */
public class Location {
	/**
	 * Name of the Location
	 */
	private String name;
	
	/**
	 * Spherical Coordinates of the Location
	 */
	private Coordinate coordinate;
	
	
	/**
	 * @methodtype constructor
	 * @param name, name of the Location;
	 * @param coordinate, coordinate of the Location
	 */
	public Location (String name, Coordinate coordinate){
		this.name = name;
		this.coordinate = coordinate;
	}
	
	/**
	 * @methodtype constructor
	 * @param name, name of the Location;
	 * @param north, spherical north coordinate in degree, negative if south;
	 * @param east,	 spherical east coordinate in degree, negative if west;
	 */
	public Location(String name, double north, double west){
		this(name, new Coordinate(north,west));
	}
	
	/**
	 * @methodtype constructor
	 * creates a location without coordinates
	 * @param name name of the location
	 */
	public Location(String name){
		this(name,null);
	}
	
	@Override
	/**
	 * @methodtype boolean-query
	 * Two Locations will be treated equal if they share the same name and are not too far apart,
	 * so that two Locations with name "E" will be equals if they are maximal 1km apart.
	 */
	public boolean equals(Object o){
		if(!(o instanceof Location)){
			return false;
		}
	
		Location toCompare = (Location) o;
		
		if(!  this.name.equals(toCompare.name)){
			return false;
		}
		
		if(this.coordinate == null && toCompare.coordinate != null ||
		   this.coordinate != null && toCompare.coordinate == null ){
			return false;
		}
		//because of the if above this.coordinate != null  implies toCompare.coordinate != null
		if(this.coordinate != null){
			if(this.coordinate.distanceTo(toCompare.coordinate) > 1.0){
				return false;
			}
		}
		return true;
	}
	
}
