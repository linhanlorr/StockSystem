package MainInterface;

import javax.swing.*;

import Listener.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login extends JFrame{//登录窗口
	
	private JFrame vFrame = new JFrame();
	public static JFrame jFrame;
	private Map<String, JComponent> info;
	private ValidCode vcode;
	
	@SuppressWarnings("null")
	public Login()
	{
		
		info = new HashMap<String, JComponent>();
		initComponents();
		
		JTextField field = new JTextField(15);
		field.setPreferredSize(new Dimension(40, 40));
		vcode = new ValidCode();
		info.put("code", field);
		
		JTextField jtfUserName = new JTextField("barry_wang",20);
		User.jtfUsername = jtfUserName;
		JPasswordField jpfPassword = new JPasswordField("xxx1",20);
		JButton jbtLogin = new JButton("登  录");
		JLabel jlName = new JLabel("账  户  卡  号         :");
		JLabel jlPassword = new JLabel("账  户  密  码          :");
		JLabel jlIP = new JLabel("               I P               :");
		JTextField jtfIP = new JTextField("222.205.25.19",20);
	
		JPanel jPanel = new JPanel();

		jPanel.add(jlIP);
		jPanel.add(jtfIP);
		jPanel.add(jlName);
		jPanel.add(jtfUserName);
		jPanel.add(jlPassword);
		jPanel.add(jpfPassword);
		jPanel.add(field);

		jPanel.add(vcode);
		jPanel.add(jbtLogin);

		add(jPanel);

	
		LoginListenerClass loginListenerClass = new LoginListenerClass(jtfUserName,jpfPassword,jtfIP,field,vcode);
		jbtLogin.addActionListener(loginListenerClass);
	}
	
	public static void main(String []agrs)
	{
		jFrame = new Login();
		jFrame.setTitle("股票交易系统登录");
		jFrame.setSize(300, 250);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}

	private void initComponents()
	{
		
	}

}
