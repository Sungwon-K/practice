import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	private JTextField tf = new JTextField();
	private JPasswordField pw = new JPasswordField();
	private JButton loginButton = new JButton("login");
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title,true );
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(pw);
		this.add(loginButton);
		this.setSize(120, 100);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 처리.DB연동.ID, PW일치 여부 확인
				System.out.println("로그인처리...");
			}
		});
		
		
		
	}
}

public class DialogEx extends JFrame {
	
	private MyDialog dialog;
	
	public DialogEx() {
		super("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("로그인");
		
		dialog = new MyDialog(this,"");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}});
		
		this.getContentPane().add(btn);
		
		this.setSize(250, 200);
		this.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new DialogEx();

	}

}
