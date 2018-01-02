import java.awt.geom.Point2D;
import java.util.ArrayList;

public class RotationalPath {
	
	public ArrayList<Point2D.Double> points = new ArrayList<>();
	
	public RotationalPath(RotationalFunctionPair functions) {
		double x1 = 1;
		double y1 = 0;
		for(double theta = 0; theta <= Math.PI * 2; theta += Math.PI / 128) {
			double newX, newY;
			newX = functions.coFunction(theta) * x1 + -functions.function(theta) * y1;
			newY = functions.function(theta) * x1 + functions.coFunction(theta) * y1;
			points.add(new Point2D.Double(newX, newY));
		}
	}

}
