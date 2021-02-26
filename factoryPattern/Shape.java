package factoryPattern;
import java.awt.*;
import java.util.Arrays;
public abstract class Shape {
	String type;
	Point[] points;
	Shape (String type, Point[] points){
		this.type=type;
		this.points=points;
		toString();
	}
	public Shape() {} //�⺻ ������
	abstract double calcArea();
	
	
	
}
