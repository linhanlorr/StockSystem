package MainInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Listener.ViewMyStock;

import java.awt.*;
import java.sql.SQLException;

public class MyBuyStock extends JFrame{
	public MyBuyStock(boolean b,String stockinfo, String stockID, String nowprice) throws SQLException
	{
		setTitle("BUY");
		setResizable(false);
		setSize(800, 200);
		setLocationRelativeTo(null);
		setContentPane(new MyBuyStockPanel(stockinfo,stockID,nowprice));
		setVisible(true);
	}
}
