package com.fractions;

import java.text.DecimalFormat;

import com.angles.Angle;

public class Fraction implements Comparable{
	
	private float num = 0, den = 0;
		
	public Fraction( String fraction ) {
		super();
		setFraction(fraction);
	}

	public Fraction(float num, float den) {
		super();
		this.num = num;
		this.den = den;
		normalize();
	}

	public Fraction(Angle angle)
	{
		this.num = angle.getValue().num;
		this.den = angle.getValue().den;
		normalize();
	}
	
	public float getNum() {
		return num;
	}

	public float getDen() {
		return den;
	}

	public void setFraction(String fraction)
	{
		String[] tokens = null;
		String delim = "/";
		
		try{
			tokens = fraction.split(delim);
		}
		catch(NumberFormatException nfe)
		{
			System.err.println("Failed to split string : " + fraction + "\nExpect delimiter : " + delim);
		}
		
		if(tokens.length == 1)
		{
			try
			{
				this.num = Float.parseFloat(tokens[0]);
			}
			catch(NumberFormatException nfe)
			{
				System.err.println("Failed to parse num " + nfe.getMessage());
			}
			
			
			this.den = 1;
		}
		else if( tokens.length == 2 )
		{
			this.num = Float.parseFloat(tokens[0]);
			this.den = Float.parseFloat(tokens[1]);
		}
			
		normalize();	
	}

	private void normalize()
	{
		/*
		 * Handle cases involving 0
		 * */
		if( this.num == 0 || this.den == 0 )
		{
			num = 0;
			den = 1;
		}
		
		/*
		 * Put neg sign on numerator only
		 * */
		if( this.den < 0 )
		{
			this.den *= -1;
			this.num *= -1;
		}
		
		/*
		 * Factor out GCF from numerator and denominator
		 * */
		float n = gcf(num, den);
		this.num /= n;
		this.den /= n;
	}
	
	public static float gcf( float a, float b )
	{
		if( b == 0 )
			return Math.abs(a);
		else
			return gcf(b, a%b);
	}

	public static float lcm( float a, float b )
	{
		return ( a/gcf(a,b))*b;
	}

	public double sin()
	{
		return Math.sin(getFract_f());
	}

	public double asin()
	{
		return Math.asin(getFract_f());
	}

	public double tan()
	{
		return Math.tan(getFract_f());
	}
	
	public double atan()
	{
		return Math.atan(getFract_f());
	}
	
	public double cos()
	{
		return Math.cos(getFract_f());
	}
	
	public double acos()
	{
		return Math.acos(getFract_f());
	}

	public Fraction add( Fraction other )
	{
		float lcd = lcm( this.getDen(), other.getDen() );
		float quotient1 = lcd/this.getDen();
		float quotient2 = lcd/other.getDen();
		
		return new Fraction(( this.getNum()*quotient1 + other.getNum()*quotient2 ), lcd);
		
	}
	
	public Fraction add( String other )
	{
		return add(new Fraction(other));
	}
	
	public Fraction mul( Fraction other )
	{
		return new Fraction( this.getNum()*other.getNum(), this.getDen()*other.getDen() );
	}

	public Fraction mul( float other )
	{
		return new Fraction( this.getNum()*other, this.getDen() );
	}
	
	public Fraction div(float other)
	{
		return div( new Fraction(other+"") );
	}
	
	public Fraction div( Fraction other )
	{
		return mul( new Fraction(other.getDen(), other.getNum()) );
	}

	public Fraction neg()
	{
		return new Fraction(this.getNum()*-1, this.getDen());
	}

	public Fraction root()
	{
		return new Fraction( Math.sqrt(num)+"/"+Math.sqrt(den));
	}
	
	public Fraction reciprical()
	{
		return new Fraction( den +"/" + num);
	}
	
	public float getFract_f()
	{
		return this.num/this.den;
	}
	
	public float getFract_f( int decimalPlaces )
	{
		String pattern = "#.";
		for( int i = 0; i < decimalPlaces; ++i )
		{
			pattern+="#";
		}		
		DecimalFormat df = new DecimalFormat(pattern);
		return Float.parseFloat(df.format(this.getFract_f()));
	}
	
	public Fraction sub(Fraction other)
	{
		return add( new Fraction(other.getNum()*-1, other.getDen()) );	
	}
	
	public boolean isLessThan(Fraction anotherFraction)
	{
		return compareTo(anotherFraction) < 0; 
	}

	public boolean isLessThan(String anotherFraction)
	{
		return isLessThan(new Fraction(anotherFraction)); 
	}
	
	public boolean isGreaterThan(Fraction anotherFraction)
	{
		return compareTo(anotherFraction) > 0; 
	}

	public boolean isGreaterThan(String anotherFraction)
	{
		return isGreaterThan(new Fraction(anotherFraction)); 
	}

	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Fraction anotherFraction = (Fraction)obj;
		return (this.num == anotherFraction.num && this.den == anotherFraction.den );
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.num+"/"+this.den;
	}

	@Override
	public int compareTo(Object anotherFraction) {
		// TODO Auto-generated method stub
		if(!(anotherFraction instanceof Fraction))
			throw new ClassCastException("Expecting a fraction object");
		Fraction a = (Fraction)anotherFraction;
		
		float num1 = this.getNum();
		float num2 = a.getNum();
		float lcm = lcm(this.getDen(), a.getDen());
		
		if( lcm != this.getDen() )
		{
			num1 *= lcm;
		}
		
		if( lcm != a.getDen() )
		{
			num2 *= lcm;
		}
		
		return (int)num1-(int)num2;
	}

	public void setFraction(Fraction value) {
		// TODO Auto-generated method stub
		setFraction(value+"");
	}
	
	public static Fraction roundOff( String value, int dp )
	{
		Fraction result = new Fraction(value);
		return new Fraction(""+result.getFract_f(dp));
	}
	
}
