package com.test.thread;

import java.util.concurrent.TimeUnit;

public class StopThreadNotWorking {
	private static boolean stopRequested;
	
	public static void main(String[] args)
		throws InterruptedException {
			
		Thread backgroundThread = new Thread(new Runnable() {
		public void run() {
			int i = 0;
			System.out.println(stopRequested);
			while (!stopRequested){
				i++;
				System.out.println(i);
			}
				
		}
	});
		
	backgroundThread.start();
	TimeUnit.SECONDS.sleep(5);
	stopRequested = true;
	System.out.println(stopRequested);
	}
}
