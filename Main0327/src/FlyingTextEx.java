import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx extends JFrame{
	
	private final int FLYING_UINT = 10;
	ImageIcon baeuty = new ImageIcon("images/icon1.png");
	private JLabel la = new JLabel(baeuty);
	
	
	public FlyingTextEx() {
		this.setTitle("상,하,좌,우키를 이용하여 텍스트 움직이기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(null);
		c.addKeyListener(new MyKeyListener());
		la.setLocation(50, 50);
		la.setSize(150, 150);
		c.add(la);
		
		
		this.setSize(300, 300);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(), la.getY()- FLYING_UINT);
				int r1 = (int)(Math.random()*256);
				int g1 = (int)(Math.random()*256);
				int b1 = (int)(Math.random()*256);
				Component c1 = (Component)e.getSource();
				c1.setBackground(new Color(r1,b1,g1));
				break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(), la.getY()+ FLYING_UINT);
				int r2 = (int)(Math.random()*256);
				int g2 = (int)(Math.random()*256);
				int b2 = (int)(Math.random()*256);
				Component c2 = (Component)e.getSource();
				c2.setBackground(new Color(r2,b2,g2));
				break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()- FLYING_UINT, la.getY());
				int r3 = (int)(Math.random()*256);
				int g3 = (int)(Math.random()*256);
				int b3 = (int)(Math.random()*256);
				Component c3 = (Component)e.getSource();
				c3.setBackground(new Color(r3,b3,g3));
				break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+ FLYING_UINT, la.getY());
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,b,g));
				break;
			}
		}
	}



	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
