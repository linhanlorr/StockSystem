package MainInterface;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Listener.ChangePasswordListener;

public class ChangePassword extends JFrame{
	public JPanel changePanel(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,2));
		
		JLabel jlbUsername = new JLabel("用户名：");
		JTextField jtfUsername = new JTextField(User.jtfUsername.getText());
		jtfUsername.setEditable(false);
		jp.add(jlbUsername);
		jp.add(jtfUsername);
		
		JLabel jlbOldPassword = new JLabel("旧密码：");
		JPasswordField jpfOldPassword = new JPasswordField(20);
		jp.add(jlbOldPassword);
		jp.add(jpfOldPassword);
		
		JLabel jlbNewPassword = new JLabel("新密码：");
		JPasswordField jpfNewPassword = new JPasswordField(20);
		jp.add(jlbNewPassword);
		jp.add(jpfNewPassword);
		
		JLabel jlbNewPasswordConfirm = new JLabel("再次输入新密码：");
		JPasswordField jpfNewPasswordConfirm = new JPasswordField(20);
		jp.add(jlbNewPasswordConfirm);
		jp.add(jpfNewPasswordConfirm);
		
		JButton btConfirm = new JButton("确认修改");
		btConfirm.addActionListener(new ChangePasswordListener(jpfOldPassword,jpfNewPassword,jpfNewPasswordConfirm));
		jp.add(btConfirm);
		
		return jp;
	}
	
	public ChangePassword(){
		setTitle("Change Password");
		setResizable(false);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(changePanel());
	}
}
