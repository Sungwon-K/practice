package practice;

public class Member {
	String name,address,job;
	int age;
	
	//기본 생성자 선언
	public Member() {
	};
	
	//패러미터 모두를 사용하는 생성자 선언
	public Member(String name, String address, String job, int age )
	{
		this.name = name;
		this.address = address;
		this.job = job;
		this.age = age;
	}
	
	//입력값 출력
	public void showInfo()
	{
		System.out.println(this.name + "씨 " + this.address +" " + this.job +" " + this.age+"세 ");
	}

}
