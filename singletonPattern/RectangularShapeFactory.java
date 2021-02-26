package singletonPattern;
import java.awt.*;

public  class RectangularShapeFactory implements ShapeFactory{
	Shape rectangular = null;
	private static RectangularShapeFactory rsf = null;
	
	private RectangularShapeFactory () {
		
	} //기본생성자를 private로
	 public Shape create (String type, Point[] points) {
		
		 switch (type) {
		 	case ("Rectangle") :
		 		rectangular=new  Rectangle(type, points);
		 		break;
		 	case ("Parallelogram" ) :
		 		rectangular=new Parallelogram(type, points);
		 		break;
		 	case ("Trapezoid") :
		 		rectangular=new Trapezoid(type,points) ;
		 		break;
		 }
		 
		 return rectangular;
		
	}
	 
	 public synchronized static RectangularShapeFactory getRectangularShapeFactory() {
		 if (rsf==null) {
			 rsf=new RectangularShapeFactory();
		 }
		 return rsf;
	 }
	

}
