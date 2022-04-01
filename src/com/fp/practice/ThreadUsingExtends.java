package com.fp.practice;

public class ThreadUsingExtends extends Thread {
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("ThreadUsingExtends: "+i);
		}
	}
}
