package practice09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




	
public class MainMethod extends JFrame implements ActionListener{
	JLabel timeinfo;
	public JLabel ti = new JLabel();
	public int index =1;
	
	public MainMethod() {
		timeinfo = new JLabel();
		MyActionListener1 lis = new MyActionListener1(this);
		
		this.setTitle("시간 출력");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//1.화면에 현재 시간을 출력하는 Label 제작
		//각 버튼 클릭하면 중앙 Label에 시간 출력
		
		Container selBox = getContentPane();
		Container c  = getContentPane();
		
		JPanel selPanel = new JPanel();
				 
		JButton btn1 = new JButton("버튼1");
		btn1.addActionListener(lis);
		selBox.add(btn1);
	
		
		JButton btn2 = new JButton("버튼2");
		btn2.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton c= (JButton)e.getSource();
				if(c.getText().equals("버튼2")) {
					timeinfo.setText(new TimeInfo().s);
					index = 1;
				}
				
			}

		});
		selBox.add(btn2);
		
		
		JButton btn3 = new JButton("버튼3");
		btn3.addActionListener(new MyActionListener3());
		selBox.add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		btn4.addActionListener(this);
		selBox.add(btn4);
		
		
		
		
		
		
		selPanel.add(btn1);
		selPanel.add(btn2);
		selPanel.add(btn3);
		selPanel.add(btn4);
				
		
		//2.현재 시간 구해서 인사 Label로 표기하기
		TimeInfo time = new TimeInfo();		
		
		c.setLayout(new BorderLayout());
		
		if(time.t < 12)
			ti = new JLabel("Good Morning");
		else if(time.t >= 12 && time.t <18)
			ti = new JLabel("Good Afternoon");
		else if(time.t >= 18)
			ti = new JLabel("Good Evening");
		else
			ti = new JLabel("Error");
		

		
		
		timeinfo.setText("정보 없음");	
		
		
		c.add(timeinfo, BorderLayout.NORTH);
		c.add(ti,BorderLayout.CENTER);
		c.add(selPanel,BorderLayout.SOUTH);
		ti.setHorizontalAlignment(SwingConstants.CENTER);
		timeinfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		this.setSize(350,200);
		this.setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	
	class MyActionListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
						
				timeinfo.setText(new TimeInfo().s);
				index =1;
					
		}
		
	}
		
	
	public static void main(String[] args) {
		new MainMethod();
		//잘못 이해해서 만든 코딩-키보드 방향키로 이미지 전환(미완성)
		new Gallery();
		new Gallery2();
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		TimeInfo time4 = new TimeInfo();
		JButton c= (JButton)e.getSource();
		if(c.getText().equals("버튼4")) {
			timeinfo.setText(time4.s);
			index =1;
		}
		
	}

}
