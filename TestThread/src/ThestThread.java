

class TimerThread extends Thread{
	int n= 0;
	
	public void run() {
		super.run();
		
		while(true) {
			System.out.println("t1 : " + n);
			
			n++;
			
			try {
				sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
	}
}

class TimerThread2 implements Runnable{
	int n = 0;
	
	@Override
	public void run() {
		while(true) {
			System.out.println("t2 : " + n);
			
			n++;
			
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}			
		}		
	}	
}

public class ThestThread {

	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		th.start();
		
		Thread t = new Thread(new TimerThread2());
		t.start();

	}

}
