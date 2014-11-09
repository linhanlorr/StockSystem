package MainInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Listener.ViewMyStock;

import java.awt.*;

public class MyFundAccount extends JFrame{
	public MyFundAccount(boolean b)
	{
		setTitle("我的资金账户");
		setResizable(false);
		setSize(800, 200);
		setLocationRelativeTo(null);
		setContentPane(new MyFundAccountPanel());
		setVisible(b);
	}
}
