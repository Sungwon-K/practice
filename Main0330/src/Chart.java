import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chart extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel{

		int vGap = 10;
		int height = 20;
		int startX =100;
		int startY =100;
		private ImageIcon icon = new ImageIcon("images/image0.jpg");
		private Image img = icon.getImage();
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			
			
				
			g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
			
			g.drawString("분기별 매출 현황",startX,startY-50);
			
			g.setColor(Color.CYAN);
			g.drawString("1/4분기", startX-70,startY+height-5);
			g.fillRect(startX, startY, 50, height);
			
			g.setColor(Color.BLUE);
			g.drawString("2/4분기", startX-70,startY+height-5+vGap+height);
			g.fillRect(startX, startY+height+vGap, 70, height);
			
			g.setColor(Color.BLACK);
			g.drawString("3/4분기", startX-70,startY+height-5+(vGap+height)*2);
			g.fillRect(startX, startY+(height+vGap)*2, 100, height);
			g.setColor(Color.BLUE);
			g.drawString("4/4분기", startX-70,startY+height-5+(vGap+height)*3);
			g.fillRect(startX, startY+(height+vGap)*3, 150, height);

			g.drawLine(50, 350, 100, 300);
			g.drawLine(100, 300, 150, 280);
			g.drawLine(150, 280, 200, 290);
			g.drawLine(200, 290, 250, 250);
			
			g.setColor(Color.RED);
			g.fillArc(50, 400, 100, 100, 0, 45);
			g.setColor(Color.GREEN);
			g.fillArc(50, 400, 100, 100, 45, 135);
			g.setColor(Color.BLUE);
			g.fillArc(50, 400, 100, 100, 180, 90);
			g.setColor(Color.BLACK);
			g.fillArc(50, 400, 100, 100, 270, 90);
		
		
		
		}
		
		
	}
	public Chart() {
		this.setTitle("차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		
		
		this.setSize(500, 700);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chart();

	}

}
