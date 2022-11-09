import java.awt.Color;
import java.awt.Graphics;

public class Stripe {
	Color color;
	
	public Stripe(Color c) {
		this.color = c;
	}

	public void draw(Graphics g, int x, int y, int w, int h) {
		Color orig = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, w, h);
		g.setColor(orig);
	}
}