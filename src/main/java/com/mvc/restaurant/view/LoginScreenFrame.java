package com.mvc.restaurant.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginScreenFrame {

	private JFrame loginScreenFrame;
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JButton loginButton;

	public LoginScreenFrame() {
	}

	public void initialize() {
		loginScreenFrame = new JFrame();
		loginScreenFrame.setBounds(100, 100, 450, 300);
		loginScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginScreenFrame.getContentPane().setLayout(null);

		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		userNameLabel.setBounds(27, 43, 111, 21);
		loginScreenFrame.getContentPane().add(userNameLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		passwordLabel.setBounds(27, 88, 111, 21);
		loginScreenFrame.getContentPane().add(passwordLabel);

		userNameField = new JTextField();
		userNameField.setBounds(158, 43, 228, 27);
		loginScreenFrame.getContentPane().add(userNameField);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 85, 228, 27);
		loginScreenFrame.getContentPane().add(passwordField);

		loginButton = new JButton("LOGIN");
		loginButton.setForeground(Color.BLACK);
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setBounds(298, 142, 88, 25);
		loginScreenFrame.getContentPane().add(loginButton);
		loginScreenFrame.setVisible(true);
	}

	// Send useful methods.
	public String getUserName() {
		return userNameField.getText();
	}

	public String getPassword() {
		String password = new String(passwordField.getPassword());
		return password;
	}

	public void loginButtonAction(ActionListener actionListener) {
		loginButton.addActionListener(actionListener);
	}
}
