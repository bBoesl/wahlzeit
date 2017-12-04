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
	public final double latitude;
	
	/**
	 * Spheric east coordinate in degree, for western coordinates the value is negative
	 */
	public final double longitude;
	
	
	/**
	 * 
	 */
	public final double radius;
	
	
	/**
	 * @methodtype constructor
	 * Constructor for Spheric Coordinates,
	 * @param longitude  in degree, negative for southern
	 * @param latitude in degree, negativ for southern;
	 * 
	 *@pre:longitude and latitude are between -Pi and Pi, radius > 0  
	 */
	public SphericCoordinate(double longitude, double latitude, double radius){
		this.latitude = longitude;
		this.longitude  = latitude;
		this.radius = radius;
		assertInvariant();
	
		
	}
	
	@Override
	protected void assertInvariant(){
		myAssertState( - Math.PI < longitude  && longitude < Math.PI);
		myAssertState( - Math.PI < latitude  && latitude < Math.PI);
		myAssertState( radius >= 0);
	}
	
	
	private CartesianCoordinate doAsCartesianCoordinate(){
		double x = radius* Math.sin(latitude)* Math.cos(longitude);
		double y = radius* Math.sin(latitude)* Math.sin(longitude);
		double z = radius*Math.cos(latitude);
		return new CartesianCoordinate(x,y,z);
	} 
	
	public CartesianCoordinate asCartesianCoordinate(){
		//no preconditions besides the invariant, even that isnt needet, because everything is final.
		assertInvariant();
		CartesianCoordinate ret =  doAsCartesianCoordinate();
		//postCondition
		myAssertError(ret != null);
		myAssertError(ret.equals(this));
		assertInvariant();
		return ret;
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}
	
	
	
	/**
	 * @methodtype get
	 */
	public double getLongitude(){
		return latitude;
	}
	
	/**
	 * @methodtype set
	 */
	public double getlatitude(){
		return longitude;
	}
	
	public double getRadius(){
		return radius;
	}
	
	

	



	
	
}


