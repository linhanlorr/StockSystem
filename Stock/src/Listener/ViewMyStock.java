package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MainInterface.*;

public class ViewMyStock implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new MySocketAccount(true);
		
	}

}
