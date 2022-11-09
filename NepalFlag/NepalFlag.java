import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JApplet;

public class NepalFlag extends JApplet {

	private double flag_width;   // width of flag in pixels

	private double flag_height;  // height of flag in pixels

	private double BORDER_WIDTH = 1.1469166667;

	private double BORDER_HEIGHT = 1.45;


	public void init() {

		setSize(300, 357);

		repaint();

	}


	// paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {

		flag_width = getWidth();   // width of the applet    

		flag_height = getHeight(); // height of the applet

		//setSize((int)Math.round(flag_width), (int)Math.round(flag_height));

		drawBackground(g); // calls the drawBackgroung method
		drawShape(g);
		drawSun(g);
		//drawMoon(g);
	}



	private void drawBackground(Graphics g) {
		// makes a black rectangle the size of the applet the background

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);

	}

	public void drawShape(Graphics g) {
		Shape flag = new Shape(0, 0, (int) flag_width);
		flag.paint(g);
	}

	public void drawSun(Graphics g) {
		double CU = 0.97977994274;
		double BORDER = 0.043;
		double inner_width = flag_width / BORDER_WIDTH;

		Sun sun = new Sun((int) ((inner_width / 4.0) + (inner_width * BORDER)), (int) (inner_width * CU), (int) inner_width);
		sun.paint(g);

		// g.drawLine(0, (int) (inner_width * CU), 500, (int) (inner_width * CU));
		// g.drawLine((int) ((inner_width / 4) + (inner_width * BORDER)), 0, (int) ((inner_width / 4) + (inner_width * BORDER)), 900);

	}

	public void drawMoon(Graphics g) {
		double X_M = 0.293041666667;
		double Y_M = 0.469141595092;
		double Y_m = 0.468916666667;

		double inner_width = flag_width / BORDER_WIDTH;

		Moon moon = new Moon((int) (inner_width * X_M), (int) (inner_width * Y_M), (int) inner_width);
		moon.paint(g);

		g.drawLine((int) (inner_width * X_M) - 10, 0, (int) (inner_width * X_M), 900);
		g.drawLine(0, (int) (inner_width * Y_M), 500, (int) (inner_width * Y_M));
	}
}