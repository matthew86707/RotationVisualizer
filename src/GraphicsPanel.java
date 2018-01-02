import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
	
	RotationalPath currentPath;
	public int X_SCALE_FACTOR = 100;
	public int Y_SCALE_FACTOR = 100;
	public int WIDTH = 800;
	public int HEIGHT = 600;

	@Override
	public void paintComponent(Graphics g) {
 	  super.paintComponent(g);
 	  g.setColor(Color.BLACK);
 	  g.fillRect(WIDTH / 2, 0, 2, HEIGHT);
 	  g.fillRect(0, HEIGHT / 2, WIDTH, 2);
 	  g.setColor(Color.BLUE);
 	  for(Point2D.Double point : currentPath.points) {
 		  g.drawRect((WIDTH / 2) + (int)(point.getX() * 100), (HEIGHT / 2) + (int)(point.getY() * 100), 2, 2);
 	  }
	}
}