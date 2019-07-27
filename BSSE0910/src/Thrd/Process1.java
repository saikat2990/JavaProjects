package Thrd;

class Process1 extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++)Thd.a++;
		
		System.out.println("value is "+Thd.a);
		
	}
}
