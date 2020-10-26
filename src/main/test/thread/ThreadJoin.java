package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadJoin{

	private AtomicInteger counter = new AtomicInteger(0);
	


	public static void main(String[] args) {
		
		ThreadJoin t = new ThreadJoin();
		t.doWork();
	}



	private void doWork() {
		
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0; i<10000; i++){
					counter.incrementAndGet();
				}		
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=0; i<10000; i++){
					counter.incrementAndGet();
				}		
				
			}
			
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Counter = " + counter);
		
	}

}