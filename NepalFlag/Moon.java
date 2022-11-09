import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

//This class can be used to help you determine how to draw one star
public class Moon {

	private int xM;
	private int yM;
	private int fly;


	public Moon(int xM, int yM, int lengthOfFly) {

		this.xM = xM;
		this.yM = yM;
		fly = (int) lengthOfFly;
	}


	public void paint(Graphics g){

		double LN = 0.214001623722;
		double MN = 0.135723304703;
		double LM = LN - MN;
		double MQ = 0.199167;

		int radiusM = (int) (MQ * fly);
		int radiusL = (int) (LN * fly);

		//actually drawing the star
		g.setColor(Color.BLACK);
		g.drawOval((xM - radiusL), (int) (yM - (fly * LM) - radiusL), radiusL * 2, radiusL * 2);
		g.drawOval(xM - radiusM, yM - radiusM, radiusM * 2, radiusM * 2);
	}
}
