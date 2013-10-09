package com.trig;

import java.util.Arrays;

import com.fractions.Fraction;
import com.points.Point;

public class Triangle {
	
	Point p1 = new Point("0,0"),
		  p2 = new Point("0,0"),
		  p3 = new Point("0,0");

	Fraction opp = new Fraction("0"),
			 adj = new Fraction("0"),
			 hyp = new Fraction("0");
	
	public Triangle(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public Triangle(String p1, String p2, String p3) {
		super();
		setTriangle(p1, p2, p3);
	}
	
	public void setTriangle(String p1, String p2, String p3)
	{
		this.p1 = new Point(p1);
		this.p2 = new Point(p2);
		this.p3 = new Point(p3);
	}	
	
	public boolean isRightAngle()
	{
		
		Fraction[] distances = new Fraction[3];
		distances[0] = p1.distanceFrom_minusRoot(p2);
		distances[1] = p2.distanceFrom_minusRoot(p3);
		distances[2] = p3.distanceFrom_minusRoot(p1);
		Arrays.sort(distances);
	
		return distances[0].add(distances[1]).equals(distances[2]);
	}
	
}
