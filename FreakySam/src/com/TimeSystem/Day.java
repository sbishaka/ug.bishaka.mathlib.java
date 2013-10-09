package com.TimeSystem;

import com.fractions.Fraction;

public class Day extends Time {

	
	
	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Day(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Day(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Day(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Day(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hour toHour() {
		// TODO Auto-generated method stub
		return new Hour(this.getValue().mul(24));
	}

	
	
}
