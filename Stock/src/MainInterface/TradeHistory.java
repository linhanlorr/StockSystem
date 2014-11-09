package MainInterface;

import java.awt.BorderLayout;
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
		jp.setLayout(new BorderLayout());
		
		JPanel jpbuy = new JPanel();
		jpbuy.setLayout(new BorderLayout());
		JLabel jlBuy = new JLabel("买记录");
		jpbuy.add(jlBuy,BorderLayout.NORTH);
		JTable jtBuy;
		jtBuy = new JTable(new TradeHistoryData("buy")) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		jtBuy.setPreferredScrollableViewportSize(new Dimension(600, 200));
		JScrollPane buyScrollPane = new JScrollPane(jtBuy);
		jpbuy.add(buyScrollPane,BorderLayout.CENTER);
		
		JPanel jpsell = new JPanel();
		jpsell.setLayout(new BorderLayout());
		JLabel jlSell = new JLabel("卖记录");
		jpsell.add(jlSell,BorderLayout.NORTH);
		JTable jtSell;
		jtSell = new JTable(new TradeHistoryData("sell")) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		jtSell.setPreferredScrollableViewportSize(new Dimension(600, 200));
		JScrollPane sellScrollPane = new JScrollPane(jtSell);
		jpsell.add(sellScrollPane,BorderLayout.CENTER);
		
		jp.add(jpbuy,BorderLayout.NORTH);
		jp.add(jpsell,BorderLayout.SOUTH);
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
