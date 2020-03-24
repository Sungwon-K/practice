package practice06;

interface intermouse {
	void Mouse();
	void leftClick();	
	void rightClick();	
	void mouseMove();
}

interface interWheelMouse extends intermouse{
	void Mouse()	;
	void scrollWheel();	
	void optical();	
	void wheelclick();
}

interface interLaserMouse extends interWheelMouse{
	void Mouse();	
	void optical();	
}
