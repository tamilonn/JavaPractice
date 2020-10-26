package thread;

public class BasicThread extends Thread{


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
		
		BasicThread t1 = new BasicThread();
		t1.start();
		
		BasicThread t2 = new BasicThread();
		t2.start();
	}

}
