package com.Motion;

import com.LengthSystem.LENGTH_SLOT;
import com.LengthSystem.Length;
import com.LengthSystem.Unit;
import com.TimeSystem.Sec;
import com.TimeSystem.TIME_SLOT;
import com.TimeSystem.Time;
import com.points.Point;
import com.vectors.Vector;

public class Velocity {
	
	Vector displacement = new Vector("0,0,0");
	Length distance = new Unit("0");
	Time time = new Sec("0");
	
	public Velocity() {
		// TODO Auto-generated constructor stub
	}

	public Velocity(String start, String end, String time) {
		this.displacement = Vector.newVector_p(start, end);
		this.time = new Sec(time);
	}

	public Velocity(Point start, Point end, Time time) 
	{
		this.displacement = Vector.newVector_p(start, end);
		this.time = time;
	}

	public Velocity(Length start, Length end, Time time) 
	{
		this.distance = end.sub(start);
		this.time = time;
	}
	
	public Velocity(Vector displacement, Time time) 
	{
		this.displacement = displacement;
		this.time = time;
	}

	public Velocity(Length distance,Time time)
	{
		setVelocity(distance, time);
	}
	
	public void setVelocity(Length distance,Time time)
	{
		this.distance = distance;
		this.time = time;		
	}
	
	public Velocity getAverageVelocity()
	{
		return new Velocity(
							new Vector(
											this.displacement.getCartesianInfo().getX().div(time.getValue())+","+
											this.displacement.getCartesianInfo().getY().div(time.getValue())+","+
											this.displacement.getCartesianInfo().getZ().div(time.getValue())
										),
							new Sec(1));
	}

	public Vector getDisplacement() {
		return displacement;
	}

	public Length getDisplacement(Time interval) {
		Length buff = Length.newLength(distance);
		buff.setValue(this.distance.getValue().div(this.time.toSec().getValue()).mul(interval.toSec().getValue()) );
		return buff;
	}

	
	public void setDisplacement(Vector displacement) {
		this.displacement = displacement;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.displacement.toString();
	}

	
	public Length getDistance() {
		return distance;
	}

	
	public void setDistance(Length distance) {
		this.distance = distance;
	}
	

	public Length getVelocity( LENGTH_SLOT l, TIME_SLOT t )
	{
		Length buff = new Unit();
		
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
				buff.setValue(buff.getValue().div(this.time.toMonth().getValue()));  
			break;
			
			case WEEK:
				buff.setValue(buff.getValue().div(this.time.toWeek().getValue()));  
			break;
			
			case DAY:
				buff.setValue(buff.getValue().div(this.time.toDay().getValue()));  
			break;
			
			case HOUR:
				buff.setValue(buff.getValue().div(this.time.toHour().getValue()));  
			break;
			
			case MIN:
				buff.setValue(buff.getValue().div(this.time.toMin().getValue()));  
			break;
			
			case SEC:
				System.out.println();
				buff.setValue(buff.getValue().div(this.time.toSec().getValue()));  
			break;
		}
		
		return buff;
	}
	
}
