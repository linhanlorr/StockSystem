package MainInterface;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Data.StockData;

public class SearchStock extends JFrame {

	public JPanel searchPanel(String str) {
		JPanel jp = new JPanel();
		JTable jtAllInfo;
		jtAllInfo = new JTable(new StockData(str)) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		jtAllInfo.setPreferredScrollableViewportSize(new Dimension(600, 500));

		JScrollPane scrollPane = new JScrollPane(jtAllInfo);
		jp.add(scrollPane);
		return jp;
	}

	public SearchStock(String str) {
		setTitle("Search Stocks");
		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(searchPanel(str));
	}
}
