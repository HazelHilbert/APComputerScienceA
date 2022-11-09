/*
 * Hazel Hilbert
 * Ayaan Rahim
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JApplet;

public class Flag extends JApplet {

	private final int STRIPES = 13;

	
	// SCALE FACTORS (A through L)

	private final double A = 1.0;  // Hoist (height) of flag

	private final double B = 1.9;  // Fly (width) of flag

	private final double C = 7.0 / STRIPES;  // Hoist of Union

	private final double D = 0.76;  // Fly of Union

	private final double E = 0.054;  // See flag specification

	private final double F = 0.054;  // See flag specification

	private final double G = 0.063;  // See flag specification

	private final double H = 0.063;  // See flag specification

	private final double K = 0.0616;  // Diameter of star

	private final double L = 1.0 / STRIPES;  // Width of stripe

	
	// You will need to set values for these in paint()
	
	private double flag_width;   // width of flag in pixels

	private double flag_height;  // height of flag in pixels

	private double stripe_height; // height of an individual stripe in pixels


	// init() will automatically be called when an applet is run
	public void init() {

		// Choice of width = 1.9 * height to start off
		// 760 : 400 is ratio of FLY : HOIST
		
		setSize(760, 400);

		repaint();
	}


	// paint() will be called every time a resizing of an applet occurs
	public void paint(Graphics g) {

		flag_width = getWidth();   // width of the applet    

		flag_height = getHeight(); // height of the applet


		double ratio = flag_width / flag_height;

		if (ratio > B / A) {
			flag_width = flag_height * B / A;
		} else {
			flag_height = flag_width * A / B;
		}
		
		stripe_height = flag_height / 13;



		drawBackground(g); // calls the drawBackgroung method

		drawStripes(g); // calls the drawStripes method

		drawField(g); // calls the drawField method
		
		drawStars(g); // calls the drawStars method
	}



	private void drawBackground(Graphics g) {
		// makes a black rectangle the size of the applet the background

		g.setColor(Color.BLACK);

		g.fillRect(0, 0, getSize().width - 1, getSize().height - 1);
	}



	public void drawStripes(Graphics g) {

		int stripeHeight = (int) stripe_height;

		int stripeWidth = (int) flag_width;

		Color USA_RED  = new Color(164, 49, 56);
		Color color = USA_RED;

		Stripe s;

		for (int i = 0; i < STRIPES; i++) {
			color = i % 2 == 0 ?  USA_RED : Color.WHITE;
			s = new Stripe(color);
			s.draw(g, 0, stripeHeight * i, stripeWidth, stripeHeight);
		}
	}



	public void drawField(Graphics g) {

		int fieldHeight = 7 * (int) stripe_height;
		int fieldWidth = (int) (flag_height * D);

		Color USA_BLUE  = new Color(60, 59, 107);
		Field field = new Field(USA_BLUE);
		field.draw(g, 0, 0, fieldWidth, fieldHeight);

	}



	public void drawStars(Graphics g) {

		int starX1 = (int) (flag_height * G);
		int starY1 = (int) (flag_height * E);

		int starX2 = (int) (starX1 + (flag_height * H));
		int starY2 = (int) (starY1 + (flag_height * F));

		int starR = (int) (flag_height * K / 2);

		int newStarX = 0;
		int newStarY = 0;

		for (int row = 0; row < 5; row++) {
			newStarY = (int) (starY1 + (row * 2 * F * flag_height));

			for (int col = 0; col < 6; col++) {
				newStarX = (int) (starX1 + (col * 2 * H * flag_height));

				Star stars = new Star(newStarX, newStarY, starR);
				stars.paint(g);
			}
		}

		for (int row = 0; row < 4; row++) {
			newStarY = (int) (starY2 + (row * 2 * F * flag_height));

			for (int col = 0; col < 5; col++) {
				newStarX = (int) (starX2 + (col * 2 * H * flag_height));

				Star stars = new Star(newStarX, newStarY, starR);
				stars.paint(g);
			}
		}	 

	}
}