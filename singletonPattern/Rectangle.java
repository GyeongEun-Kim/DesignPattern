package singletonPattern;
import java.awt.*;
import java.util.Arrays;

public class Rectangle extends Shape{
	String type;
	Point[] points;
	Rectangle (String type, Point[] points) {
		this.type=type;
		this.points=points;
	
	}//»ý¼ºÀÚ
	

	double calcArea () {
		double width=(points[0].getX())-(points[1].getX());
		double height=(points[1].getY())-(points[0].getY());
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
	
