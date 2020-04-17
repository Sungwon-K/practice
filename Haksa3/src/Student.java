import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel {
	JTextField tfId = null;
	JTextField tfName = null;
	JTextField tfDepartment = null;
	JTextField tfAddress = null;
	JTextArea taList = null;

	JButton btnList = null;
	JButton btnInsert = null;
	JButton btnUpdate = null;
	JButton btnDelete = null;
	JButton btnSearch = null;

	DefaultTableModel model;
	JTable table;

	public static String comStringbox = new String();

	public Student() {

		this.setLayout(new FlowLayout());

		this.add(new JLabel("학번"));
		this.tfId = new JTextField(14);
		this.add(tfId);

		this.btnSearch = new JButton("검색");
		this.add(this.btnSearch);

		this.add(new JLabel("이름"));
		this.tfName = new JTextField(20);
		this.add(tfName);

		this.add(new JLabel("학과"));
		this.tfDepartment = new JTextField(20);
		this.add(tfDepartment);

		this.add(new JLabel("주소"));
		this.tfAddress = new JTextField(20);
		this.add(tfAddress);

		String colName[] = { "학번", "이름", "학과", "주소" };
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(275, 200));
		add(table);
		add(new JScrollPane(table));

		// table에서 한행을 선택하면 편집할 수 있도록 TextField에 출력
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable) e.getComponent();// 클릭한 테이블 구하기
				model = (DefaultTableModel) table.getModel();// 테이블의 모델 구하기
				String id = (String) model.getValueAt(table.getSelectedRow(), 0);
				tfId.setText(id);
				String name = (String) model.getValueAt(table.getSelectedRow(), 1);
				tfName.setText(name);
				String dept = (String) model.getValueAt(table.getSelectedRow(), 2);
				tfDepartment.setText(dept);
				String address = (String) model.getValueAt(table.getSelectedRow(), 3);
				tfAddress.setText(address);

				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnList = new JButton("목록");
		btnInsert = new JButton("등록");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("삭제");

		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {

				try {

					Haksa.rs = Haksa.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

					model.setNumRows(0);

					if (Haksa.rs.next()) {
						tfName.setText(Haksa.rs.getString("name"));
						tfDepartment.setText(Haksa.rs.getString("dept"));
						tfAddress.setText(Haksa.rs.getString("address"));

						String[] row = new String[4];// 컬럼의 갯수가 3
						row[0] = Haksa.rs.getString("id");
						row[1] = Haksa.rs.getString("name");
						row[2] = Haksa.rs.getString("dept");
						row[3] = Haksa.rs.getString("address");
						model.addRow(row);

					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {

						if (Haksa.rs != null)
							Haksa.rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});

		this.btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				try {

					if ((tfId.getText()).equals("")) {
						JOptionPane.showMessageDialog(null, "학번을 입력하세요!", "알림", JOptionPane.INFORMATION_MESSAGE);
						return; // 함수종료
					}

					Haksa.stmt.executeUpdate(
							"update student set name='" + tfName.getText() + "', dept ='" + tfDepartment.getText()
									+ "', address ='" + tfAddress.getText() + "' where id = '" + tfId.getText() + "'");

					Haksa.rs = Haksa.stmt.executeQuery("select * from student where id = '" + tfId.getText() + "'");

					model.setNumRows(0);

					while (Haksa.rs.next()) {
						String[] row = new String[4];// 컬럼의 갯수가 3
						row[0] = Haksa.rs.getString("id");
						row[1] = Haksa.rs.getString("name");
						row[2] = Haksa.rs.getString("dept");
						row[3] = Haksa.rs.getString("address");
						model.addRow(row);

					}

					Haksa.rs.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "수정되었습니다.");

			}
		});

		this.btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {

				if ((tfId.getText()).equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요!", "알림", JOptionPane.INFORMATION_MESSAGE);
					return; // 함수종료
				}

				if (tfName.getText().equals("")) {
					tfName.setText(JOptionPane.showInputDialog("이름을 입력받지 못했습니다. 이름을 입력하세요"));

					if (tfName.getText().length() == 0)
						tfName.setText("없음");
				}

				if (tfDepartment.getText().equals("")) {
					tfDepartment.setText(JOptionPane.showInputDialog("학과를 입력받지 못했습니다. 학과를 입력하세요"));

					if (tfDepartment.getText().length() == 0)
						tfDepartment.setText("없음");
				}

				if (tfAddress.getText().equals("")) {
					tfAddress.setText(JOptionPane.showInputDialog("주소를 입력받지 못했습니다. 주소를 입력하세요"));

					if (tfAddress.getText().length() == 0)
						tfAddress.setText("없음");
				}

				try {

					Haksa.stmt.executeUpdate("insert into student values('" + tfId.getText() + "','" + tfName.getText()
							+ "','" + tfDepartment.getText() + "','" + tfAddress.getText() + "')");

					list();

					JOptionPane.showMessageDialog(null, "입력받은 정보 ID :" + tfId.getText() + " 이름 : " + tfName.getText()
							+ " 학과 : " + tfDepartment.getText() + " 주소 : " + tfAddress.getText() + "가 등록 되었습니다.");

				} catch (Exception e) {
					e.printStackTrace();
				}

				// taList.append(tfId.getText()+"\t"+tfName.getText()+"\t"+tfDepartment.getText()
				// + "\t" +tfAddress.getText());
				//
				// text박스 클리어링
				tfId.setText("");
				tfName.setText("");
				tfDepartment.setText("");
				tfAddress.setText("");
			}
		});

		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					// 삭제처리. DB연동해서 삭제

					try {
						Haksa.stmt.executeUpdate("delete from student where id = '" + tfId.getText() + "'");

						list();

					} catch (Exception e) {
						e.printStackTrace();
					}

					tfId.setText("");
					tfName.setText("");
					tfDepartment.setText("");
					tfAddress.setText("");

					JOptionPane.showMessageDialog(null, "삭제되었습니다");
				}

			}
		});

		this.btnList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg) {

				list();

			}
		});

		this.add(this.btnList);
		this.add(this.btnInsert);
		this.add(this.btnUpdate);
		this.add(this.btnDelete);
		this.setSize(280, 500);
		this.setVisible(true);
	}

	public void list() {
		try {

			// Select문 실행
			ResultSet rs = Haksa.stmt.executeQuery("select * from student order by Id");

			// JTable 초기화
			model.setNumRows(0);

			while (rs.next()) {
				String[] row = new String[4];// 컬럼의 갯수가 3
				row[0] = rs.getString("id");
				row[1] = rs.getString("name");
				row[2] = rs.getString("dept");
				row[3] = rs.getString("address");
				model.addRow(row);
			}
			rs.close();

		} catch (Exception e1) {
			// e.getStackTrace();
			System.out.println(e1.getMessage());
		}
	}

}
