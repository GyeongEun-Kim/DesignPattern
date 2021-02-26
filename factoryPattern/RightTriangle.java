package factoryPattern;
import java.awt.*;
import java.util.Arrays;

public class RightTriangle extends Shape{
	String type;
	Point[] points;
	RightTriangle ( String type, Point[] points) {
		this.type=type;
		this.points=points;
	}
	double calcArea() {
		double height=points[0].getY()-points[2].getY();
		double width=points[2].getX()-points[1].getX();
		return height*width/2;
		
	}


	@Override
	public String toString() {
		System.out.println(type);
		for (int i=0;i<points.length;i++) 
			System.out.println("P"+i+": "+ points[i].toString() + "]");
		System.out.print("area: "+calcArea());
		return ("\n");
	

	}
	
	
}
