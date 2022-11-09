import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JApplet;

//This class can be used to help you determine how to draw one star
public class Sun {

	private int centerX;
	private int centerY;
	private int fly;


	public Sun(int centerX, int centerY, int lengthOfFly) {

		this.centerX = centerX;
		this.centerY = centerY;
		fly = (int) lengthOfFly;
	}


	public void paint(Graphics g){

		double LN = 0.214; //214001623722
		double MN = 0.135723304703;

		int outerRadius = (int) (fly * LN );
		int innerRadius = (int)(fly * MN);


		int[] x = new int[24];
		int[] y = new int[24];

		int n = 0;

		for(int i = 0; i < 360; i += 30) {
			x[n] = (int) (outerRadius * Math.cos(Math.toRadians(i)) + centerX);
			y[n] = (int) (outerRadius * Math.sin(Math.toRadians(i)) + centerY);
			n += 2;
		}

		n = 1;

		for(int i = 15; i < 360; i += 30) {
			x[n] = (int)(innerRadius * Math.cos(Math.toRadians(i)) + centerX);
			y[n] = (int) (innerRadius * Math.sin(Math.toRadians(i)) + centerY);
			n += 2;
		}

		//actually drawing the star
		g.setColor(Color.WHITE);

		g.fillPolygon(x, y, 24);
	}
}
