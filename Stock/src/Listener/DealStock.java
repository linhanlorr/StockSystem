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
public class DealStock implements ActionListener{
	int mystocknum;
	Double mystockprice;
	String mystockID;
	Double myfrozenmoney;
	JTextField mystocknumJTextField;
	Statement s = LoginListenerClass.statement;
	public DealStock(JTextField jtnumber,String stockID, String nowprice) throws SQLException {
		// TODO Auto-generated constructor stub
		mystocknumJTextField=jtnumber;
		//mystocknum = Integer.parseInt(jtnumber.getText());
		mystockprice = Double.parseDouble(nowprice);
		mystockID = stockID; 
		//myfrozenmoney = mystockprice * mystocknum;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		mystocknum = Integer.parseInt(mystocknumJTextField.getText());
		myfrozenmoney = mystockprice * mystocknum;
		if(mystockID.startsWith("1"))
		{
			mystockID = mystockID.substring(1);
			if (myfrozenmoney <= LoginListenerClass.accountdDouble) {
				LoginListenerClass.accountdDouble -= myfrozenmoney;
				String sqlString1 = //"use gisstocksystem;"+
									//"use gisstocksystem;";
						"insert into `buyorder` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+mystockprice+","+mystocknum+");";
				String sqlString2 =//"insert into `buyorder` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+mystockprice+","+mystocknum+");"+
								   "insert into `frozenmoney` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+myfrozenmoney+");";
			    String sqlString3 ="insert into `frozenstock` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+mystocknum+");";
			    String sqlString4 ="update `capitalaccount` set account_balance = account_balance - "+myfrozenmoney+" where account_id = '"+LoginListenerClass.usernameString+"';";
				try {
					//if(LoginListenerClass.statement.executeQuery(sqlString1).next())
						//System.out.println("Using gisstocksystem success!");
					/*s.execute("insert into `buyorder` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+mystockprice+","+mystocknum+");");
					s.execute("insert into `frozenmoney` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+myfrozenmoney+");");
					s.execute("insert into `frozenstock` values('"+LoginListenerClass.usernameString+"','"+mystockID+"',now(),"+mystocknum+");");
					s.execute("update `capitalaccount` set account_balance = account_balance - "+myfrozenmoney+" where account_id = '"+LoginListenerClass.usernameString+"';");
					*/
					s.execute(sqlString1);
					s.execute(sqlString2);
					s.execute(sqlString3);
					s.execute(sqlString4);
					System.out.println("Deal success!");
					JOptionPane.showMessageDialog(null, "购买已经提交！请等待...","交易状态",JOptionPane.OK_OPTION);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Lack of money to deal!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Stocks cannot deal!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
