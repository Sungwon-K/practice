package practice06;

public class WheelMouse implements interWheelMouse{

	@Override
	public void Mouse()
	{
		System.out.println("wheel Mouse");
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
	public void scrollWheel() {
		System.out.println("scrollwheel");
		
	}

	@Override
	public void optical() {
		System.out.println("standard optical");
		
	}

	@Override
	public void wheelclick() {
		System.out.println("wheelclick");
		
	}

}
