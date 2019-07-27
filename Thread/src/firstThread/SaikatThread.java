package firstThread;

public class SaikatThread {
	
	static int count = 0;
	
	public static void main(String[] args) {
			
		MyThread mt = new MyThread();
		mt.start();
		
		MyThread mt1 = new MyThread();
		mt1.start();
		 
		
		
		Thread t1 = new Thread (new Runnable() {

			
			public void run() {
				
				for(int i=0;i<1;i++){
					
					System.out.println(Thread.currentThread().getId()+" value "+i);
					count++;
					System.out.println("count -->"+count);
				}
			}
			
		});
		
		
		Thread t2 = new Thread (new Runnable() {

			
			public void run() {
				
				for(int i=0;i<1;i++){
					
					System.out.println(Thread.currentThread().getId()+" value "+i);
					count++;
				}
				System.out.println("count -->"+count);
			}
			
		});
		
		
		t1.start();
		t2.start();
		
		System.out.println("count is "+ count);
		
	}
	
	

}
