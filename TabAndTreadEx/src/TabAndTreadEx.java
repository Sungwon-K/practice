import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

class MyLabel extends JLabel{
	int barSize = 0;
	int maxBarSize;
	
	MyLabel(int maxBarSize){
		this.maxBarSize = maxBarSize;
	}
	
	public void PaintCompnent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.magenta);
		
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width == 0)
	}
}
public class TabAndTreadEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
