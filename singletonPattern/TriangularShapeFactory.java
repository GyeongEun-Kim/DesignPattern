package singletonPattern;
import java.awt.*;
public class TriangularShapeFactory implements ShapeFactory{
	Shape triangular = null;
	private static TriangularShapeFactory tsf=null;
	private TriangularShapeFactory () {
		
	}//�⺻�����ڸ� private��
	public Shape create (String type, Point[] points) {
	
		 switch (type) {
		 	case ("Triangle") :
		 		triangular=new Triangle(type, points);
		 	case ("RightTriangle" ) :
		 		triangular=new RightTriangle(type, points);
		 	
		 }
	
		 return triangular;
		
	}
	
	public synchronized static TriangularShapeFactory getTriangularShape() {
		if (tsf==null) {
			tsf=new TriangularShapeFactory();
		}
		return tsf;
	 }
}
