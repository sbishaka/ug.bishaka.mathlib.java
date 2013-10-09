package com.LengthSystem;

import com.fractions.Fraction;

public abstract class Length {
	
	private Fraction value = new Fraction("0");
	
	public Length()
	{
		
	}

	public Length(int fraction)
	{
		this.value.setFraction(fraction+"");
	}

	public Length(String fraction)
	{
		this.value.setFraction(fraction+"");
	}

	public Length(float fraction)
	{
		this.value.setFraction(fraction+"");
	}
	
	public Length(Fraction fraction)
	{
		this.value.setFraction(fraction);
	}

	public Kilo toKilo()
	{
		return new Kilo( this.toUnit().getValue().div(1000) );
	}
	
	public Hecto toHecto()
	{
		return new Hecto( this.toUnit().getValue().div(100) );
	}
	
	public Deca toDeca()
	{
		return new Deca( this.toUnit().getValue().div(10) );
	}
	
	public Deci toDeci()
	{
		return new Deci( this.toUnit().getValue().div((float)0.1) );
	}
	
	public Centi toCenti()
	{
		return new Centi( this.toUnit().getValue().div((float)0.01) );
	}
	
	public Milli toMilli()
	{
		return new Milli( this.toUnit().getValue().div((float)0.001) );
	}
	
	public Mile toMile()
	{
		return new Mile(this.toKilo().getValue().div((float)1.609344));
	}
	
	public Foot toFoot()
	{
		return new Foot(this.toUnit().getValue().div((float)0.3048));
	}

	public Inch toInch()
	{
		return new Inch(this.toCenti().getValue().div((float)2.54));
	}

	
	public abstract Unit toUnit();
	
	public Fraction getValue() {
		return value;
	}

	public void setValue(Fraction value) {
		this.value = value;
	}

	public void setValue(Length value) {
		
		if(this instanceof Kilo)
			this.value = value.toKilo().getValue();

		if(this instanceof Hecto)
			this.value = value.toHecto().getValue();

		if(this instanceof Deca)
			this.value = value.toDeca().getValue();

		if(this instanceof Unit)
			this.value = value.toUnit().getValue();

		if(this instanceof Deci)
			this.value = value.toDeci().getValue();

		if(this instanceof Centi)
			this.value = value.toCenti().getValue();

		if(this instanceof Milli)
			this.value = value.toMilli().getValue();
		
	}
	
	public Length mul( Length other )
	{
		Unit ans = new Unit(this.toUnit().getValue().mul(other.toUnit().getValue()));
		Length result = null;
		
		if(this instanceof Kilo)
			result = ans.toKilo();

		if(this instanceof Hecto)
			result = ans.toHecto();

		if(this instanceof Deca)
			result = ans.toDeca();

		if(this instanceof Unit)
			result = ans.toUnit();

		if(this instanceof Deci)
			result = ans.toDeci();

		if(this instanceof Centi)
			result = ans.toCenti();

		if(this instanceof Milli)
			result = ans.toMilli();
		
		if(this instanceof Mile)
			result = ans.toMile();
		
		if(this instanceof Foot)
			result = ans.toFoot();
		
		if(this instanceof Inch)
			result = ans.toInch();
		
		return result;
	}
	
	public Length div( Length other )
	{
		Unit ans = new Unit(this.toUnit().getValue().div(other.toUnit().getValue()));
		Length result = null;
		
		if(this instanceof Kilo)
			result = ans.toKilo();

		if(this instanceof Hecto)
			result = ans.toHecto();

		if(this instanceof Deca)
			result = ans.toDeca();

		if(this instanceof Unit)
			result = ans.toUnit();

		if(this instanceof Deci)
			result = ans.toDeci();

		if(this instanceof Centi)
			result = ans.toCenti();

		if(this instanceof Milli)
			result = ans.toMilli();
		
		if(this instanceof Mile)
			result = ans.toMile();

		if(this instanceof Foot)
			result = ans.toFoot();
		
		if(this instanceof Inch)
			result = ans.toInch();
		
		return result;
	}
	
	public Length add( Length other )
	{
		Unit ans = new Unit(this.toUnit().getValue().add(other.toUnit().getValue()));
		Length result = null;
		
		if(this instanceof Kilo)
			result = ans.toKilo();

		if(this instanceof Hecto)
			result = ans.toHecto();

		if(this instanceof Deca)
			result = ans.toDeca();

		if(this instanceof Unit)
			result = ans.toUnit();

		if(this instanceof Deci)
			result = ans.toDeci();

		if(this instanceof Centi)
			result = ans.toCenti();

		if(this instanceof Milli)
			result = ans.toMilli();
		
		if(this instanceof Mile)
			result = ans.toMile();

		if(this instanceof Foot)
			result = ans.toFoot();
		
		if(this instanceof Inch)
			result = ans.toInch();
		
		return result;
	}
	
	
	
	public Length sub( Length other )
	{
		Unit ans = new Unit(this.toUnit().getValue().sub(other.toUnit().getValue()));
		Length result = null;
		
		if(this instanceof Kilo)
			result = ans.toKilo();

		if(this instanceof Hecto)
			result = ans.toHecto();

		if(this instanceof Deca)
			result = ans.toDeca();

		if(this instanceof Unit)
			result = ans.toUnit();

		if(this instanceof Deci)
			result = ans.toDeci();

		if(this instanceof Centi)
			result = ans.toCenti();

		if(this instanceof Milli)
			result = ans.toMilli();
		
		if(this instanceof Mile)
			result = ans.toMile();

		if(this instanceof Foot)
			result = ans.toFoot();
		
		if(this instanceof Inch)
			result = ans.toInch();
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Length buff = (Length)obj;
		return this.toUnit().getValue().equals(buff.toUnit().getValue());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String result = this.getValue()+"";

		if(this instanceof Kilo)
			result += " Kilo(s)";

		if(this instanceof Hecto)
			result += " Hecto(s)";

		if(this instanceof Deca)
			result += " Deca(s)";

		if(this instanceof Unit)
			result += " Unit(s)";

		if(this instanceof Deci)
			result += " Deci(s)";

		if(this instanceof Centi)
			result += " Centi(s)";

		if(this instanceof Milli)
			result += " Milli(s)";

		if(this instanceof Mile)
			result += " Mile(s)";

		if(this instanceof Foot)
			result += " ft";
		
		if(this instanceof Inch)
			result += " in(s)";

		
		return result;
	}

	public static Length newLength(Length other)
	{
		Length result = null;
		
		if(other instanceof Kilo)
			result = new Kilo();

		if(other instanceof Hecto)
			result = new Hecto();

		if(other instanceof Deca)
			result = new Deca();

		if(other instanceof Unit)
			result = new Unit();

		if(other instanceof Deci)
			result = new Deci();

		if(other instanceof Centi)
			result = new Centi();

		if(other instanceof Milli)
			result = new Milli();
		
		if(other instanceof Mile)
			result = new Mile();

		if(other instanceof Foot)
			result = new Foot();
		
		if(other instanceof Inch)
			result = new Inch();
		
		
		result.setValue(other.getValue());
		return result;
	}

	public float getFrac_f()
	{
		return this.value.getFract_f();
	}
	
	public float getFrac_f(int dps)
	{
		return this.value.getFract_f(dps);
	}
}
