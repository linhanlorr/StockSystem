package MainInterface;

import javax.swing.*;

import Listener.*;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends JFrame{
	
	//private ViewSecurityAccount vAccount = new ViewSecurityAccount();
	private JFrame vFrame = new JFrame();
	
	public Login()
	{
	JTextField jtfUserName = new JTextField(20);
	JPasswordField jpfPassword = new JPasswordField(20);
	JButton jbtLogin = new JButton("Login");
	JLabel jlName = new JLabel("UserName  :");
	JLabel jlPassword = new JLabel("Password   :");
	
	JPanel jPanel = new JPanel();

	jPanel.add(jlName);
	jPanel.add(jtfUserName);
	jPanel.add(jlPassword);
	jPanel.add(jpfPassword);
	jPanel.add(jbtLogin);
	add(jPanel);
	
	//vFrame.add(vAccount);
	//vFrame.setTitle("Stock Account");
	//vFrame.setSize(1000, 600);
	//vFrame.setLocationRelativeTo(null);
	//vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	LoginListenerClass loginListenerClass = new LoginListenerClass(jtfUserName,jpfPassword,vFrame);
	jbtLogin.addActionListener(loginListenerClass);
	}
	
	public static void main(String []agrs)
	{
		JFrame jFrame = new Login();
		jFrame.setTitle("Stock System Login");
		jFrame.setSize(300, 220);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
