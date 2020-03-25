package practice07;

import java.util.ArrayList;

public class Book {
	ArrayList<String> arrayBook = new ArrayList<>();
	
	public Book(String s) {
		arrayBook.add(s);
	}
	
	public void ShowInfo() {
		for(int i=0;i<arrayBook.size();i++)
		{
			String s = arrayBook.get(i);
			System.out.print(s + " ");
		}
	}
	
}
