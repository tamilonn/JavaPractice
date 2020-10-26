package thread;

public class BasicThread2 implements Runnable{


	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Thread" + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new BasicThread2());
		t1.start();
		
		Thread t2 = new Thread(new BasicThread2());
		t2.start();
	}

}