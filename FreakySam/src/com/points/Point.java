package com.points;

import com.fractions.Fraction;
import com.matrix.Matrix;
import com.matrix.MatrixException;

public class Point {
	
	Fraction x = new Fraction("0"),
			  y = new Fraction("0"), 
			  z = new Fraction("0");



	
	public Point(Fraction x, Fraction y, Fraction z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point(Fraction x, Fraction y ) {
		super();
		this.x = x;
		this.y = y;
	}

	
	public Point(String points) {
		super();
		setPoint(points);
	}

	public Point(float x, float y) {
		super();
		this.x = new Fraction(x+"");
		this.y = new Fraction(y+"");
	}
	
	public Point(float x, float y, float z) {
		super();
		this.x = new Fraction(x+"");
		this.y = new Fraction(y+"");
		this.z = new Fraction(z+"");
	
	}

	public Fraction getX() {
		return x;
	}

	public Fraction getY() {
		return y;
	}

	public Fraction getZ() {
		return z;
	}
	
	public Point add(Point p)
	{	
		return new Point((this.getX().add(p.getX()))+","+(this.getY().add(p.getY()))+","+(this.getZ().add(p.getZ())));
	}

	public Point sub(Point p)
	{	
		return new Point((this.getX().sub(p.getX()))+","+(this.getY().sub(p.getY()))+","+(this.getZ().sub(p.getZ())));
	}

	public Point mul(Fraction scalar)
	{	
		return new Point((this.getX().mul(scalar)+","+(this.getY().mul(scalar)+","+(this.getZ().mul(scalar)))));
	}
	
	public Fraction getSlope(Point other)
	{
		float dy = other.getY().sub(this.getY()).getFract_f();
		float dx = other.getX().sub(this.getX()).getFract_f();
		
		return new Fraction(dy, dx);
	}
	
	public Fraction distanceFrom(Point other)
	{
		return distanceBetweenPoints(this, other);
	}
	
	public static Fraction distanceBetweenPoints( String a, String b )
	{
		return distanceBetweenPoints(new Point(a), new Point(b));
	}
		
	public static Fraction distanceBetweenPoints( Point a, Point b )
	{
		Fraction x = b.getX().sub(a.getX());
				x = x.mul(x);
		
		Fraction y = b.getY().sub(a.getY());
				 y = y.mul(y);
		
		Fraction z = b.getZ().sub(a.getZ());
		 z = z.mul(z);
				 
		return  x.add(y).add(z).root();
	}

	public Fraction distanceFrom_minusRoot( Point a)
	{
		return distanceBetweenPoints_minusRoot(this, a);
	}

	public Fraction distanceFrom_minusRoot( String a)
	{
		return distanceBetweenPoints_minusRoot(this, new Point(a));
	}
	
	public static Fraction distanceBetweenPoints_minusRoot( String a, String b )
	{				 
		return distanceBetweenPoints_minusRoot(new Point(a), new Point(b));
	}
	
	public static Fraction distanceBetweenPoints_minusRoot( Point a, Point b )
	{
		Fraction x = b.getX().sub(a.getX());
				 x = x.mul(x);
		Fraction y = b.getY().sub(a.getY());
		 		 y = y.mul(y);	
		Fraction z = b.getZ().sub(a.getZ());
				 z = z.mul(z);
				 				 
		return x.add(y).add(z);
	}
	
	public Point midPoint(String anotherPoint)
	{
		return getMidPoint(this, new Point(anotherPoint));
	}

	public Point midPoint(Point anotherPoint)
	{
		return getMidPoint(this,anotherPoint);
	}

	public static Point getMidPoint( String a, String b )
	{		
		return getMidPoint(new Point(a), new Point(b));
	}

	public static Point getMidPoint( Point a, Point b )
	{
		Fraction div = new Fraction("2");
		Fraction x = a.getX().add(b.getX()).div(div);
		Fraction y = a.getY().add(b.getY()).div(div);
		Fraction z = a.getZ().add(b.getZ()).div(div);
		
		return new Point(x,y,z);
	}
	
	public void setPoint(String points)
	{
		String[] tokens = points.split(",");
		/*
		 * CLEAR PREVIOUS DATA
		 * */
		this.x.setFraction("0");
		this.y.setFraction("0");
		this.z.setFraction("0");
		
		if(tokens.length == 1)
		{
			this.x.setFraction(tokens[0]);
		}
		else if(tokens.length == 2)
		{
			this.x.setFraction(tokens[0]);
			this.y.setFraction(tokens[1]);
		}
		else if( tokens.length == 3 )
		{
			this.x.setFraction(tokens[0]);
			this.y.setFraction(tokens[1]);
			this.z.setFraction(tokens[2]);
		}
		else
		{
			System.err.println("Failed to initialize point values : " + points + "\nValues set to 0,0,0");
		}
	}

	public void setPoint(Point otherPoint)
	{
		this.x = otherPoint.x;
		this.y = otherPoint.y;
		this.z = otherPoint.z;
	}

	public Point transformPoint(Matrix... transforms)
	{
		Matrix result = null;
		Matrix point = new Matrix("0\n0\n0\n1");
		point.setEntry(0, 0, this.getX());
		point.setEntry(1, 0, this.getY());
		point.setEntry(2, 0, this.getZ());
		
		int count = 0;	
		
		for( Matrix transform:transforms )
		{
			if( count == 0 )
			{
				result = transform;
				count++;
			}
			else
			{
				try {
					result = result.mul(transform);
				} catch (MatrixException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		try {
			result = result.mul(point);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result.getEntry(2, 0).getFract_f(1));
		
		return new Point(result.getEntry(0, 0)+","+result.getEntry(1, 0)+","+result.getEntry(2, 0));
	}
	
	public void transform(Matrix... transforms)
	{
		setPoint( transformPoint(transforms) );
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "( "+this.x+", "+this.y+", "+this.z+" )";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Point buff = (Point)obj;		
		return ( this.getX().equals(buff.getX()) && this.getY().equals(buff.getY()) && this.getZ().equals(buff.getZ()) );
	}
	
	public static Fraction getSlope(String a, String b)
	{
		Point p1 = new Point(a), p2 = new Point(b);
		return p1.getSlope(p2);
	}

}
