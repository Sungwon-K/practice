package main0324;



interface PhoneInterface{
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printLogo()
	{
		System.out.println("*Phone*");
	}
}
interface MobilePhoneInterface extends PhoneInterface{
	void sendSMS();
	void receiveSMS();
}

interface MP3Interface{
	public void play();
	public void stop();
}

class PDA{
	public int calculate(int x,int y) {
		return x+ y;
	}
}



public class main0324 {

	public static void main(String[] args) {
		
		/*
		SamsungPhone phone = new SamsungPhone();
		phone.printLogo();
		phone.sendCall();
		phone.receiveCall();
		phone.flash();
		*/
		
		/*
		SmartPhone phone = new SmartPhone();
		phone.printLogo();
		phone.sendCall();
		phone.play();
		System.out.println("3과 5를 더하면 "+phone.calculate(3, 5));
		phone.schedule();
		*/
		
		//equals()활용
		/*
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = new Point(3,4);
		
		if(a==b)
			System.out.println("a==b");
		if(a.equals(b))
			System.out.println("a is equal to b");
		if(a.equals(c))
			System.out.println("a is equal to c");
		*/
		
		//boxing,언boxing활용
		/*
		int n =10;
		System.out.println("n = "+n);
		Integer intObject = n;
		System.out.println("intObject = "+intObject);
		int m = intObject + 10;
		System.out.println("m = "+m);
		*/
		
		//String클래스 메소드 활용
		/*
		String s1 = "Hello World";
		
		
		System.out.println(s1 + "의 길이는 " +s1.length());
		
		String s2 = "010-1111-2222";
		System.out.println(s2.replace("-","."));
		System.out.println(s2);
		s2 = s2.replace("-",".");
		System.out.println(s2);
		
		// CSV(Comma Seperated Value) 콤마로 이루어진 표기
		String data = "이순신,010-1111-2222,컴퓨터공학과";
		String[] dataArray = data.split(",");
		for(int i =0;i<dataArray.length;i++)
			System.out.println(dataArray[i]);
		
		String fileName = "HelloWorld.java";
		System.out.println(fileName.substring(5));
		System.out.println(fileName.substring(5, 6));
		System.out.println(fileName.substring(11));
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.substring(fileName.indexOf(".")+1));
		
		String fileName2="login.html";
		System.out.println(fileName2.substring(fileName2.indexOf(".")+1));
		
		String fileName3="a.b.c.mp3";
		System.out.println(fileName3.substring(fileName3.indexOf(".")+1));
		System.out.println(fileName3.substring(fileName3.lastIndexOf(".")+1));
		*/
		
		
		
		
		
	}

}
