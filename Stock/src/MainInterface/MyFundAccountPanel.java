package MainInterface;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import Data.MyFundData;
import Data.StockData;
import Listener.LoginListenerClass;
import Listener.ViewMyStock;

public class MyFundAccountPanel extends JPanel{
	public MyFundAccountPanel()
	{
		setLayout(new BorderLayout(5,10));
	      
	      JPanel jptable = new JPanel();
	      add(jptable,BorderLayout.WEST);
	      
	      JPanel jpother = new JPanel();
	      add(jpother,BorderLayout.CENTER);
	      
	      jpother.setLayout(new BorderLayout());
	      
	      JTable jtAllInfo;
	      
	      jtAllInfo = new JTable(new MyFundData()){ 
	    	  public boolean isCellEditable(int row,int col){ 
	    		   return false;
	    		} 
	    		};
	      jtAllInfo.setPreferredScrollableViewportSize(new Dimension(600, 500));
	      //add(jtAllInfo);
	      
	      JScrollPane scrollPane = new JScrollPane(jtAllInfo);
	      jptable.add(scrollPane);
  
	      JLabel lbstocksymbol = new JLabel("我的资金账户");
	      jpother.add(lbstocksymbol,BorderLayout.CENTER);
	      
	      
	}
}
