package practice07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//1.책제목, 저자, 출판사, 가격을 키보드를 통해 1번의 데이터를 ArrayList에 저장하시오.
		ArrayList<String> book = new ArrayList<>();
		
		System.out.println("ArrayList - 책제목,저자,출판사,가격을 입력하세요");
		for(int i=0;i<4;i++)
		{
			String s = scan.next();
			book.add(s);
		}
		
		for(int i=0;i<book.size();i++)
		{
			String s = book.get(i);
			System.out.print(s + " ");
		}
		System.out.println();
		
		
		//2.1번을 HashMap을 이용해서 저장하고 출력하싱도.
		HashMap<String, String> hashBook = new HashMap<>();
		 
		System.out.println("HashMap - 책제목,저자,출판사,가격을 입력하세요");
		
		String key[] = {"책제목","저자","출판사","가격"};
		
		for(int i=0;i<4;i++) {
			String s = scan.next();
			hashBook.put(key[i],s);
		}
		
		
		Iterator<String> it = hashBook.keySet().iterator();
		for(int i =0; i<hashBook.size();i++)
		{
			String keys = it.next();
			String value = hashBook.get(keys);
			System.out.println(keys+"\t-" + value);
		}
		System.out.println();
		
		
		//3.1번을 Book Class를 만든 다음 Array List에 Book 객체를 넣어서 처리하기.
		System.out.println("Class in the ArrayList - 책제목,저자,출판사,가격을 입력하세요");
		
		Book2 book2 = new Book2();
		ArrayList<Book2> data = new ArrayList<Book2>();
		String k[] = new String[4];
		
		
		for(int i=0;i<4;i++)
		{
			k[i] = scan.next();
			
		}		
		data.add(new Book2(k[0], k[1], k[2], k[3]));
		
	
				
		for(int i=0;i<data.size();i++)
		{
			book2 = data.get(i);
			System.out.print(book2.getName() + " "+book2.getWrite() + " "+book2.getCompany() + " " + book2.getPrice());
		}
		System.out.println();
		
		
		//3-2.Book Class에 Array List를 넣어서 처리
		System.out.println("ArrayList in the Class - 책제목,저자,출판사,가격을 입력하세요");
		
		for(int i=0;i<4;i++)
		{
			String s = scan.next();
			Book arrayBook = new Book(s);
			arrayBook.ShowInfo();				
		}
		
			
		
		scan.close();
		

	}

}
