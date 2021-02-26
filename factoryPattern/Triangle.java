package factoryPattern;
import java.awt.*;
import java.util.Arrays;
public class Triangle extends Shape{ 
	String type;
	Point[] points;
	Triangle (String type, Point[] points) {
		this.type=type;
		this.points=points;
	}
	double calcArea() {
		double a=distance(0,1);
		double b=distance(1,2);
		double c=distance(2,3);
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
		
	}
	double distance(int p1,int p2) {
		double d=Math.sqrt((points[p1].getX()-points[p2].getX())*(points[p1].getX()-points[p2].getX())
				+ (points[p1].getX()-points[p2].getY())*(points[p1].getX()-points[p2].getY()));
		return d;
		
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
