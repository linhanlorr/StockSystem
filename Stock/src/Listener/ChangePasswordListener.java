package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.mysql.jdbc.Statement;

import MainInterface.User;

public class ChangePasswordListener implements ActionListener {
	private JPasswordField jpfOld;
	private JPasswordField jpfNew;
	private JPasswordField jpfNewConfirm;

	public ChangePasswordListener(JPasswordField jpfOld, JPasswordField jpfNew,
			JPasswordField jpfNewConfirm) {
		this.jpfOld = jpfOld;
		this.jpfNew = jpfNew;
		this.jpfNewConfirm = jpfNewConfirm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldP = String.valueOf(jpfOld.getPassword()).trim();
		String newP = String.valueOf(jpfNew.getPassword()).trim();
		String newConfirmP = String.valueOf(jpfNewConfirm.getPassword()).trim();
		Statement s = User.statement;
		ResultSet rs;

		if (oldP.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入旧密码", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			jpfOld.setText("");
			jpfNew.setText("");
			jpfNewConfirm.setText("");
			return;
		}
		if (newP.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入新密码", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			jpfOld.setText("");
			jpfNew.setText("");
			jpfNewConfirm.setText("");
			return;
		}
		if (!newP.equals(newConfirmP)) {
			JOptionPane.showMessageDialog(null, "密码和密码确认不一致", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			jpfOld.setText("");
			jpfNew.setText("");
			jpfNewConfirm.setText("");
			return;
		}

		try {
			String sqlsearch = "select account_password from capitalaccount where account_id = '"
					+ User.jtfUsername.getText() + "'";
			rs = s.executeQuery(sqlsearch);
			rs.next();
			String password = rs.getString("account_password");
			if (!oldP.equals(password)){
				JOptionPane.showMessageDialog(null, "旧密码错误", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				jpfOld.setText("");
				jpfNew.setText("");
				jpfNewConfirm.setText("");
				return;
			}
			
			String sqlchange = "update capitalaccount set account_password='"+newP+"' where account_id = '"
					+ User.jtfUsername.getText() + "'";
			s.execute(sqlchange);
			JOptionPane.showMessageDialog(null, "修改密码成功","Succeed!",JOptionPane.INFORMATION_MESSAGE);
			jpfOld.setText("");
			jpfNew.setText("");
			jpfNewConfirm.setText("");
			return;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
