import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BookPi extends JPanel {

	public ArrayList<Integer> numlist = new ArrayList<>();
	public ArrayList<Integer> pi = new ArrayList<>();

	String[] def_name = { "컴퓨터시스템", "멀티미디어", "컴퓨터공학" };

	String query;
	static int sum;


	public BookPi() {
		this.sum = 0;


		for (int i = 0; i < def_name.length; i++) {
			numlist.add(i, 0);
			pi.add(i,0);
		}

		query = "select count(s.id)" + " from student s, bookRent b" + " where b.id = s.id";

		try {
			for (int i = 0; i < def_name.length; i++) {
				query += " and s.dept='" + def_name[i] + "' order by s.id";

				Haksa.rs = Haksa.stmt.executeQuery(query);

				while (Haksa.rs.next()) {
					
					numlist.remove(i);
					if (Integer.parseInt(Haksa.rs.getString("count(s.id)")) == 0) {
						numlist.add(i, 0);
					}

					else {							
						numlist.add(i, Integer.parseInt(Haksa.rs.getString("count(s.id)")));
					}

					this.sum += Integer.parseInt(Haksa.rs.getString("count(s.id)"));
					
				}
				query = "select count(s.id)" + " from student s, bookRent b" + " where b.id = s.id";
						
			}			
			Haksa.rs.close();		
			
			for (int i = 0; i < numlist.size(); i++) {
				pi.remove(i);
				pi.add(i,(int)(((float)numlist.get(i)/this.sum) * 360));
			}
			
			

		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		

		this.setSize(490, 400);
		this.setVisible(true);

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(new Color(217,122,67));
		g.fillArc(200, 200, 150, 150, 0, pi.get(0));
		g.drawString("컴퓨터시스템 : " + pi.get(0) / (360 * 100) + "%", 50, 50);

		g.setColor(new Color(217, 201, 154));
		g.fillArc(200, 200, 150, 150, pi.get(0), pi.get(1));
		g.drawString("멀티미디어 : " + pi.get(1) /( 360 * 100) + "%",50, 100);

		g.setColor(new Color(133,140,77));
		g.fillArc(200, 200, 150, 150, pi.get(0) + pi.get(1), 360 - (pi.get(0) + pi.get(1)));
		g.drawString("컴퓨터공학 : " + pi.get(2) /( 360 * 100) + "%", 50, 150);

	}
}
