package com.test.thread;

import java.util.concurrent.TimeUnit;

public class StopThreadWorking {
	private static boolean stopRequested;
	
	public static void main(String[] args)
		throws InterruptedException {
			
		Thread backgroundThread = new Thread(new Runnable() {
		public void run() {
			int i = 0;
			while (!isStopped()){
				i++;
				System.out.println(i);
			}
				
		}
	});
		
	backgroundThread.start();
	TimeUnit.SECONDS.sleep(1);
	stopRequested();
	System.out.println(stopRequested);
	}
	
	private static synchronized boolean stopRequested(){
		stopRequested = true;
		return stopRequested;
	}
	
	private static synchronized boolean isStopped(){
		return stopRequested;
	}

}
