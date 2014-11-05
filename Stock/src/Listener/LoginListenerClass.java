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

	public Statement statement;
	public JTextField jtf1;
	public JPasswordField jpf1;
	public JTextField jtfipField;
	public String usernameString;
	public char[] passwordString;

	String pw;

	public LoginListenerClass(JTextField jtf, JPasswordField jpf, JTextField jip) {
		jtf1 = jtf;
		jpf1 = jpf;
		jtfipField = jip;
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
		sqlString = "select account_password from capitalaccount where account_id = '"
				+ jtf1.getText() + "'";
		try {
			int i = 0;
			result = statement.executeQuery(sqlString);
			while (result.next()) {
				pw = result.getString("account_password");
				if (pw.equals(String.valueOf(passwordString))) {
					i = 1;
					break;
				}

			}
			if (i == 1) {
				System.out.println("Login Success!");
				new ViewSecurityAccount(true);
				Login.jFrame.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null,
						"Username or Password incorrect!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
