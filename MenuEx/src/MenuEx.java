import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuEx extends JFrame{
	
	public MenuEx() {
		this.setTitle("Menu 만들기 예제");
		createMenu();
		this.setSize(250,200);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("screen");
		
		screenMenu.add(new JMenuTime("Load"));
		screenMenu.add(new JMenuTime("Hide"));
		screenMenu.add(new JMenuTime("ReShow"));
		screenMenu.addSeparator();
		screenMenu.add(new JMenuTime("Exit"));
		
		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Edit"));
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
