package practice;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Member[] person = new Member[2];
		
			
		person[0]= new Member("홍길동","산속 어딘가","도적",18); 
		person[1]= new Member("이순신","바다 어딘가","장군",35);
		
		
		for(int i = 0; i<person.length;i++)
			person[i].showInfo();
		
		System.out.println("입력할 인원 수를 입력하세요. :");
		
		int num = scan.nextInt();
		Member[] persons = new Member[num];
		System.out.println(num +"명을 입력합니다.");
		
		for(int i=0;i<num;i++)
			persons[i] = new Member();
		
		for(int i=0;i<num;i++)
		{
			System.out.println((i+1)+"번째 분의 성함,주소,직업,나이를 입력해주십시오.");
			persons[i].name = scan.next();
			persons[i].address = scan.next();
			persons[i].job = scan.next();
			persons[i].age = scan.nextInt();
		}
		
		for(int i = 0;i<num;i++)
			persons[i].showInfo();
			
			
		scan.close();
		

	}

}
