/**
 * @author Daniel Renaud;
 * */

/**
 * The Point class creates a coordinate on an xy-axis to be used in the Triangle
 * class.
 */
public class Point {
	private int x;
	private int y;
	private int id;
	private static int idCounter = 0;

	/**
	 * constructor for the Point class
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.id = ++idCounter;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * toString method to display all the fields of the class instance.
	 */
	@Override
	public String toString() {
		return "\n Point [x=" + x + ", y=" + y + ", id=" + id + "]";
	}

	/**
	 * A hashCode method for the class.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/**
	 * An equals method that returns true only if both points have the same id.
	 */
	@Override
	public boolean equals(Object point) {
		if (this == point) {
			return true;
		}
		if (point == null) {
			return false;
		}
		if (getClass() != point.getClass()) {
			return false;
		}
		Point other = (Point) point;
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
