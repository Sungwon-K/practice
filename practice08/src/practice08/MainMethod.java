package practice08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		
		//1.Exception이 발생하면, 에러메시지를 로그(년월시분초.log)파일에 기록
		CalendarInfo cal = new CalendarInfo();
		Scanner scan = new Scanner(System.in);
		
		
		FileWriter errorMassage = null;
	
		
		try {
			System.out.println("입력하시오.");
			int c = scan.nextInt();
			System.out.println("결과값은 "+ c);
		} 
		catch(Exception e){ 
			
			try {
				
			
				errorMassage = new FileWriter("c:\\log\\"+cal.s +".log");
				errorMassage.write(e.toString());
				errorMassage.close();
				
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		
		}
		
		//2.예제9-5 화면을 FlowLayout을 상둉하여 작성
		
		new GridLayoutEx();
		
		
		
		//scan.close();
	}


}
