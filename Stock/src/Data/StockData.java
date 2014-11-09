package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Listener.LoginListenerClass;
import MainInterface.*;

public class StockData extends AbstractTableModel {// 数据库导入JTable所用的表格模型
	String n;
	StockData sdData;
	int i = 1;
	private Vector<String> data;
	private Vector<String> title;
	public ResultSet rs;

	public StockData() {
		String sql = "select * from stock";
		drawTable(sql);
	}

	public StockData(String sqlstring) {
		drawTable(sqlstring);
	}

	public void drawTable(String sql) {
		data = new Vector<String>();
		// 读入数据库中的表格数据，包括股票名称、股票代码及股票价格
		Statement s = User.statement;
		try {
			rs = s.executeQuery(sql);
			while (rs.next()) {
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3)+"%");
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
		title.add("股票代码");
		title.add("股票名称");
		title.add("涨幅");
		title.add("当前价格");
		title.add("开盘价");
		title.add("收盘价");
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
