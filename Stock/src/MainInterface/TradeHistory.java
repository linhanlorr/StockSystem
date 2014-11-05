package MainInterface;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Data.StockData;
import Data.TradeHistoryData;

public class TradeHistory extends JFrame {

	public JPanel TradeHistoryPanel() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4,1));
		
		JLabel jlBuy = new JLabel("买记录");
		jp.add(jlBuy);
		JTable jtBuy;
		jtBuy = new JTable(new TradeHistoryData("buy")) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		jtBuy.setPreferredScrollableViewportSize(new Dimension(600, 500));
		JScrollPane buyScrollPane = new JScrollPane(jtBuy);
		jp.add(buyScrollPane);
		
		JLabel jlSell = new JLabel("买记录");
		jp.add(jlSell);
		JTable jtSell;
		jtSell = new JTable(new TradeHistoryData("sell")) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		jtSell.setPreferredScrollableViewportSize(new Dimension(600, 500));
		JScrollPane sellScrollPane = new JScrollPane(jtSell);
		jp.add(sellScrollPane);
		
		
		
		return jp;
	}

	public TradeHistory() {
		setTitle("Trade History");
		setResizable(false);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(TradeHistoryPanel());
	}
}
