package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import Listener.LoginListenerClass;
import MainInterface.*;

public class TradeHistoryData extends AbstractTableModel {// 数据库导入JTable所用的表格模型
	String n;
	StockData sdData;
	int i = 1;
	private Vector<String> data;
	private Vector<String> title;

	public TradeHistoryData(String str) {
		if ((!str.equals("buy"))&&(!str.equals("sell"))){
			JOptionPane.showMessageDialog(null, "指令错误");
			return;
		}
		String sql = "select * from deal where " + str + "erId = '"
				+ User.jtfUsername.getText() + "'";
		drawTable(str, sql);
	}

	public void drawTable(String str, String sql) {
		data = new Vector<String>();
		// 读入数据库中的表格数据，包括股票名称、股票代码及股票价格
		Statement s = User.statement;
		ResultSet rs;
		try {
			rs = s.executeQuery(sql);
			while (rs.next()) {
				if (str.equals("buy")){
				data.add(rs.getString(1));
				}
				if (str.equals("sell")){
					data.add(rs.getString(2));
				}
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				data.add(rs.getString(5));
				data.add(rs.getString(6));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		title = new Vector<String>();
		if (str.equals("buy")) {
			title.add("ButyerID");
		} else
			title.add("SellerID");
		title.add("StockID");
		title.add("StockTime");
		title.add("Price");
		title.add("Number");
	}

	public void drawSellTable(String sqlsell) {
		// 读入数据库中的表格数据，包括股票名称、股票代码及股票价格
		Statement s = User.statement;
		ResultSet rs;
		data.clear();
		title.clear();
		try {
			rs = s.executeQuery(sqlsell);
			while (rs.next()) {
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				data.add(rs.getString(5));
				data.add(rs.getString(6));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		title = new Vector<String>();
		title.add("BuyerID");
		title.add("StockID");
		title.add("StockTime");
		title.add("Price");
		title.add("Number");
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size() / getColumnCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data.get((rowIndex * getColumnCount()) + columnIndex);
	}

	public String getColumnName(int columnIndex) {
		String colName = new String();
		if (columnIndex >= 0 && columnIndex <= (title.size()))
			colName = (String) title.get(columnIndex);
		return colName;
	}

}
