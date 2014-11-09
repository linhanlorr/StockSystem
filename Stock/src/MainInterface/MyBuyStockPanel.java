package MainInterface;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;

import Data.StockData;
import Listener.DealStock;
import Listener.LoginListenerClass;
import Listener.ViewMyStock;

public class MyBuyStockPanel extends JPanel{
	private JTextField stockInfo = new JTextField();
	public MyBuyStockPanel(String stock_info, String stockID, String nowprice) throws SQLException
	{
		 
		 setLayout(new BorderLayout(5,10));
		 JPanel jpstockInfo = new JPanel();
		 add(jpstockInfo,BorderLayout.WEST);
		 
		 JTextArea stock_text_areaArea = new JTextArea(stock_info,9,40);
		 stock_text_areaArea.setLineWrap(true);
		 stock_text_areaArea.setEditable(false);
		 //stock_text_areaArea.setFont(new Font("Courier"));
		 JScrollPane scrollPane_si = new JScrollPane(stock_text_areaArea);
		 jpstockInfo.add(scrollPane_si);
		 
	     JPanel jpother = new JPanel();
	     add(jpother,BorderLayout.EAST);
	     //jpother.setLayout(new GridLayout(13,3,15,15));
		 
	     JLabel jlnumber = new JLabel("请输入您所需要购买的股票数目:");
	     jpother.add(jlnumber);
	     JTextField jtnumber = new JTextField("100",4);
	     jpother.add(jtnumber);
	     JButton jbstocknumber = new JButton("购买");
	     jpother.add(jbstocknumber);
	     //String tempString = jtnumber.getText();
	     DealStock dealStock =new DealStock(jtnumber, stockID, nowprice);
	     jbstocknumber.addActionListener(dealStock);
	     
	}
	
}
