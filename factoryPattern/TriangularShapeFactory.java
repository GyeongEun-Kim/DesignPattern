package factoryPattern;
import java.awt.*;
public class TriangularShapeFactory implements ShapeFactory{
	public Shape create (String type, Point[] points) {
		Shape triangular = null;
		 switch (type) {
		 	case ("Triangle") :
		 		triangular=new Triangle(type, points);
		 	case ("RightTriangle" ) :
		 		triangular=new RightTriangle(type, points);
		 	
		 }
	
		 return triangular;
		
	}
}
