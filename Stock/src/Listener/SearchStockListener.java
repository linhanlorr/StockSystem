package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearchStockListener implements ActionListener {

	private JTextField jtfstockID;
	private JTextField jtfstockName;
	private String stockID;
	private String stockName;

	public SearchStockListener(JTextField sid, JTextField sname) {
		jtfstockID = sid;
		jtfstockName = sname;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		stockID = jtfstockID.getText().trim();
		stockName = jtfstockName.getText().trim();
		
		if (stockID.equals("") && stockName.equals("")){
			JOptionPane.showMessageDialog(null, "请输入有效的股票代码或名称", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
//		String sqlString = "select * from Stock where id = "+"or name";
		
	}

}
