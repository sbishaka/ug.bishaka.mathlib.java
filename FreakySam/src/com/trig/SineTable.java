package com.trig;

import com.angles.Degree;
import com.fractions.Fraction;

public class SineTable 
{
	
	public Fraction[] map = new Fraction[360];

	public SineTable() {
		super();
		Degree buff = new Degree("0");
		
		for( int i = 0; i < 360; i++ )
		{
			buff.setValue(i+"");
			map[i] = new Fraction( buff.toRadians().getValue().sin()+"");
		}
	}

	public Fraction[] getMap() {
		return map;
	}
	
	public Fraction getSin(int angle)
	{
		return map[angle];
	}
	
}
