package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MainInterface.*;

public class BuyStock implements ActionListener{
	JTextField myjtf;
	String stockID;
	String accountID = LoginListenerClass.usernameString;
	String accountpassword = LoginListenerClass.passwordString.toString();
	Double myaccount;
	
	String stockInfo;
	
	public BuyStock(JTextField jtf)
	{
		//加入名称和代码的判断
		myjtf = jtf;
		ResultSet res;
		String sql_getaccount = "select account_balance from capitalaccount where account_id = '"+accountID+"';";
		try {
			res = LoginListenerClass.statement.executeQuery(sql_getaccount);
			res.next();
			myaccount = res.getDouble("account_balance");
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace(); 
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		stockID = myjtf.getText();
		String sql_buy;
		ResultSet res;
		sql_buy = "select * from stock where stock_id = '"+stockID+"';";
		//System.out.println(sql_buy + myaccount);
		try {
			res = LoginListenerClass.statement.executeQuery(sql_buy);
			if (res.next()) {
				///
				String stateString = "";
				if (res.getString(10).equals("1")) {
					stateString = "开盘";				
				} else {
					stateString = "停盘";
				}
				stockInfo = "StockID:"+res.getString(1)+"\n"+
							"StockName:"+res.getString(2)+"\n"+
							"RISE:"+res.getString(3)+"\n"+
							"NowPrice:"+res.getString(4)+"\n"+
							"OpenPrice:"+res.getString(5)+"\n"+
							"ClosePrice:"+res.getString(6)+"\n"+
							"State:"+stateString+"\n"+
							"Number:"+res.getString(11)+"\n";
				stockID = res.getString(10) + stockID;
				new MyBuyStock(true,stockInfo,stockID,res.getString(4));
			} 
			else {
				JOptionPane.showMessageDialog(null, "Stock may not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
