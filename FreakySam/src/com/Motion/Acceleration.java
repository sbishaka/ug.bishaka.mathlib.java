package com.Motion;

import com.LengthSystem.LENGTH_SLOT;
import com.LengthSystem.Length;
import com.LengthSystem.Mile;
import com.LengthSystem.Unit;
import com.TimeSystem.Hour;
import com.TimeSystem.TIME_SLOT;
import com.TimeSystem.Time;

public class Acceleration {
	
	private Length distance = new Mile(0);
	private	Time time = new Hour(1);
	
	public Acceleration()
	{
		
	}

	public Acceleration(Velocity start, Velocity stop, Time delta)
	{
		setAcceleration(start, stop, delta);
	}

	public void setAcceleration(Velocity start, Velocity stop, Time delta)
	{
		Velocity begin = new Velocity(start.getVelocity(LENGTH_SLOT.MILE, TIME_SLOT.HOUR), new Hour(1));
		Velocity end = new Velocity(stop.getVelocity(LENGTH_SLOT.MILE, TIME_SLOT.HOUR), new Hour(1));
		Time interval = delta.toHour();
		
		this.distance.setValue(end.getDistance().getValue().sub(begin.getDistance().getValue()).div(interval.getValue()));
		this.time.setValue(1);		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.distance+" / " + this.time + "^2";
	}

	public Length getDistance() {
		return distance;
	}

	public void setDistance(Length distance) {
		this.distance = distance;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	

	public Length getAcceleration( LENGTH_SLOT l, TIME_SLOT t )
	{
		Length buff = null;
		
		switch(l)
		{
			case KILO:
				buff = this.distance.toKilo();
			break;
			
			case HECTO:
				buff = this.distance.toHecto();
			break;

			case DECA:
				buff = this.distance.toDeca();
			break;

			case UNIT:
				buff = this.distance.toUnit();
			break;

			case DECI:
				buff = this.distance.toDeci();
			break;

			case CENTI:
				buff = this.distance.toCenti();
			break;

			case MILLI:
				buff = this.distance.toMilli();
			break;

			case MILE:
				buff = this.distance.toMile();
			break;

			case FOOT:
				buff = this.distance.toFoot();
			break;

			case INCH:
				buff = this.distance.toInch();
			break;
		}
		
		switch(t)
		{
			case MONTH:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
			
			case WEEK:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
			
			case DAY:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
			
			case HOUR:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
			
			case MIN:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
			
			case SEC:
				buff.setValue(buff.getValue().div(this.time.toSec().getValue().mul(this.time.toSec().getValue())));  
			break;
		}
		
		return buff;
	}

}
