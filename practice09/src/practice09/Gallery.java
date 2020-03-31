package practice09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Gallery extends JFrame {
	
	private JRadioButton[] radio = new JRadioButton [3];
	private JLabel imageLabel = new JLabel();
	private String[] text = {"사과","배","체리"};
	private ImageIcon[] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
	};
	public int index =0;
	
	public Gallery(){
		this.setTitle("Gallelry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();
		
		for(int i = 0 ;i <radio.length;i++) {
			index = i;
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		imageLabel.setIcon(image[index]);
		c.addKeyListener(new MyKeyListener());
		
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		radio[2].setSelected(true);
		this.setSize(250, 200);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyItemListener implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return;
			
			
			
		}
		
				
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			
			switch(keyCode) {
			
			case KeyEvent.VK_LEFT:
				index--;
				break;
			case KeyEvent.VK_RIGHT:
				index++;
				break;
			}
			imageLabel.setIcon(image[index]);
			
		}
	}
	
}
