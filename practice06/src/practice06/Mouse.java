package practice06;


public class Mouse implements intermouse {

	@Override
	public void Mouse() {
		System.out.println("standard Mouse");
		
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

}
