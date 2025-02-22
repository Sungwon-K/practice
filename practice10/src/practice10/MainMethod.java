package practice10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMethod extends JFrame  implements ActionListener{
	
	private MyPanel panel = new MyPanel();
	public ArrayList<Integer> numlist = new ArrayList<>();
	JTextField tf1 = new JTextField(4);
	JTextField tf2 = new JTextField(4);
	JTextField tf3 = new JTextField(4);
	JTextField tf4 = new JTextField(4);
	

	public MainMethod() {
		
		
		for(int i =0;i<4;i++)
		{
			numlist.add(i,0);
		}
		
		
		this.setTitle("차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.panel);
		
		Container c = getContentPane();
		Container g = getContentPane();
		
		c.setLayout(new FlowLayout());
		g.setLayout(new FlowLayout());
		
		JLabel apple = new JLabel("apple");
		JLabel cherry = new JLabel("cherry");
		JLabel strawberry = new JLabel("strawberry");
		JLabel prune = new JLabel("prune");
			
		
		
	
		tf4.addActionListener(this);
		
		
		
		JPanel fruitinfo = new JPanel();
		
		g.add(apple);
		g.add(tf1);
		g.add(cherry);
		g.add(tf2);
		g.add(strawberry);
		g.add(tf3);
		g.add(prune);
		g.add(tf4);

		fruitinfo.add(apple);
		fruitinfo.add(tf1);
		fruitinfo.add(cherry);
		fruitinfo.add(tf2);
		fruitinfo.add(strawberry);
		fruitinfo.add(tf3);
		fruitinfo.add(prune);
		fruitinfo.add(tf4);
	
		
		
		c.add(fruitinfo,BorderLayout.SOUTH);
		
		this.setSize(500, 700);
		this.setVisible(true);
		
	}
	

	class MyPanel extends JPanel{
		
		int vGap = 10;
		int height = 20;
		int startX = 100;
		int startY = 100;
		int vGap2 = -5;
		int hGap2 = -14;
		
		
		
		
		private ImageIcon icon = new ImageIcon("images/photo-of-fern-leaves-3786208.jpg");
		private Image img = icon.getImage();
		
		
		@Override
		public void paintComponent(Graphics g) {
			
			
			super.paintComponent(g);
			

			//1.막대 그래프 완성하기
			g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
			
			g.setColor(new Color(223,255,168));
			g.drawString("분기별 매출 현황",startX,startY-50);
			
			g.setColor(new Color(156,255,134));
			g.drawString("1/4분기", startX-70,startY+height-5);
			g.fillRect(startX, startY, 50, height);
			g.drawString("50억", startX+50,startY+height-5);
			
			g.setColor(new Color(143,232,142));
			g.drawString("2/4분기", startX-70,startY+height-5+vGap+height);
			g.fillRect(startX, startY+height+vGap, 70, height);
			g.drawString("100억", startX+70,startY+height-5+vGap+height);
			
			g.setColor(new Color(200,255,168));
			g.drawString("3/4분기", startX-70,startY+height-5+(vGap+height)*2);
			g.fillRect(startX, startY+(height+vGap)*2, 100, height);
			g.drawString("150억", startX+100,startY+height-5+(vGap+height)*2);
			
			g.setColor(new Color(206,232,142));
			g.drawString("4/4분기", startX-70,startY+height-5+(vGap+height)*3);
			g.fillRect(startX, startY+(height+vGap)*3, 150, height);
			g.drawString("150억", startX+150,startY+height-5+(vGap+height)*3);

			
			
			//2.꺽은선 그래프 완성하기
			g.setColor(Color.WHITE);
			g.drawLine(50,360,50,230);
			g.drawLine(40,350,280,350);
			g.drawString("50억",100+hGap2,300+vGap2);
			g.drawString("90억",150+hGap2,280+vGap2);
			g.drawString("70억",200+hGap2,290-vGap2*3);
			g.drawString("150억",250+hGap2,250+vGap2);
			
			g.drawString("1/4",100+hGap2,360-vGap2);
			g.drawString("2/4",150+hGap2,360-vGap2);
			g.drawString("3/4",200+hGap2,360-vGap2);
			g.drawString("4/4",250+hGap2,360-vGap2);
			g.drawString("(분기)",300+hGap2,360-vGap2);
			g.drawString("(매출)",50+hGap2*3,230-vGap2*2);
			
			
			g.setColor(new Color(223,255,168));
			g.drawLine(50, 350, 100, 300);
			g.drawLine(100, 300, 150, 280);
			g.drawLine(150, 280, 200, 290);
			g.drawLine(200, 290, 250, 250);
			
			
			//3.P.681 11번 완성하기
						
			int sum = 0;
			
			for(int i = 0; i<numlist.size();i++) {
				sum += numlist.get(i);
			}
						
			int aPi = (int)(((float)numlist.get(0)/sum)*360);
			int bPi = (int)(((float)numlist.get(1)/sum)*360);
			int cPi = (int)(((float)numlist.get(2)/sum)*360);
			int dPi = (int)(((float)numlist.get(3)/sum)*360);
			
			
			g.setColor(new Color(122,122,79));
			g.fillArc(50, 400, 100, 100, 0, aPi);
			g.drawString("apple : "+String.valueOf((int)((float)aPi/360*100))+"%",50,550);
			
			g.setColor(new Color(255,255,89));
			g.fillArc(50, 400, 100, 100, aPi, bPi);
			g.drawString("cherry : "+String.valueOf((int)((float)bPi/360*100))+"%",50,570);
			
			g.setColor(new Color(143,143,114));
			g.fillArc(50, 400, 100, 100, aPi+bPi, cPi);
			g.drawString("strawberry : "+String.valueOf((int)((float)cPi/360*100))+"%",50,590);
			
			g.setColor(new Color(204,204,133));
			g.fillArc(50, 400, 100, 100, aPi+bPi+cPi, 360-(aPi+bPi+cPi));
			g.drawString("prune : "+String.valueOf((int)((float)dPi/360*100))+"%",50,610);
			
						
		}
	}
	
	
	

	public static void main(String[] args) {
		new MainMethod();

	}
	
	public void actionPerformed(ActionEvent e) {
		JTextField t = (JTextField)e.getSource();
		
		if(Integer.parseInt(this.tf1.getText()) == 0) {
			numlist.add(0,0);			
		}
		else {
			numlist.remove(0);
			numlist.add(0,Integer.parseInt(this.tf1.getText()));
		}
		
		if(Integer.parseInt(this.tf2.getText()) == 0) {
			numlist.add(1,0);			
		}
		else {
			numlist.remove(1);
			numlist.add(1,Integer.parseInt(this.tf2.getText()));
		}
		
		if(Integer.parseInt(this.tf3.getText()) == 0) {
			numlist.add(2,0);			
		}
		else {
			numlist.remove(2);
			numlist.add(2,Integer.parseInt(this.tf3.getText()));
		}
		
		if(Integer.parseInt(t.getText()) == 0) {
			numlist.add(3,0);
		}
		else {
			numlist.remove(3);
			numlist.add(3,Integer.parseInt(t.getText()));
		}
		
		repaint();
		
			
	}
		
}