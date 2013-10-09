package com.lines;

import com.fractions.Fraction;
import com.points.Point;

public class Line 
{
	/*
	 * A line is always in the form
	 * Ax + By = C
	 * */
	private Fraction A = new Fraction("0"),
					 B = new Fraction("0"),
					 C = new Fraction("0");
	
	public Line( String eqn ) {
		super();
		/*
		 * We assume that each entry is a fraction hence fractions a delimited by a / and 
		 * entries are delimited by a ,
		 * 
		 * The eqn should be in the form A,B,C again assuming a 
		 * standard line equation is in the form Ax + By = C
		 * */
		setEqn(eqn);
	}

	public void setEqn(String eqn)
	{
		String[] tokens = eqn.split(",");
		if( tokens.length == 3 )
		{
			this.A = new Fraction(tokens[0].trim());
			this.B = new Fraction(tokens[1].trim());
			this.C = new Fraction(tokens[2].trim());
		}
		else
		{
			System.err.println("Eqn size mismatch expected 3 entries recieved " + tokens.length + " entries\nInput string : " + eqn);
		}		
	}
	
	public Line(Fraction a, Fraction b, Fraction c) {
		super();
		A = a;
		B = b;
		C = c;
	}

	public Fraction getA() {
		return A;
	}

	public Fraction getB() {
		return B;
	}

	public Fraction getC() {
		return C;
	}

	public float getYcoordinate(float x)
	{
		Fraction buff = getYcoordinate(new Fraction(x+""));
		return buff.getNum()/buff.getDen();
	}

	public float getXcoordinate(float y)
	{
		Fraction buff = getXcoordinate(new Fraction(y+""));
		return buff.getNum()/buff.getDen();
	}

	public Fraction getYcoordinate(String x)
	{		
		return getYcoordinate(new Fraction(x));
	}

	
	public Fraction getYcoordinate(Fraction x)
	{
		/*
		 * We assume, that y = (c - Ax)/B
		 * */		
		return C.sub(A.mul(x)).div(B);
	}

	public Fraction getXcoordinate(String y)
	{		
		return getXcoordinate(y);
	}

	public Fraction getXcoordinate(Fraction y)
	{
		/*
		 * We assume, that x = (c - By)/A
		 * */		
		return C.sub(B.mul(y)).div(A);

	}
	
	public boolean isParallelTo(Line other)
	{
		/*
		 * Two lines are parallel if their slopes are equal
		 * */
		return this.getSlope().equals(other.getSlope());
	}
	
	public boolean isPerpendicularTo( Line other )
	{
		/*
		 * Two lines are perpendicular if 
		 * the product of their slopes is -1
		 * */
		Fraction exp = new Fraction("-1");
		return this.getSlope().mul(other.getSlope()).equals(exp);
	}
	
	public Fraction getPerpendicularSlope()
	{
		Fraction buff = new Fraction("-1");
		return buff.div(this.getSlope());
	}
	
	public Fraction getSlope()
	{
		/*
		 * m = -A/B
		 * */
		return this.A.neg().div(this.B);
	}
	
	/*
	 * This by default gets the equation in point-slope form
	 * i.e : y = mx + c
	 * */
	public static String getEquation( Point a, Point b )
	{	
		/*
		 * To calculate it we say
		 * m = slope
		 * c = -mx1+y1
		 * */
		Fraction m = a.getSlope(b);
		Fraction x1 = new Fraction(a.getX()+"");
		Fraction y1 = new Fraction(a.getY()+"");
		
		Fraction c = m.neg().mul(x1).add(y1);
		
		return "y = " + m + "x + " + c; 
	}

	public static String getEquation( Point a, Fraction m )
	{	
		/*
		 * To calculate it we say
		 * m = slope
		 * c = -mx1+y1
		 * */
		Fraction x1 = new Fraction(a.getX()+"");
		Fraction y1 = new Fraction(a.getY()+"");
		
		Fraction c = m.neg().mul(x1).add(y1);
		
		return "y = " + m + "x + " + c; 
	}
	
