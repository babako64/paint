package ir.maktab.shape;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Bound {
	public Oval() {
		super();
	}

	public Oval(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color, false);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());

		g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}

}
