package practice11;

import java.util.Calendar;

public class TimeInfo {
	private String slash = new String(" : ");
	public String s = new String();
	public int t =0;
	
	public TimeInfo() {
		Calendar now = Calendar.getInstance();
		
		int t = now.get(Calendar.HOUR_OF_DAY);
		
		this.t = t;
		
				
		String hour = Integer.toString(now.get(Calendar.HOUR_OF_DAY));
		String min = Integer.toString(now.get(Calendar.MINUTE));
		String sec = Integer.toString(now.get(Calendar.SECOND));
		
		this.s = hour.concat(slash.concat(min.concat(slash.concat(sec))));
		
	}
}