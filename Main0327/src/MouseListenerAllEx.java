import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerAllEx extends JFrame{

	private JLabel la = new JLabel("No Mouse Event");
	
	public MouseListenerAllEx() {
		this.setTitle("MouseListener¿Í MouseMotioneListener ¿¹Á¦");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
			
		c.add(la);
		
		
		
		this.setSize(300,200);
		this.setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("mouseDragged ("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("mouseMoved ("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()==2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,b,g));
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component c =(Component)e.getSource();
			c.setBackground(Color.CYAN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component c =(Component)e.getSource();
			c.setBackground(Color.YELLOW);
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed ("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("mouseRelaease ("+e.getX()+","+e.getY()+")");
			
		}
		
	}


	public static void main(String[] args) {
		new MouseListenerAllEx();
	}

}
