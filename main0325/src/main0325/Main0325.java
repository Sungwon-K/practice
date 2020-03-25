package main0325;

import java.io.FileReader;
import java.io.IOException;

public class Main0325 {

	public static void main(String[] args) {
		/*
		StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐","/");
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		Calendar now = Calendar.getInstance();
		System.out.println(now);
		System.out.println(now.get(Calendar.YEAR));
		System.out.println(now.get(Calendar.MONTH)+1);
		System.out.println(Calendar.DAY_OF_MONTH);
		System.out.println(Calendar.HOUR);
		System.out.println(Calendar.MINUTE);
		System.out.println(Calendar.SECOND);
		System.out.println(Calendar.MILLISECOND);
		System.out.println(Calendar.DAY_OF_WEEK);
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		
		if(dayOfWeek==1)
			System.out.println("일요일");
		else if(dayOfWeek==2)
			System.out.println("월요일");
		else if(dayOfWeek==3)
			System.out.println("화요일");
		else if(dayOfWeek==4)
			System.out.println("수요일");
		else if(dayOfWeek==5)
			System.out.println("목요일");
		else if(dayOfWeek==6)
			System.out.println("금요일");
		else if(dayOfWeek==7)
			System.out.println("토요일");
		
		
		//문자열만 삽입 가능한 ArrayList 생성
		ArrayList<String> a = new ArrayList<String>();
		
		//키보드로부터 4개 이름 입력받아 ArrayList에 저장
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i<4;i++) {
			System.out.print("이름을 입력하시오 : ");
			String s = scanner.next();
			a.add(s);
		}
		
		//ArrayList에 있는 모든 이름 출력
		for(int i =0;i<a.size();i++) {
			String name = a.get(i);
			System.out.println(name + " ");
		}
		
		//가장 긴 이름 출력
		int longestIndex = 0;
		
		for(int i =0;i<a.size();i++) {
			if(a.get(longestIndex).length() < a.get(i).length())
				longestIndex = i;
		}
		System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));
		scanner.close();
		
		
		//HashMap활용
		//이름과 정수 저장할 HashMap컬렉션 생성
		HashMap<String, Integer> scoreMap = new HashMap<>();
		
		//5개의 점수 저장
		scoreMap.put("KimS",97);
		scoreMap.put("HangK",88);
		scoreMap.put("KimN",98);
		scoreMap.put("LeeJ",70);
		scoreMap.put("HanW",99);
		
		System.out.println("HashMap의 요소 개수 : "+ scoreMap.size());
		
		//모든 사람의 점수 출력
		
		Set<String> keys = scoreMap.keySet();
		Iterator<String> it = keys.iterator();
		
		
		Iterator<String> it = scoreMap.keySet().iterator(); //chaining
		
		while(it.hasNext()) {
			String name = it.next();
			int score = scoreMap.get(name);
			System.out.println(name + " " + score);
			
		}
		
				
		FileReader fin = null;
		try {
			fin = new FileReader("c:\\windows\\system.ini");
			int c;
			while((c=fin.read()) != -1){
				System.out.print((char)c);
			}
			fin.close();
		}
		catch(IOException e) {
			System.out.println("입출력 오류");
		}
		*/

	}
}
