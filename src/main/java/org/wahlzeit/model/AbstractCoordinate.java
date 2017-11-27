package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	
	private static final double EPSILON = 0.00001;

	
	/**
	 * methodtype double-query
	 * Returns the euclidian distance.
	 * @param coordinate : the coordinate to compute the distance to
	 */
	public double getDistance(Coordinate coordinate){
		return  this.getCartesianDistance(coordinate);
	}
	/**
	 * @methodtype double-query
	 * @param  coordinate the
	 *            Coordinate to compute the distance to. The usual euclidian
	 *            Distance
	 */
	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		CartesianCoordinate me = this.asCartesianCoordinate();
		CartesianCoordinate coord = coordinate.asCartesianCoordinate();
		double difx = me.x - coord.getX();
		double dify = me.y - coord.getY();
		double difz = me.z - coord.getZ();
		return Math.sqrt(difx * difx + dify * dify + difz + difz);
	}

	/**
	 * @methodtype double-query Returns the distance across the surface of the
	 *             earth to the given coordinate
	 * @param coord
	 *            Coordinate to calculate the distance to.
	 * @return distance in Km
	 */
	public double getSphericDistance(Coordinate coordinate) {
		SphericCoordinate coord = coordinate.asSphericCoordinate();
		SphericCoordinate me = this.asSphericCoordinate();
		// Done with some trigonometry:
		double distanceOnUnitsphere;

		distanceOnUnitsphere = Math
				.acos(Math.sin(me.northRadians) * Math.sin(coord.northRadians) + Math.cos(me.northRadians)
						* Math.cos(coord.northRadians) * Math.cos(coord.eastRadians - me.eastRadians));

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
