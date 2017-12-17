package ir.maktab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ir.maktab.DAO.LoginDAO;
import ir.maktab.model.User;
import ir.maktab.shape.MFrame;


public class Login {

	JButton loginButt = new JButton("Login");
	JButton signButt = new JButton("Sign Up");
	JTextField tfUser = new JTextField();
	JPasswordField tfPass = new JPasswordField();
	JLabel l1 = new JLabel("User Name");
	JLabel l2 = new JLabel("Password");
	
	JFrame f = new JFrame();
	
	public Login() {
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1.setBounds(120, 100, 100, 30);
		tfUser.setBounds(200, 100, 110, 30);
		l2.setBounds(120, 150, 100, 30);
		tfPass.setBounds(200, 150, 110, 30);
		loginButt.setBounds(220, 200, 70, 30);
		signButt.setBounds(220, 300, 80, 50);
	
		ButtonClickListener click = new ButtonClickListener();
		loginButt.addActionListener(click);
		
		f.getContentPane().add(tfUser);
		f.getContentPane().add(tfPass);
		f.getContentPane().add(loginButt);
		f.getContentPane().add(l1);
		f.getContentPane().add(l2);
		f.getContentPane().add(signButt);
		
		signButt.addActionListener(click);
		
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Login log = new Login();
	}
	
	class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == loginButt) {
				
				String u = tfUser.getText();
				String pass = tfPass.getText();
				
				LoginDAO lDAO = new LoginDAO();
				
				User use = lDAO.getUser(u, pass);
				if(use==null) {
					System.out.println("faildd");
					JOptionPane.showMessageDialog(f, "User or Password is Wrong", "Dialog",
					        JOptionPane.ERROR_MESSAGE);
					tfUser.setText("");
					tfPass.setText("");
				}else {
					MFrame pf = new MFrame(use);
					f.dispose();
				}
				
			}
			
			if (e.getSource() == signButt) {
			
				SignUp up = new SignUp();
				f.dispose();
			}
		}

	}
}
