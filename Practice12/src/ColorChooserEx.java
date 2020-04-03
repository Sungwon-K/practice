

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class ColorChooserEx extends JFrame{
	private MyPanel panel = new MyPanel();
	
	public int in = 0;


	public ColorChooserEx() {
		panel.color.add(Color.black);
		this.setTitle("ColorChooser");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		
		
		c.add(panel, BorderLayout.CENTER);
		
		createMenu();
		this.setSize(250, 200);
		this.setVisible(true);
		
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("Text");
		
		colorMenuItem.addActionListener(new MenuActionListener());
		
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color")) {
				Color selectedColor = JColorChooser.showDialog(null, "Color", Color.YELLOW);
			
			
				if(selectedColor != null) {
				
					panel.colorFlag = selectedColor;
					//panel.setForeground(selectedColor);
				}
				if(selectedColor == null) {
								
					panel.colorFlag = Color.BLACK;
				}
				
			}
		}		
	}
	public static void main(String[] args) {
		new ColorChooserEx();
		
		

	}

}
