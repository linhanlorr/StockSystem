package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MainInterface.SearchStock;
import MainInterface.User;

import com.mysql.jdbc.Statement;

public class SearchStockListener implements ActionListener {

	private JTextField jtfstockID = null;
	private JTextField jtfstockName = null;
	private boolean isID;
	private String stockID = "";
	private String stockName = "";

	public SearchStockListener(int i, JTextField jtf) {
		if (i == 1) {
			isID = true;
			jtfstockID = jtf;
		} else {
			isID = false;
			jtfstockName = jtf;
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ResultSet result;

		if (isID)
			stockID = jtfstockID.getText().trim();
		else
			stockName = jtfstockName.getText().trim();

		if (stockID.equals("") && stockName.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入有效的股票代码或名称", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String sqlString = "select * from Stock where ";
		if (isID) {
			sqlString += "stock_id like '%" + stockID + "%'";
		} else {
			sqlString += "name like '%" + stockName + "%'";
		}

		try {
			System.out.println(sqlString);
			result = User.statement.executeQuery(sqlString);
			if (result.last()) {
				new SearchStock(sqlString);
				return;
			} else {
				JOptionPane.showMessageDialog(null, "查询的股票不存在", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
