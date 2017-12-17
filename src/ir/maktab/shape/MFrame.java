package ir.maktab.shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import ir.maktab.gui.Login;
import ir.maktab.model.User;

public class MFrame extends JFrame {

	private DPanel panel;

	private JButton rec;
	private JButton circle;
	private JButton line;

	private JButton exite;

	ButtonGroup cbg;
	JRadioButton redButton;
	JRadioButton greenButton;
	JRadioButton blueButton;
	JRadioButton blackButton;

	private JPanel widgetJPanel;
	private JPanel widgetPadder;

	JFrame jf;

	public MFrame(User u) {

		jf = this;
		panel = new DPanel(u);

		rec = new JButton("مستطیل");
		circle = new JButton("دایره");
		line = new JButton("خط");

		exite = new JButton("خروج");

		cbg = new ButtonGroup();
		redButton = new JRadioButton("قرمز");
		greenButton = new JRadioButton("سبز");
		blueButton = new JRadioButton("آبی");
		blackButton = new JRadioButton("مشکی");

		cbg.add(redButton);
		cbg.add(greenButton);
		cbg.add(blueButton);
		cbg.add(blackButton);

		widgetJPanel = new JPanel();
		widgetJPanel.setLayout(new GridLayout(1, 6, 10, 10));

		widgetPadder = new JPanel();
		widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));

		widgetJPanel.add(rec);
		widgetJPanel.add(circle);
		widgetJPanel.add(line);
		widgetJPanel.add(redButton);
		widgetJPanel.add(greenButton);
		widgetJPanel.add(blueButton);
		widgetJPanel.add(blackButton);

		widgetJPanel.add(exite);

		widgetPadder.add(widgetJPanel);

		add(widgetPadder, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

		ButtonHandler buttonHandler = new ButtonHandler();
		rec.addActionListener(buttonHandler);
		circle.addActionListener(buttonHandler);
		line.addActionListener(buttonHandler);

		exite.addActionListener(buttonHandler);

		redButton.addActionListener(buttonHandler);
		greenButton.addActionListener(buttonHandler);
		blueButton.addActionListener(buttonHandler);
		blackButton.addActionListener(buttonHandler);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 500);
		setVisible(true);

		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jf.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(jf, "Are you sure to close this window?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					jf.dispose();
					Login l = new Login();
				}
			}
		});

	}

	private class ButtonHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("خط")) {

				panel.setCurrentShapeType(0);
			} else if (event.getActionCommand().equals("مستطیل")) {
				panel.setCurrentShapeType(1);
			} else if (event.getActionCommand().equals("دایره")) {
				panel.setCurrentShapeType(2);
			}

			if (event.getActionCommand().equals("قرمز")) {
				panel.setCurrentShapeColor(Color.RED);
			} else if (event.getActionCommand().equals("سبز")) {
				panel.setCurrentShapeColor(Color.green);
			} else if (event.getActionCommand().equals("آبی")) {
				panel.setCurrentShapeColor(Color.blue);
			} else if (event.getActionCommand().equals("مشکی")) {
				panel.setCurrentShapeColor(Color.black);
			}

			if (event.getActionCommand().equals("خروج")) {
				Login logon = new Login();
				jf.dispose();
			}

		}
	} 
}
