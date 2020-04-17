import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Haksa extends JFrame {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	
	
	JPanel panel;

	public Haksa() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myOracle", "ora_user", "hong");
			stmt = conn.createStatement();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// 윈도우 종료시 connection close
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar bar = new JMenuBar();

		JMenu m_student = new JMenu("학생관리");// File메뉴
		bar.add(m_student);
		JMenu m_book = new JMenu("도서관리");// Edit메뉴
		bar.add(m_book);

		JMenuItem mi_list = new JMenuItem("학생정보");
		m_student.add(mi_list);

		JMenuItem mi_bookRent = new JMenuItem("대출목록");
		m_book.add(mi_bookRent);
		
		JMenuItem mi_bookPi = new JMenuItem("도서대출횟수");
		m_book.add(mi_bookPi);

		mi_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든컴포넌트 삭제
				panel.revalidate(); // 다시 활성화
				panel.repaint(); // 다시 그리기
				panel.add(new Student()); //화면 생성.
				panel.setLayout(null);// 레이아웃적용안함

			}
		});
		mi_bookRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든컴포넌트 삭제
				panel.revalidate(); // 다시 활성화
				panel.repaint(); // 다시 그리기
				panel.add(new BookRent()); //화면 생성.
				panel.setLayout(null);// 레이아웃적용안함

			}
		});
		mi_bookPi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll(); // 모든컴포넌트 삭제
				panel.revalidate(); // 다시 활성화
				panel.repaint(); // 다시 그리기
				panel.add(new BookPi()); //화면 생성.
				panel.setLayout(null);// 레이아웃적용안함
				
			}
		});

		panel = new JPanel();
		this.add(panel);

		this.setJMenuBar(bar);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Haksa();
	}

}
