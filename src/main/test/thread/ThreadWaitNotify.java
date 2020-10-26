package thread;

public class ThreadWaitNotify {
	
	private void producer()throws InterruptedException{
		
		synchronized (this) {
			System.out.println("Starting producer...");
				wait();
			System.out.println("Producer ended");
		}
		
	}
	
	
	private void consumer() throws InterruptedException{
		
		synchronized (this) {
			Thread.sleep(2000);
			System.out.println("Starting consumer...");
			
			notify();
			
			System.out.println("Consumer ended");
			Thread.sleep(5000);
		}
	}
	
	private static class App {
		
		public static void main(String args[]) throws InterruptedException{
			
			final ThreadWaitNotify obj = new ThreadWaitNotify();
			
			Thread t1 = new Thread(new Runnable(){
				public void run(){
					try {
						obj.producer();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			Thread t2 = new Thread(new Runnable(){
				public void run(){
					try {
						obj.consumer();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
		}
		
		

	}

}





