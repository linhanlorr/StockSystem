package MainInterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Listener.ViewMyStock;



public class MyStockViewPanel extends JPanel{
	public MyStockViewPanel()
	   {  
	      setLayout(new BorderLayout(5,10));
	      
	      JPanel jptable = new JPanel();
	      add(jptable,BorderLayout.WEST);
	      
	      JPanel jpother = new JPanel();
	      add(jpother,BorderLayout.CENTER);
	      
	      jpother.setLayout(new GridLayout(13,3,15,15));
	      
	      JTable jtAllInfo;
	      Object[][] data = 
	      {
	    	  new Object[]{"Google","44589"},
	    	  new Object[]{"Baidu","32249"},
	    	  new Object[]{"AliBaBa","66547"}
	      };
	      Object title[] =
	    		  {
	    		  	"股票名称","股票代码"
	    		  };
	      jtAllInfo = new JTable(data,title){ 
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
	      
	      JButton btViewMyStock = new JButton("查询我的股票");
	      btViewMyStock.setSize(20, 10);
	      jpother.add(btViewMyStock);
	      ViewMyStock vms = new ViewMyStock();
	      btViewMyStock.addActionListener(vms);
	  
	      JButton btViewMyFundAccount = new JButton("查询我的资金账户");
	      jpother.add(btViewMyFundAccount);
	      
	      JLabel lb1 = new JLabel("请输入股票名称：");
	      jpother.add(lb1);
	      
	      JTextField jtfStockName = new JTextField();
	      jpother.add(jtfStockName);
	      
	      JLabel lb2 = new JLabel("请输入股票代码：");
	      jpother.add(lb2);
	      
	      JTextField jtfStockSymbol = new JTextField();
	      jpother.add(jtfStockSymbol);
	      
	      JButton btSearch = new JButton("查询");
	      jpother.add(btSearch);
	      
	   }
}
