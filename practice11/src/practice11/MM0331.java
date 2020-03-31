package practice11;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerRunnable implements Runnable{
	private JLabel timerLabel;
	
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	@Override
	public void run() {
		
		while(true) {
			TimeInfo time = new TimeInfo();
			timerLabel.setText(time.s);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
		
	}
}

public class MM0331 extends JFrame{
	public MM0331() {
		this.setTitle("Runnable을 구현한 타이머 스레드 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		
		c.add(timerLabel);
		
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		
		Thread th = new Thread(runnable);
		
		this.setSize(550,200);
		this.setVisible(true);
		th.start();
		
		
	}



	public static void main(String[] args) {
		new MM0331();

	}


	
}
