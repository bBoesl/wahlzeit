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
	public SphericCoordinate(double latitude, double longitude, double radius){
		this.latitude = latitude;
		this.longitude  = longitude;
		this.radius = radius;
		assertInvariant("Invalid constructor arguements of Spheric Coordiante");
	
		
	}
	
	@Override
	protected void assertInvariant(String message){
		myAssertState( - Math.PI < longitude  && longitude < Math.PI, message);
		myAssertState( - Math.PI < latitude  && latitude < Math.PI,message);
		myAssertState( radius >= 0, message);
	}
	
	
	private CartesianCoordinate doAsCartesianCoordinate(){
		double x = radius* Math.sin(latitude)* Math.cos(longitude);
		double y = radius* Math.sin(latitude)* Math.sin(longitude);
		double z = radius*Math.cos(latitude);
		return (CartesianCoordinate) getCoordinate(x,y,z,true);
	} 
	
	public CartesianCoordinate asCartesianCoordinate(){
		//no preconditions besides the invariant, even that isnt needet, because everything is final.
		assertInvariant("SphericCoordinate state is broken");
		CartesianCoordinate ret =  doAsCartesianCoordinate();
		//postCondition
		myAssertError(ret != null, "asCartesianCoordinate() returned null");
		myAssertError(ret.equals(this),"asCartesianCoordinate() returned something not equal" );
		assertInvariant("SphericCoordinate state is broken after asCartesianCoordinate()");
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


