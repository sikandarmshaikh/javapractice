package com.fp.practice;

public class ThreadUsingImplements implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("ThreadUsingImplements: "+i);
		}
	}

}
