package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MainInterface.*;

public class LoginListenerClass implements ActionListener {// 登录监听事件

	public static Statement statement;
	public JTextField jtf1;
	public JPasswordField jpf1;
	public JTextField jtfipField;
	public static String usernameString;
	public static char[] passwordString;
	public static Double accountdDouble;
	
	private JTextField vcfield;
	private int count=0;
	
	ValidCode vCode;
	String pw;

	public LoginListenerClass(JTextField jtf, JPasswordField jpf, JTextField jip,JTextField field,ValidCode vc) {
		jtf1 = jtf;
		jpf1 = jpf;
		jtfipField = jip;
		vcfield = field;
		vCode = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Connection connection;

		String sqlString;
		String url;

		// 连接数据库222.205.38.252
		url = "jdbc:mysql://" + jtfipField.getText()
				+ ":3306/gisstocksystem?user=root&password=root";
		ResultSet result;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 数据库连接并创建Statement
			System.out.println("JDBC driver starts successfully!");
			connection = DriverManager.getConnection(url);
			System.out.println("MySQL connects successfully!");
			statement = connection.createStatement();
			User.statement = (com.mysql.jdbc.Statement) statement;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "数据库连接错误", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// 从数据库中查找用户,比对密码
		usernameString = jtf1.getText();
		passwordString = jpf1.getPassword();
		sqlString = "select account_password,account_balance from capitalaccount where account_id = '"
				+ jtf1.getText() + "'";
		try {
			int i = 0;
			result = statement.executeQuery(sqlString);
			while (result.next()) {
				pw = result.getString("account_password");
				accountdDouble = Double.parseDouble(result.getString("account_balance"));
				if (pw.equals(String.valueOf(passwordString))) {//判断密码
					if(vCode.getCode().equals(vcfield.getText()))//判断验证码
					{
						i = 1;
						break;
					}else {
						JOptionPane.showMessageDialog(null,
								"验证码错误!", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}

			}
			if (i == 1) {
				System.out.println("Login Success!");
				new ViewSecurityAccount(true);
				Login.jFrame.setVisible(false);
			} 
			else //判断登陆次数，最多只能有五次
			{
				count++;
				JOptionPane.showMessageDialog(null,
						"用户名或密码错误!还有"+count+"次机会!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				if(count==5)
				{
					count=0;
					System.exit(0);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
