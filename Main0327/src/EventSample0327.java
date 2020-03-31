import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


//외부 클래스
class MyAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		//Action이벤트 발생 될때 처리할 작업
		//System.out.println("btn1이 클릭됨");
		JButton btn = (JButton) e.getSource();
		if(btn.getText().equals("버튼1"))
			System.out.println("btn1이 클릭됨");
		else if(btn.getText().equals("버튼2"))
			System.out.println("btn2가 클릭됨");
		else if(btn.getText().equals("버튼3"))
			System.out.println("btn3이 클릭됨");
		
	}
	
}

public class EventSample0327 extends JFrame implements ActionListener{
	public EventSample0327() {
		this.setTitle("Event");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container c= this.getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("버튼1");
		MyAction ma = new MyAction();
		c.add(btn1);
		btn1.addActionListener(ma);
		
		
		JButton btn2 = new JButton("버튼2");
		c.add(btn2);
		//btn2.addActionListener(new MyAction2());
		btn2.addActionListener(ma);
		
		
		
		 /*JButton btn3 = new JButton("버튼3"); c.add(btn3); 
		  * btn3.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("btn3이 클릭됨");
		 * 
		 * } });
		 */		
		
		JButton btn3 = new JButton("버튼3");
		c.add(btn3);
		btn3.addActionListener(ma);
		
		
		JButton btn4 = new JButton("버튼4");
		c.add(btn4);
		btn4.addActionListener(this);
		
		this.setSize(500,500);
		this.setVisible(true);
	
	}
	
	//내부(inner)클래스
			class MyAction2 implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("btn2이 클릭됨");
					
				}
				
			}
	

	public static void main(String[] args) {
		new EventSample0327();
		
		
	}
	
	//클래스 자신이 직접 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("btn4이 클릭됨");
		
	}

}
