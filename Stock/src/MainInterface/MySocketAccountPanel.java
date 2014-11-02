package MainInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Listener.ViewMyStock;

import java.awt.*;

public class MySocketAccountPanel extends JPanel{
	public MySocketAccountPanel()
	{
		setLayout(new BorderLayout(5,10));
	      
	      JPanel jptable = new JPanel();
	      add(jptable,BorderLayout.WEST);
	      
	      JPanel jpother = new JPanel();
	      add(jpother,BorderLayout.CENTER);
	      
	      jpother.setLayout(new GridLayout(10,3,15,15));
	      
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
