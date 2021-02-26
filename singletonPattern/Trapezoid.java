package singletonPattern;
import java.awt.*;
import java.util.Arrays;
public class Trapezoid extends Shape{
	Point[] points;
	String type;
	Trapezoid (String type, Point[] points) {
		this.points=points;
		this.type=type;
		
	}
	
	double calcArea() {
		double upperwidth=(points[3].getX())-(points[0].getX());
		double lowerwidth=(points[1].getX())-(points[2].getX());
		double height=(points[3].getY()-points[1].getY());
		return (upperwidth+lowerwidth)*height/2;
		
	}


	@Override
	public String toString() {
		System.out.println(type);
		for (int i=0;i<points.length;i++) 
			System.out.println("P"+i+": "+ points[i].toString() );
		System.out.print("area: "+calcArea());
		return ("\n");
	

	}
}
