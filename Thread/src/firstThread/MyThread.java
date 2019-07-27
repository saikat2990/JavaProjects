package firstThread;

public class MyThread extends Thread{
	
	public void run() {
		
		for(int i=0; i<1; i++) {
			System.out.println(Thread.currentThread().getId() + "  value   "+i);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}
