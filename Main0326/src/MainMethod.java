import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//FileWriter 사용
		
		/*
		FileWriter fout = null;
		int c;
		
		try {
			fout = new FileWriter("c:\\Java_Workspace\\test.txt");
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				fout.write(line, 0 , line.length());
				fout.write("\r\n",0,2);
			}
			fout.close();
		} catch(IOException e) {
			System.out.println("입출력오류");
		}
		*/
		
		/*
		//BufferedIOex 사용
		FileReader fin =null;			//파일 읽기값 초기화
		int c;
		try{
			fin = new FileReader("c:\\Java_Workspace\\test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,5);

			while ((c = fin.read()) !=-1 ){		//파일 데이터를 모두 스크린에 출력
				out.write(c);
			}
		

			//파일 데이터가 모두 출력된 상태
			new Scanner(System.in).nextLine();	//엔터키 입력
			out.flush();			//버퍼에 남아 있던 문자 모두 출력
			fin.close();
			out.close();

			} 
		catch(IOException e) {
				e.printStackTrace();
		}
		*/
		
		/*
		//FileInputStream,FileOutputStream을 이용한 파일 복사
		File src = new File("C:\\Windows\\Web\\Wallpaper\\Theme1\\photo-of-trees-in-forest-3801030.jpg");
		
		File dest = new File("c:\\Java_Workspace\\coping.jpg");
		
		int c;
		
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			
			while((c=fi.read())!= -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를" +dest.getPath()+"로 복사하였습니다.");
		}
		catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
		
		
		File dest2 = new File("c:\\Java_Workspace\\desert.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest2);
			
			byte[] buf = new byte[1024*10];	//10KB 버퍼
			
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0 , n);
				if(n < buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를" + dest2.getPath() + "로 복사하였습니다.");
		}
		catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
		*/
		
		
		
		scanner.close();
	}
}
