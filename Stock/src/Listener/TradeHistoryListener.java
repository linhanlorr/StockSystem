package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainInterface.TradeHistory;

public class TradeHistoryListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new TradeHistory();
	}

}
