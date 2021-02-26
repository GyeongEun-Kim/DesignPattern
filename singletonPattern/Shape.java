package singletonPattern;
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
	public Shape() {} //기본 생성자
	abstract double calcArea();
	
	
	
}
