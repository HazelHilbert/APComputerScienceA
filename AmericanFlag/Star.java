import java.awt.Color;
import java.awt.Graphics;

public class Star {

	private int centerX;
	private int centerY;
	private int r;

	public Star(int centerX, int centerY, int radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.r = radius;
	}

	public void paint(Graphics g){

		double innerRadius = (r * Math.sin(Math.toRadians(18))) / Math.sin(Math.toRadians(54));

		// the arrays of x and y coordinates of the star
		int[] x = new int[10];
		int[] y = new int[10];

		int n = 0;

		for(int i = 18; i < 360; i += 72) {
			x[n] = (int) (innerRadius * Math.cos(Math.toRadians(i)) + centerX);
			y[n] = (int) (innerRadius * Math.sin(Math.toRadians(i)) + centerY);
			n += 2;
		}

		n = 1;

		for(int i = 54; i < 360; i += 72) {
			x[n] = (int)(r * Math.cos(Math.toRadians(i)) + centerX);
			y[n] = (int) (r * Math.sin(Math.toRadians(i)) + centerY);
			n += 2;
		}

		g.setColor(Color.WHITE);
		g.fillPolygon(x, y, 10);		
	}
}