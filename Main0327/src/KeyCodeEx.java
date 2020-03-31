import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCodeEx extends JFrame {
	
	private JLabel la = new JLabel();
	
	public KeyCodeEx() {
		this.setTitle("Key Code 예제 : F1키:초록색, %키 노란색");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.addKeyListener(new MyKeyListener());
		
		c.add(la);
		
		this.setSize(300,150);
		this.setVisible(true);
		
		//contentpane이 키 입력을 받을 수 있도록 포커스 강제 지정
		c.setFocusable(true);
		c.requestFocus();
	}
	
	
	//Key리스너 구현
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			
			Container contentPane = (Container)e.getSource();
			
			//la에 입력된 키의 키 이름 문자열을 출력하여 사용자에게 보고함
			la.setText(e.getKeyText(e.getKeyCode()));
			
			if(e.getKeyChar() == '%') {	//입력된 키가 %인 경우
				contentPane.setBackground(Color.YELLOW);
			}
			else if(e.getKeyCode() == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
				
		}
	}
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}

}
