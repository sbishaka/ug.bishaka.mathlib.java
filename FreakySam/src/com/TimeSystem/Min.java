package com.TimeSystem;

import com.fractions.Fraction;

public class Min extends Time{

	
	
	public Min() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Min(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Min(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Min(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Min(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hour toHour() {
		// TODO Auto-generated method stub
		return new Hour(this.getValue().mul(new Fraction("1/60")));
	}
	
	

}
