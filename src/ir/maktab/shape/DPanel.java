package ir.maktab.shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ir.maktab.DAO.ShapeDAO;
import ir.maktab.model.User;

public class DPanel extends JPanel {

	private ArrayList<MShape> myShapes;

	private int currentShapeType;
	private MShape currentShapeObject;
	private Color currentShapeColor;
	private ShapeDAO dao;
	JLabel statusLabel;

	private int userID;

	public DPanel(User u) {

		dao = new ShapeDAO();
		myShapes = new ArrayList<MShape>();
		myShapes = dao.get(u.getId());

		userID = u.getId();

		currentShapeType = 0;
		currentShapeObject = null;
		currentShapeColor = Color.BLACK;

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		MouseHandler handler = new MouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int counter = myShapes.size() - 1; counter >= 0; counter--)
			myShapes.get(counter).draw(g);

		if (currentShapeObject != null)
			currentShapeObject.draw(g);
	}

	public void setCurrentShapeType(int type) {
		currentShapeType = type;
	}

	public void setCurrentShapeColor(Color color) {
		currentShapeColor = color;
	}

	private class MouseHandler extends MouseAdapter {

		public void mousePressed(MouseEvent event) {
			switch (currentShapeType) {
			case 0:
				currentShapeObject = new Line(event.getX(), event.getY(), event.getX(), event.getY(),
						currentShapeColor);
				break;
			case 1:
				currentShapeObject = new Rectangle(event.getX(), event.getY(), event.getX(), event.getY(),
						currentShapeColor);
				break;
			case 2:
				currentShapeObject = new Oval(event.getX(), event.getY(), event.getX(), event.getY(),
						currentShapeColor);
				break;

			}
		}

		public void mouseReleased(MouseEvent event) {

			currentShapeObject.setX2(event.getX());
			currentShapeObject.setY2(event.getY());

			myShapes.add(currentShapeObject);
			dao.add(currentShapeObject, userID);

			currentShapeObject = null;

			repaint();

		}

		public void mouseMoved(MouseEvent event) {

		}

		public void mouseDragged(MouseEvent event) {

			currentShapeObject.setX2(event.getX());
			currentShapeObject.setY2(event.getY());

			repaint();

		}

	}
}
