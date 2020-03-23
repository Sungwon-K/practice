package practice05;

public class mainMethod {

	public static void main(String[] args) {
		Mouse m = new Mouse();
		
		m.Mouse();
		m.leftClick();
		m.rightClick();
		m.mouseMove();
		System.out.println();
		
		WheelMouse wm = new WheelMouse() ;
		
		wm.Mouse();
		wm.leftClick();
		wm.rightClick();
		wm.mouseMove();
		wm.scrollWheel();
		wm.wheelclick();
		wm.optical();
		
		System.out.println();
		
		LaserMouse lm = new LaserMouse();
		
		lm.Mouse();
		lm.leftClick();
		lm.rightClick();
		lm.mouseMove();
		lm.scrollWheel();
		lm.wheelclick();
		lm.optical();

	}

}
