package com.TimeSystem;

import com.fractions.Fraction;

public class Month extends Time{

	public Month() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Month(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Month(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Month(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Month(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hour toHour() {
		// TODO Auto-generated method stub
		return new Hour(this.getValue().mul(672));
	}
	
}
