package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private static final double EPSILON = 0.00001;
	final double x,y,z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertInvariant("Invalid constructor arguements of Cartesian coodirnate");
	}
	
	@Override
	protected void assertInvariant(String message) {
		myAssertState(x != Double.NaN && x != Double.NEGATIVE_INFINITY && x != Double.POSITIVE_INFINITY, message);
		myAssertState(y != Double.NaN && y != Double.NEGATIVE_INFINITY && y != Double.POSITIVE_INFINITY, message);
		myAssertState(z != Double.NaN && z != Double.NEGATIVE_INFINITY && z != Double.POSITIVE_INFINITY, message);
	}
	
	
	
	private SphericCoordinate doAsSphericCoordinate() {
		double r = Math.sqrt( x*x + y*y + z*z);
		double lat = Math.acos(z/r);
		double lon = Math.atan2(y, x);
		return new SphericCoordinate(lat,lon,r);
	}
	
	public SphericCoordinate asSphericCoordinate(){
		assertInvariant("CartesianCoordinate state is broken");
		SphericCoordinate ret = this.doAsSphericCoordinate();
		myAssertError(ret != null, "asSphericCoordinate returned null");
		myAssertError(ret.equals(this), "asSphericCoordinate() returned somting not equals");
		assertInvariant("CartesianCoordinate state is broken after asSphericCoordinate()");
		return ret;
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
