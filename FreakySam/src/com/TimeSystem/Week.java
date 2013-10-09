package com.TimeSystem;

import com.fractions.Fraction;

public class Week extends Time{

	
	
	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Week(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Week(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Week(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Week(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hour toHour() {
		// TODO Auto-generated method stub
		return new Hour(this.getValue().mul(168));
	}
	

}
