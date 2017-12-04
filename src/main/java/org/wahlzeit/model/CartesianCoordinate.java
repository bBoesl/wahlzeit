package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate{

	private static final double EPSILON = 0.00001;
	final double x,y,z;
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assertInvariant();
	}
	
	@Override
	protected void assertInvariant() {
		myAssertState(y != Double.NaN && y != Double.NEGATIVE_INFINITY && y != Double.POSITIVE_INFINITY);
		myAssertState(y != Double.NaN && y != Double.NEGATIVE_INFINITY && y != Double.POSITIVE_INFINITY);
		myAssertState(y != Double.NaN && y != Double.NEGATIVE_INFINITY && y != Double.POSITIVE_INFINITY);
	}
	
	
	
	private SphericCoordinate doAsSphericCoordinate() {
		double r = Math.sqrt( x*x + y*y + z*z);
		double lat = Math.acos(z/r);
		double lon = Math.atan2(y, x);
		return new SphericCoordinate(lat,lon,r);
	}
	
	public SphericCoordinate asSphericCoordinate(){
		assertInvariant();
		SphericCoordinate ret = this.doAsSphericCoordinate();
		myAssertError(ret != null);
		myAssertError(ret.equals(this));
		assertInvariant();
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
