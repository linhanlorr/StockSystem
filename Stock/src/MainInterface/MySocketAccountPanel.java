package MainInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Data.MyStockData;
import Listener.ViewMyStock;

import java.awt.*;

public class MySocketAccountPanel extends JPanel{//查询我的股票的窗口的控件及布局（My Stock View）
	public MySocketAccountPanel()
	{
		setLayout(new BorderLayout(5,10));
	      
	      JPanel jptable = new JPanel();
	      add(jptable,BorderLayout.WEST);
	      
	      JPanel jpother = new JPanel();
	      add(jpother,BorderLayout.CENTER);
	      
	      jpother.setLayout(new GridLayout(10,3,15,15));
	      
	      JTable jtAllInfo;
	      
	      jtAllInfo = new JTable(new MyStockData()){ 
	    	  public boolean isCellEditable(int row,int col){ 
	    		   return false;
	    		} 
	    		};
	      jtAllInfo.setPreferredScrollableViewportSize(new Dimension(600, 500));
	      //add(jtAllInfo);
	      
	      JScrollPane scrollPane = new JScrollPane(jtAllInfo);
	      jptable.add(scrollPane);
	      
	      JLabel lbblank = new JLabel("");
	      jpother.add(lbblank);
	      
	      
	      JLabel lbstockname = new JLabel("请输入股票名称：");
	      jpother.add(lbstockname);
	      
	      JTextField jtfStockName = new JTextField();
	      jpother.add(jtfStockName);
	      
	      JLabel lbstocksymbol = new JLabel("请输入股票代码：");
	      jpother.add(lbstocksymbol);
	      
	      JTextField jtfStockSymbol = new JTextField();
	      jpother.add(jtfStockSymbol);
	      
	      JButton btbuy = new JButton("购买股票");
	      jpother.add(btbuy);
	      
	      JButton btseal = new JButton("卖出股票");
	      jpother.add(btseal);
	   
	}
}
