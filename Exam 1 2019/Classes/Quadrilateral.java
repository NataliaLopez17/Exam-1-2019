import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

/**
 * Mutable class to represent Quadrilaterals in the real plane.
 * 
 * A Quadrilateral is represented by four points in the plane 
 * p1, p2, p3 and p4. Each point in the plane has two coordinates 
 * <x,y> as usual. The four edges of the Quadrilateral are 
 * given by the segments <p1,p2>, <p2,p3>, <p3, p4> and <p4,p1>.
 * 
 * IMPORTANT: Quadrilaterals DO NOT share Point objects among 
 * themselves.  Every Quadrilaral must have its own set of Points 
 * that are separate instances from the points of other Quadrilaterals.
 */
public class Quadrilateral {
	
	private Point2D.Double p1;
	private Point2D.Double p2;
	private Point2D.Double p3;
	private Point2D.Double p4;
	
	// Constructors
	public Quadrilateral(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3, Point2D.Double p4) {
		super();
		this.p1 = (Point2D.Double) p1.clone();
		this.p2 = (Point2D.Double) p2.clone();
		this.p3 = (Point2D.Double) p3.clone();
		this.p4 = (Point2D.Double) p4.clone();
	}
	
	/**
	 * Exercise #1 
	 * Returns a copy of the parameter Quadrilateral with COPIES
	 * of its points.  
	 * Note: The new Quadrilateral should not share any
	 * instances of Points with the original (parameter) Quadrilateral.
	 */
	public Quadrilateral(Quadrilateral q) {
		this.p1 = (Point2D.Double) q.p1.clone();
		this.p2 = (Point2D.Double) q.p2.clone();
		this.p3 = (Point2D.Double) q.p3.clone();
		this.p4 = (Point2D.Double) q.p4.clone();
	}
	
	/**
	 * Exercise #2 
	 * Returns a new Quadrilateral equivalent to the parameter
	 * Rectangle.  
	 * The four points of the Quadrilateral should
	 * coincide with the four points of the Rectangle.  
	 * In
	 * particular point p1 in the Quadrilateral should coincide
	 * with the upper left corner point in the Rectangle.
	 */
	public Quadrilateral(Rectangle r) {
		this.p1 = new Point2D.Double(r.getLocation().getX(), r.getLocation().getY());
		this.p2 = new Point2D.Double(r.getLocation().getX() + r.getWidth(), r.getMaxY() - r.getHeight());
		this.p3 = new Point2D.Double(r.getMaxX(), r.getMaxY());
		this.p4 = new Point2D.Double(r.getMinX(), r.getMinY()+ r.getHeight());
	}

	// Getters
	public Point2D.Double getP1() { return p1; }
	public Point2D.Double getP2() { return p2; }
	public Point2D.Double getP3() { return p3; }
	public Point2D.Double getP4() { return p4; }

	// Instance Methods
	 
	public String toString() {
		return "<" + this.getP1() + this.getP2() + this.getP3() + this.getP4() + " >";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Quadrilateral) {
			Quadrilateral q = (Quadrilateral) o;
			return q.getP1().equals(this.getP1()) &&
					q.getP2().equals(this.getP2()) &&
					q.getP3().equals(this.getP3()) &&
					q.getP4().equals(this.getP4());
		}
		return false;
	}
	
	/**
	 * Exercise #3
	 * Returns the perimeter of the target Quadrilateral
	 * 
	 * The perimeter is the sum of the lengths of the four
	 * edges of the Quadrilateral.
	 */
	public double getPerimeter() {
		// YOUR CODE HERE
		return this.getP1().distance(getP2()) + this.getP2().distance(getP3())
				+ this.getP3().distance(getP4()) + this.getP4().distance(getP1()); 
	}
	
	/**
	 * Exercise #4
	 * Modifies the target Quadrilateral by moving all its Points by deltaX 
	 * units horizontally and deltaY unit vertically.  Both deltas
	 * can be either positive, negative or zero.
	 * 
	 */
	public Quadrilateral move(double deltaX, double deltaY) {
		this.p1 = new Point2D.Double(p1.getX() + deltaX, p1.getY() + deltaY);
		
		this.p2 = new Point2D.Double(p1.getX(), p1.getY() + deltaY);
		return this; // Leave this return as is since method should return target object
	}
	
	/**
	 * Returns the area of a triangle given the lengths of its three sides
	 * using Heron's formula.
	 */
	private static double triangleArea(double s1, double s2, double s3) {
		double s = (s1 + s2 + s3) / 2.0;
		return Math.sqrt(s * (s-s1) * (s-s2) * (s-s3));
	}
	
	/**
	 * Exercise #5
	 * Returns the area of the target quadrilateral by dividing it in two
	 * triangles <p1, p3, p4> and <p1, p2, p3>.  You may assume that the
	 * target Quadrilateral is convex, that is, it can be divided in two
	 * triangles by adding a segment from opposite points.
	 */
	public double getArea() {
		double t1 = Quadrilateral.triangleArea(p1.distance(getP3()), p3.distance(getP4()), p4.distance(getP1()));
		double t2 = Quadrilateral.triangleArea(p1.distance(getP2()), p2.distance(getP3()), p3.distance(getP1()));
		return t1 + t2; // Dummy return
	}	
	
}