package com.TimeSystem;

import com.LengthSystem.Centi;
import com.LengthSystem.Deca;
import com.LengthSystem.Deci;
import com.LengthSystem.Foot;
import com.LengthSystem.Hecto;
import com.LengthSystem.Inch;
import com.LengthSystem.Kilo;
import com.LengthSystem.Length;
import com.LengthSystem.Mile;
import com.LengthSystem.Milli;
import com.LengthSystem.Unit;
import com.fractions.Fraction;

/**
 * We take an hour as a unit of time
 * */
public abstract class Time {
	
	private Fraction value = new Fraction("0");

	public Time()
	{
		
	}
	
	public Time(int fraction)
	{
		setValue(fraction);
	}

	
	public Time(String fraction)
	{
		setValue(fraction);
	}

	public Time(float fraction)
	{
		setValue(fraction);
	}
	
	public Time(Fraction fraction)
	{
		setValue(fraction);
	}
	
	
	public abstract Hour toHour();
	
	public Day toDay()
	{
		return new Day(this.toHour().getValue().div(24));
	}
	
	public Min toMin()
	{
		return new Min(this.toHour().getValue().div(new Fraction("1/60")));
	}
	
	public Sec toSec()
	{
		return new Sec(this.toHour().getValue().div(new Fraction("1/3600")));
	}
	
	public Week toWeek()
	{
		return new Week(this.toHour().getValue().div(168));
	}
	
	public Month toMonth()
	{
		return new Month(this.toHour().getValue().div(672));
	}
	
	public Fraction getValue() {
		return value;
	}

	public void setValue(Fraction value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value.setFraction(value+"");
	}
	
	public void setValue(String value) {
		this.value.setFraction(value);
	}

	public void setValue(float value) {
		this.value.setFraction(value+"");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Time buff = (Time)obj;
		return this.toHour().getValue().equals(buff.toHour().getValue());
	}

	@Override
	public String toString() 
	{
		String result = this.getValue()+"";

		if(this instanceof Day)
			result += " Day(s)";

		if(this instanceof Hour)
			result += " Hour(s)";

		if(this instanceof Min)
			result += " Min(s)";

		if(this instanceof Month)
			result += " Month(s)";

		if(this instanceof Sec)
			result += " Sec(s)";

		if(this instanceof Week)
			result += " Week(s)";
		
		return result;
	}

	
}
