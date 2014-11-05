package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import Listener.LoginListenerClass;
import MainInterface.*;

public class MyFundData extends AbstractTableModel{

	String sql;
	String n;
	Statement s;
	StockData sdData;
	ResultSet rs;
	int i = 1;
	private Vector<String> data;
	private Vector<String> title;
	private JTextField userID2;
	
	public MyFundData()
	{
		userID2 = User.jtfUsername;
		data = new Vector<String>();
		//读入数据库中的表格数据，包括股票名称、股票代码及股票价格  
		  sql="SELECT account_balance,m FROM capitalaccount inner join (select sellerid,sum(money) as m from frozenmoney group by sellerid) as A on capitalaccount.account_id = A.sellerid where account_id='"+userID2.getText()+"';";
		  s = User.statement;
		  try 
		  {
			rs = s.executeQuery(sql);
			while(rs.next())
			{
				data.add(rs.getString(1));
				data.add(rs.getString(2));
			}
		  } 
		  catch (SQLException e) 
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		
		  title = new Vector<String>();
		  title.add("可用资金");
		  title.add("冻结资金");
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size()/getColumnCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data.get((rowIndex*getColumnCount())+columnIndex);
	}
	
	public String getColumnName(int columnIndex) {
        String colName = new String();
          if (columnIndex>=0&&columnIndex<=(title.size()))
           colName=(String)title.get(columnIndex);
          return colName;
 }
}
