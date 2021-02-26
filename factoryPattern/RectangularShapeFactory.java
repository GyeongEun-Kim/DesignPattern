package factoryPattern;
import java.awt.*;

public class RectangularShapeFactory implements ShapeFactory{
	
	 public Shape create (String type, Point[] points) {
		 Shape rectangular = null;
		 switch (type) {
		 	case ("Rectangle") :
		 		rectangular=new Rectangle(type, points);
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

}
