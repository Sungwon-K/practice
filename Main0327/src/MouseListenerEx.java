import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerEx extends JFrame{
	private JLabel la = new JLabel("æ∆ΩÓ∫¿∏ﬁ∑’");
	
	public MouseListenerEx() {
		this.setTitle("Mouse ¿Ã∫•∆Æ øπ¡¶");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c= getContentPane();
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null);
		la.setSize(75,20);
		la.setLocation(30, 30);
		c.add(la);
		
		this.setSize(250, 250);
		this.setVisible(true);
		
		}
	class MyMouseListener implements MouseListener {
		
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x,y);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		new MouseListenerEx();

	}

}
