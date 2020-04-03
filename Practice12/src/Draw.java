import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

class MyPanel extends JPanel{
		private ArrayList<Point> aPoint = new ArrayList<>();
		public static ArrayList<Boolean> aPointFlag = new ArrayList<>();
		public static ArrayList<Color> color = new ArrayList<>();
		
		public static Color colorFlag;
		

		Point startP;
		Point endP;
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionListener(){

				@Override
				public void mouseDragged(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
					color.add(colorFlag);
					repaint();
					
				}

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				
			});
			
			addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
					color.add(colorFlag);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					aPointFlag.remove(aPointFlag.size()-1);	
					
					
					//마우스를 떼면 여기가 중단점이라는 것을 표기
					aPointFlag.add(true);
					
					repaint();//눌렀다 바로 띈 경우를 위해
					
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					
		
				}
				
			});
		}
		
	
	
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
	
			
			for(int i = 0; i<aPoint.size();i++) {
				//첫번째 점이거나 이전 점이 마지막 점이면
				if(i == 0 || aPointFlag.get(i-1)==true) {
					startP = aPoint.get(i);
				}
				
				//System.out.println(color.get(index));
			
														
				endP=aPoint.get(i);
				g.setColor(color.get(i));
				g.drawLine((int)startP.getX(), (int)startP.getY(), (int)endP.getX(), (int)endP.getY());
				startP = endP;
			}
				
				
		}
		
	}