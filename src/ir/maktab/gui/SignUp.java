package ir.maktab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ir.maktab.DAO.LoginDAO;
import ir.maktab.DAO.SignUpDAO;
import ir.maktab.gui.Login.ButtonClickListener;
import ir.maktab.model.User;
import ir.maktab.shape.MFrame;

public class SignUp extends JFrame{

	JButton signButt = new JButton("Sign Up");
	JTextField tfUser = new JTextField();
	JPasswordField tfPass = new JPasswordField();
	JTextField tfId = new JTextField();
	JLabel l1 = new JLabel("User Name");
	JLabel l2 = new JLabel("Password");
	JLabel l3 = new JLabel("ID");
	
	public SignUp() {
		
		l3.setBounds(120, 100, 100, 30);
		tfId.setBounds(200, 100, 110, 30);
		l1.setBounds(120, 150, 100, 30);
		tfUser.setBounds(200, 150, 110, 30);
		l2.setBounds(120, 200, 100, 30);
		tfPass.setBounds(200, 200, 110, 30);
		signButt.setBounds(220, 250, 70, 30);
		
		ButtonClickListener click = new ButtonClickListener();
		signButt.addActionListener(click);
		
		getContentPane().add(tfUser);
		getContentPane().add(tfPass);
		getContentPane().add(signButt);
		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(l3);
		getContentPane().add(tfId);
		
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}
	
	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == signButt) {
				
				String u = tfUser.getText();
				String pass = tfPass.getText();
				String id = tfId.getText();
				
				SignUpDAO lDAO = new SignUpDAO();
				
				lDAO.addUser(Integer.parseInt(id), u, pass);
				
			}
			
		}

	}
}
