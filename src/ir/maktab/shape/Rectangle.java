package ir.maktab.shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Bound {

	public Rectangle() {
		super();
	}

	public Rectangle(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color, false);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());

		g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}
}
