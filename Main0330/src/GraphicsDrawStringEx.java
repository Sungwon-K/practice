import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawStringEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public GraphicsDrawStringEx() {
		this.setTitle("drawString 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		this.setSize(300, 500);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			g.drawString("자바는 재밌다.~~~", 30, 30);
			g.drawString("얼마나? 하늘만큼 땅만큼", 60, 60);
			
			g.setColor(Color.RED);
			g.drawLine(20, 20, 100, 100);
			
			g.setColor(Color.RED);
			g.drawArc(120, 200, 80, 80, 90, 270);
			
			g.setColor(Color.RED);
			int [] x = {80,40,80,120};
			int [] y = {140,220,300,220};
			g.drawPolygon(x, y, 4);
			
			
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawStringEx();

	}

}
