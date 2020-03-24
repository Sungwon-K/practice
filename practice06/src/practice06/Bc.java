package practice06;

public class Bc {
	String cd = new String();
	
	public Bc(String cd)
	{
		this.cd=cd.substring(0, 2);
	}
	
	public void showinfo()
	{
		if(cd.equals("EL"))
			System.out.println("전자공학과");
		else if(cd.equals("CH"))
			System.out.println("화학공학과");
		else if(cd.equals("EN"))
			System.out.println("영어영문학과");
	}
}
