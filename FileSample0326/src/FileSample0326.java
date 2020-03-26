import java.io.File;

public class FileSample0326 {

	public static void main(String[] args) {
		File f = new File("c:\\Temp");
		File[] list = f.listFiles();
		
		for(int i =0 ; i<list.length ; i++)
		{
			File f2 = list[i];
			System.out.println(f2.getName()+"\t"+ f2.length());
			long t = f2.lastModified();
			System.out.printf("\t수정한 시간 : %tb %td %ta %tT\n",t,t,t,t);
		}

	}

}