	public static Line getEquation_lineObj( Point a, Fraction m )
	{	
		/*
		 * To calculate it we say
		 * m = slope
		 * c = -mx1+y1
		 * */
		Fraction x1 = new Fraction(a.getX()+"");
		Fraction y1 = new Fraction(a.getY()+"");
		
		Fraction c = m.neg().mul(x1).add(y1);
		
		return new Line( (m.getNum()*-1)+","+m.getDen()+","+c); 
	}
	
	public static Line getEquation_lineObj( Point a, Point b )
	{	
		/*
		 * To calculate it we say
		 * m = slope
		 * c = -mx1+y1
		 * */
		Fraction m = a.getSlope(b);
		Fraction x1 = new Fraction(a.getX()+"");
		Fraction y1 = new Fraction(a.getY()+"");
		
		Fraction c = m.neg().mul(x1).add(y1);
		
		return new Line( (m.getNum()*-1)+","+m.getDen()+","+c); 
	}

	public static Line getEquation_lineObj_pts_str( String pt1, String pt2 )
	{	
		/*
		 * To calculate it we say
		 * m = slope
		 * c = -mx1+y1
		 * */
		Point a = new Point(pt1),b = new Point(pt2);
		Fraction m = a.getSlope(b);
		Fraction x1 = new Fraction(a.getX()+"");
		Fraction y1 = new Fraction(a.getY()+"");
		
		Fraction c = m.neg().mul(x1).add(y1);
		
		return new Line( (m.getNum()*-1)+","+m.getDen()+","+c); 
	}

	
	public static Fraction getSlope(String eqn)
	{
		return new Line(eqn).getSlope();
	}

	public static Point getIntersectionPoint(Line a, Line b) throws CoincidingLineException, ParrallelLineException
	{
		Fraction y = null, x= null;
		
		if( a.getSlope().equals(b.getSlope()) )
		{
			System.out.println("B1 yint = " + a.getYcoordinate("0") + "\nB2 yint = " + b.getYcoordinate("0"));
			if( a.getYcoordinate("0").equals(b.getYcoordinate("0")) )
			{	
				throw new CoincidingLineException("Line intersection check failed\nInfinite solutions found");
			}
			else
			{	
				throw new ParrallelLineException("Line intersection check failed\nZero solutions found");
			}
		
		}
		else
		{
			/*
			 * y = ( A1C2-A2C1 )/(A1B2-A2B1)
			 * x = ( B1C2-B2C1 )/(B1A2-B2A1)
			 * */
			y = 	//A1C2
							a.getA().mul(b.getC())
							//-
							.sub
							( 
								//A2C1	
								b.getA().mul(a.getC()) 
							)
							// /
							.div
							( 
								//A1B2	
								a.getA().mul(b.getB())
								//-
								.sub
								( 
									//A2B1	
									b.getA().mul(a.getB()) 
								)  
							);
			
			x = 	//B1C2
					       a.getB().mul(b.getC())
					       //-
					       .sub
					       (
					    	//B2C1
					    	b.getB().mul(a.getC())	   
					       )
					       // /
					       .div
					       (
					    		 //B1A2
					    		   a.getB().mul(b.getA())
					    		   //-
					    		   .sub
					    		   (
					    				//B2A1
					    				b.getB().mul(a.getA())   
					    		   )
					       );

		}
		
		
		return new Point(x.getFract_f(), y.getFract_f());
		
	}

	
	public static Point getIntersectionPoint(String a, String b) throws CoincidingLineException, ParrallelLineException 
	{		
		return getIntersectionPoint(new Line(a), new Line(b));
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Line buff = (Line) obj;
		
		return this.getA().equals(buff.getA()) &&
				this.getB().equals(buff.getB()) &&
				this.getC().equals(buff.getC());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n\nA : " + A + " \nB : " + B + " \nC : " + C;
	}
	
	
}
