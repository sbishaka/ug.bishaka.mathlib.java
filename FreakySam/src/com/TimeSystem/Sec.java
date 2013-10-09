package com.TimeSystem;

import com.fractions.Fraction;

public class Sec extends Time{

	
	
	public Sec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sec(float fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Sec(Fraction fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Sec(int fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	public Sec(String fraction) {
		super(fraction);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Hour toHour() {
		// TODO Auto-generated method stub
		return new Hour(this.getValue().mul(new Fraction("1/3600")));
	}
	
}
