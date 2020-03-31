package practice09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gallery2 extends JFrame {
	
	private JLabel imageLabel = new JLabel();
	private ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	public int index =2;
	
	public Gallery2(){
		this.setTitle("Gallelry2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		Container g = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		
		radioPanel.setBackground(Color.GRAY);
		
		
		
		JButton btn = new JButton("Prev");
		JButton btn2 = new JButton("Next");
			
		g.add(btn);
		g.add(btn2);
		
		radioPanel.add(btn);
		radioPanel.add(btn2);
		
		
		btn.addActionListener(new MyActionListener());
		btn2.addActionListener(new MyActionListener());
		
		
		imageLabel.setIcon(image[index]);
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.setSize(250, 200);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b= (JButton)e.getSource();
			if(b.getText().equals("Prev"))
				index--;
			else if(b.getText().equals("Next"))
				index++;
			
			if(index<0)
				index = 2;
			else if(index>2)
				index = 0;
			
			imageLabel.setIcon(image[index]);
			
		}	
	}		
}