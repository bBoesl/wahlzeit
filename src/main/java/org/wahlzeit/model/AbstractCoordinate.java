package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	
	private static final double EPSILON = 0.00001;

	
	/**
	 * Asserts class invaraiants.
	 */
	protected abstract void assertInvariant();
	
	protected void myAssertArg(boolean b) {
		if(!b){
			throw new IllegalArgumentException();
		}
		
	}
	protected void myAssertError(boolean b) {
		if(!b){
			throw new Error();
		}
		
	}
	
	protected void myAssertState(boolean b){
		if(! b){
			throw new IllegalStateException();
		}
	}
	
	
	
	protected  double doGetDistance(Coordinate coordinate){
		return  this.getCartesianDistance(coordinate);
	}
	/**
	 * methodtype double-query
	 * Returns the euclidian distance.
	 * @param coordinate : the coordinate to compute the distance to
	 */
	public double getDistance(Coordinate coordinate){
		myAssertArg(coordinate != null);
		assertInvariant();
		double ret = this.getDistance(coordinate);
		assertInvariant();
		return ret;
	}
	
	protected double doGetCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate me = this.asCartesianCoordinate();
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		double difx = me.x - coord.getX();
		double dify = me.y - coord.getY();
		double difz = me.z - coord.getZ();
		return Math.sqrt(difx * difx + dify * dify + difz + difz);
	}
	

	/**
	 * @methodtype double-query
	 * @param  coordinate the
	 *            Coordinate to compute the distance to. The usual euclidian
	 *            Distance
	 */
	public double getCartesianDistance(Coordinate coordinate){
		assert(coordinate != null);
		assertInvariant();
		double ret = this.doGetCartesianDistance(coordinate);
		assertInvariant();
		return ret;
	}

	/**
	 * @methodtype double-query Returns the distance across the surface of the
	 *             earth to the given coordinate
	 * @param coord
	 *            Coordinate to calculate the distance to.
	 * @return distance in Km
	 */
	public double getSphericDistance(Coordinate coordinate){
		myAssertArg(coordinate != null);
		assertInvariant();
		double ret = this.doGetSphericDistance(coordinate);
		assertInvariant();
		return ret;
	}
	
	



	protected double doGetSphericDistance(Coordinate coordinate) {
		SphericCoordinate coord = coordinate.asSphericCoordinate();
		SphericCoordinate me = this.asSphericCoordinate();
		// Done with some trigonometry:
		double distanceOnUnitsphere;

		distanceOnUnitsphere = Math
				.acos(Math.sin(me.latitude) * Math.sin(coord.latitude) + Math.cos(me.latitude)
						* Math.cos(coord.latitude) * Math.cos(coord.longitude - me.longitude));

		return me.radius * distanceOnUnitsphere;
	}
	
	

	@Override
	/**
	 * @methodtype boolean-query Two coordinates will be treated as equals if
	 *             and only if both coordinates are the same is forwarded to
	 *             isEqual(), because of the assignment...
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Coordinate)) {
			return false;
		}
		return isEqual((Coordinate)o);
	}

	public boolean isEqual(Coordinate coordinate) {
		if(this.getDistance(coordinate) > EPSILON){
			return false;
		}
		return true;
	}
}
