import java.awt.Color;
import java.awt.Graphics;

public class Shape {


	private int topLeftX;
	private int topLeftY;
	private int fly;
	

	public Shape(int topLeftX, int topLeftY, int lengthOfFly) {

		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		fly = (int) lengthOfFly;
	}

	public void paint(Graphics g){
		
		int border = (int) (3 * fly * (33 - (20 * Math.sqrt(2))) / (32 * (23 - (9 * Math.sqrt(2)))));
		
		int adjacent = (int)(topLeftY - (topLeftY + (((4 * fly)/3.0) - (fly / Math.sqrt(2)))));
		double angleC = (Math.atan((fly * 1.0) / adjacent))/ 2;
		int hC = (int) (border / Math.tan(angleC));
		
		double angleG = (Math.atan((fly * 1.0) / adjacent))/ 2;
		int hG = (int) (border / Math.tan(angleG / 2.0));

		int hB = (int) (border / Math.tan(Math.toRadians(45 / 2.0)));
		
		topLeftX += border;
		
		topLeftY -= hC;
		
		fly -= border - hG; 
				
		int[] innerX = new int[5];
		int[] innerY = new int[5];

		// Letters are outlined in Nepal's Constitution (Article 5)
		//C
		innerX[0] = (int) topLeftX;
		innerY[0] = (int) topLeftY;

		//A
		innerX[1] = (int) (topLeftX);
		innerY[1] = (int) (topLeftY + ((4 * fly)/3.0));

		//B
		innerX[2] = (int) (topLeftX + fly);
		innerY[2] = (int) (topLeftY + ((4 * fly)/3.0));

		//E
		innerX[3] = (int) (topLeftX + (fly - (fly / Math.sqrt(2))));
		innerY[3] = (int) (topLeftY + (((4 * fly)/3.0) - (fly / Math.sqrt(2))));

		//G
		innerX[4] = (int) (topLeftX + fly);
		innerY[4] = (int) (topLeftY + (((4 * fly)/3.0) - (fly / Math.sqrt(2))));
	
		int[] outterX = new int[5];
		int[] outterY = new int[5];
		
		// Outline
		//C
		outterX[0] = (int) innerX[0] - border;
		outterY[0] = (int) innerY[0] + hC;

		//A
		outterX[1] = (int) (innerX[1] - border);
		outterY[1] = (int) (innerY[1] + border);

		//B
		outterX[2] = (int) (innerX[2] + hB);
		outterY[2] = (int) (innerY[2] + border);

		//E
		outterX[3] = (int) innerX[3] + hB;
		outterY[3] = (int) innerY[3] + border;

		//G
		outterX[4] = (int) (innerX[4] - hG);
		outterY[4] = (int) (outterY[3]);

		Color NEPAL_BLUE  = new Color(20, 55, 142);
		Color NEPAL_RED  = new Color(201, 49, 66);

		g.setColor(NEPAL_BLUE);
		g.fillPolygon(outterX, outterY, 5);

		g.setColor(NEPAL_RED);
		g.fillPolygon(innerX, innerY, 5);
	}
}