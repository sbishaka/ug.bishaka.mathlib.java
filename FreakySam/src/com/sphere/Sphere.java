package com.sphere;

import com.fractions.Fraction;
import com.points.Point;

/*
 * A LITTLE MATH
 * Equation of a circle is defined by 
 * (x–h)^2 + (y–k)^2 = r^2
 * where the center is (h,k) and the radius is r
 * 
 * Equation of a sphere is defined by
 * (x–h)^2 + (y–k)^2 + (z–l)^2 = r^2
 *
 * where the center is (h,k,l) and the radius is r.
 * */

public class Sphere {

	Point center = new Point("0,0,0");
	Fraction radius = new Fraction("0");
	
	public Sphere(Point center, Fraction radius) {
		super();
		setSphere_radius(center, radius);
	}
	
	public Sphere(Point center, Point farthestVertext) {
		super();
		setSphere_point(center, farthestVertext);
	}

	public Sphere(String h, String k, String r) {
		super();
		setSphere_eqn(h, k, "0", r);
	}

	public Sphere(String h, String k, String l,  String r) {
		super();
		setSphere_eqn(h, k, l, r);
	}

	
	public Sphere()
	{
		
	}
	
	
	
	public Point getCenter() {
		return center;
	}

	public Fraction getRadius() {
		return radius;
	}

	public static boolean collisionBetweenSpheres( Sphere one, Sphere two )
	{
		/*
		 * We use this algorithm
		 * (h2–h1)^2 + (k2–k1)^2 + (l2–l1)^2 < (r1+r2)^2 there is a collision
		 * */
		Fraction distanceBtnCenters = one.getCenter().distanceFrom(two.getCenter());
				 
		Fraction sumRadi = one.radius.add(two.radius);
		return  distanceBtnCenters.isLessThan(sumRadi)||distanceBtnCenters.equals(sumRadi);
	}
	
	
	/*
	 * Since the equation of a sphere contains the equation of a circle, 
	 * we'll us it to represent both circles and spheres
	 * */
	public String getEqn()
	{
		return "(x–"+center.getX()+")^2 + (y–"+center.getY()+")^2 + (z–"+center.getZ()+")^2= "+radius+"^2";
	}

	public void setSphere_eqn( String h, String k, String l,  String r)
	{
		setSphere_radius(new Point(h+","+k+","+l), new Fraction(r));
	}

	
	public void setSphere_point( String center, String farthestVertext)
	{
		setSphere_point(new Point(center), new Point(farthestVertext));
	}
	
	public void setSphere_point( Point center, Point farthestVertext)
	{
		this.center = center;
		this.radius = center.distanceFrom_minusRoot(farthestVertext);
	}

	public void setSphere_radius( String center, String radius )
	{
		setSphere_radius(new Point(center), new Fraction(radius));
	}
	
	public void setSphere_radius( Point center, Fraction radius )
	{
		this.center = center;
		this.radius = radius;
	}
	
	public boolean collidesWith(Sphere anotherSphere)
	{
		return collisionBetweenSpheres(this, anotherSphere);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if( !( obj instanceof Sphere ) )
			throw new ClassCastException("A sphere object is expected");
		
		Sphere anotherSphere = (Sphere)obj;
		return this.getCenter().equals(anotherSphere.getCenter()) && this.getRadius().equals(anotherSphere.getRadius());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Center : " + center + " Radius : " + radius;
	}
	
	
	
}
