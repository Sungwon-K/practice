package practice06;

public class LaserMouse implements interLaserMouse{
	
	@Override
	public void Mouse() {
		System.out.println("laser Mouse");
		
	}
	
	@Override
	public void scrollWheel() {
		System.out.println("scrollwheel");
		
	}

	@Override
	public void wheelclick() {
		System.out.println("wheelclick");
		
	}

	@Override
	public void leftClick() {
		System.out.println("leftClick");
		
	}

	@Override
	public void rightClick() {
		System.out.println("rightClick");
		
	}

	@Override
	public void mouseMove() {
		System.out.println("mouseMove");
		
	}

	

	@Override
	public void optical() {
		System.out.println("laser optical");
		
	}

}
