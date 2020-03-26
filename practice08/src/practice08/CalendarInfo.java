package practice08;

import java.util.Calendar;

public class CalendarInfo {
	String s= new String();
	
	public CalendarInfo() {
		Calendar now = Calendar.getInstance();
		String year = Integer.toString(now.get(Calendar.YEAR));
		String month = Integer.toString(now.get(Calendar.MONTH)+1);
		String date = Integer.toString(now.get(Calendar.DAY_OF_MONTH));
		String hour = Integer.toString(now.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(now.get(Calendar.MINUTE));
		String sec = Integer.toString(now.get(Calendar.SECOND));
		
		year.concat(month);
		year.concat(date);
		year.concat(hour);
		year.concat(min);
		year.concat(sec);
		
		this.s = year.concat(month.concat(date).concat(hour).concat(min.concat(sec)));
	}
	
	public void showInfo() {
		System.out.println(this.s);
	}


}
