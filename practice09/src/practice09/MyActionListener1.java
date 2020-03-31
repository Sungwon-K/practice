package practice09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class MyActionListener1 implements ActionListener{		
	MainMethod lis;
	public MyActionListener1(MainMethod lis) {
		this.lis = lis;
}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton c= (JButton)e.getSource();
		if(c.getText().equals("¹öÆ°1")) {
			lis.timeinfo.setText(new TimeInfo().s);
		}
		
	}
	
}