package singletonPattern;
import java.awt.*;
import java.util.Arrays;

public class Parallelogram extends Shape{ 
	String type;
	Point[] points;
	Parallelogram (String type ,Point[] points) {
		this.type=type;
		this.points=points;
	}
	double calcArea() {
		double width=(points[3].getX())-(points[0].getX());
		double height=(points[3].getY())-(points[1].getY());
		return width*height;
		
	}

	@Override
	public String toString() {
		System.out.println(type);
		for (int i=0;i<points.length;i++) 
			System.out.println("P"+i+": "+ points[i].toString());
		System.out.print("area: "+calcArea());
		return ("\n");
	

	}

}
