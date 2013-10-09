package com.vectors;

import com.angles.Angle;
import com.angles.Degree;
import com.angles.Radian;
import com.fractions.Fraction;
import com.points.Point;

public class Vector {
	
	/*
	 * Vector represented using polar coordinates
	 * */
	private Fraction magnitude = new Fraction("0");
	private Angle direction = new Degree("0");

	
	/*
	 * Vector represented using cartesian coordinates
	 * */
	private Point cartesianInfo = new Point("0,0,0");

	
	/*
	 * We will assume that we are using the
	 * cartesion coordinate representation of vectors by default
	 */
	public Vector( String cartesianInfo ) {
		super();
		setVector(cartesianInfo);
	}

	public Vector( Point cartesianInfo ) {
		super();
		setVector(cartesianInfo);
	}

	public Vector( Point start, Point end ) {
		super();
		setVector(start, end);
	}
	
	public Vector( Fraction magnitude, Degree direction ) {
		super();
		setVector(magnitude, direction);
	}

	public Vector( String magnitude, String direction ) {
		super();
		setVector(magnitude, direction);
	}
	
	public void setVector(String magnitude, String direction) 
	{
		setVector(new Fraction(magnitude), new Degree(direction));
	}

	public void setVector(String cartesianInfo)
	{
		setVector(new Point(cartesianInfo));		
	}
	
	public void setVector(Point cartesianInfo)
	{
		this.cartesianInfo = cartesianInfo;
		convertToPolar();		
	}

	public void setVector(Fraction magnitude, Degree direction)
	{
		this.magnitude = magnitude;
		this.direction = direction;
		
		convertToCart();
	}

	public void setVector(Point start,Point end)
	{
		this.cartesianInfo = end.sub(start);
		convertToPolar();		
	}

	public void setVector_p(String start,String end)
	{
		setVector(new Point(start), new Point(end));
	}
	
	private void convertToCart()
	{
		/*
		 * CONVERT TO CARTESIAN COORDINATES
		 * */
		
		Degree info = (Degree)direction;
		
		Fraction x = this.magnitude.mul( (float)info.toRadians().getValue().cos() );
		Fraction y = this.magnitude.mul( (float)info.toRadians().getValue().sin() );
		
		this.cartesianInfo = new Point(x+","+y);
	}

	private void convertToPolar() {
		/*
		 * CONVERT TO POLAR COORDINATES
		 * */
		this.magnitude = this.cartesianInfo.getX().mul(this.cartesianInfo.getX())
							.add(this.cartesianInfo.getY().mul(this.cartesianInfo.getY()))
							.add(this.cartesianInfo.getZ().mul(this.cartesianInfo.getZ())).root();
		this.direction = new Radian("" +this.cartesianInfo.getY().div(this.cartesianInfo.getX()).atan() );
		/*
		 * ADJUST OUR ANGLE IN THE EVENT IT LIES IN THE 2ND OR 3RD QUADRANT
		 * */
		if(this.cartesianInfo.getX().isLessThan("0"))
		{
			Degree buff = getDirection_deg();
			buff.setValue(buff.getValue().add("180"));
			this.direction = buff;
		}
		/*
		 * ADJUST OUR ANGLE IN THE EVENT IT LIES IN THE 4TH QUADRANT
		 * */
		else if( this.cartesianInfo.getX().isGreaterThan("0") && this.cartesianInfo.getY().isLessThan("0") )
		{
			Degree buff = getDirection_deg();
			buff.setValue(buff.getValue().add("360"));
			this.direction = buff;			
		}
			
		
	}
	
	public Fraction getMagnitude() {
		return magnitude;
	}

	public Angle getDirection() {
		return direction;
	}

	public Degree getDirection_deg() {
		
		Degree result = new Degree();
		if( direction instanceof Degree )
		{
			result = (Degree)direction;
		}
		else
		{
			Radian buff = (Radian)direction;
			result = buff.toDegrees_prec();
		}
		
		return result;
	}

	public Radian getDirection_rad() {
		Radian result = new Radian();
		if( direction instanceof Radian )
		{
			result = (Radian)direction;
		}
		else
		{
			Degree buff = (Degree)direction;
			result = buff.toRadians_prec();
		}
		
		return result;
	}
	
	public Point getCartesianInfo() {
		return cartesianInfo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Polar : " + magnitude + " @ " + getDirection_deg() + "\nCartesian : " + cartesianInfo;
	}

	public Vector add(Vector otherVector)
	{
		return addVecs(this, otherVector);
	}
	
	public Vector sub(Vector otherVector)
	{
		return subVecs(this, otherVector);
	}
	
	public Vector mul(Fraction scalar)
	{
		return new Vector(this.cartesianInfo.mul(scalar));
	}

	public Vector mul(String scalar)
	{
		return mul(new Fraction(scalar));
	}

	public Vector normalize()
	{
		return this.mul(this.magnitude.reciprical());
	}
	
	public Fraction dotProd( Vector otherVector )
	{
		Fraction x = this.cartesianInfo.getX().mul(otherVector.cartesianInfo.getX()),
				 y = this.cartesianInfo.getY().mul(otherVector.cartesianInfo.getY()),
				 z = this.cartesianInfo.getZ().mul(otherVector.cartesianInfo.getZ());
		return x.add(y).add(z);
	}
	
	public Vector crossProd(Vector otherVector)
	{
		Fraction x = this.cartesianInfo.getY().mul(otherVector.cartesianInfo.getZ()).sub(  this.cartesianInfo.getZ().mul(otherVector.cartesianInfo.getY())  )  ,
				 y = this.cartesianInfo.getZ().mul(otherVector.cartesianInfo.getX()).sub(  this.cartesianInfo.getX().mul(otherVector.cartesianInfo.getZ())  ),
				 z = this.cartesianInfo.getX().mul(otherVector.cartesianInfo.getY()).sub(  this.cartesianInfo.getY().mul(otherVector.cartesianInfo.getX())  );
		
		return new Vector(x+","+y+","+z);
	}
	
	public Radian angleOfRot( Vector otherVector )
	{
		return new Radian(this.dotProd(otherVector).div(this.magnitude.mul(otherVector.magnitude)).acos()+"");
	}

	public Degree angleOfRot_deg( Vector otherVector )
	{
		Radian buff = angleOfRot(otherVector);
		return buff.toDegrees();
	}
	
	
	public static Vector addVecs(Vector A, Vector B)
	{
		return new Vector(A.getCartesianInfo().add(B.getCartesianInfo()));
	}

	public static Vector subVecs(Vector A, Vector B)
	{
		return new Vector(A.getCartesianInfo().sub(B.getCartesianInfo()));
	}
	
	public static Vector newVector_p(String start, String end)
	{		
		Point a = new Point(start),
			  b = new Point(end);	
		return new Vector(b.sub(a));
	}
	
	public static Vector newVector_p(Point start, Point end)
	{		
		return new Vector(end.sub(start));
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Vector other = (Vector)obj;
		return this.cartesianInfo.equals(other.cartesianInfo);
	}
	
	
}
