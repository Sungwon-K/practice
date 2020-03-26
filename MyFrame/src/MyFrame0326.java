import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame0326 extends JFrame {
	public MyFrame0326() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = this.getContentPane();
		
		/*
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT,100,40));
		
		contentPane.add(new JButton("Ok"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		
		*/
		
		contentPane.setLayout(new BorderLayout(30,20));
		contentPane.add(new JButton("Caluculate"),BorderLayout.CENTER);
		contentPane.add(new JButton("add"),BorderLayout.NORTH);
		contentPane.add(new JButton("sub"),BorderLayout.SOUTH);
		contentPane.add(new JButton("mul"),BorderLayout.EAST);
		contentPane.add(new JButton("div"),BorderLayout.WEST);
		
		
		this.setSize(300, 300);
		/*this.setResizable(false);*/
		this.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new MyFrame0326();
	}
	
	
}
