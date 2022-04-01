package com.fp.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMainClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadUsingExtends te = new ThreadUsingExtends();
		te.start();
		
		ThreadUsingImplements ti = new ThreadUsingImplements();
		Thread t1 = new Thread(ti);
		t1.start();
		
		//ExecutorService example
		// Creates an Executor that uses a single worker thread operating off an
		// unbounded queue.
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		executorService1.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("From ExecutorService");
			}
		});
		
		System.out.println("End of Main");
		
		// Creates a thread pool that reuses a fixed number of threads
		// operating off a shared unbounded queue. At any point, the parameter
		// specifies the most threads that will be active processing tasks.
		ExecutorService executorService2 = Executors.newFixedThreadPool(10);
		
		// Creates a thread pool that can schedule commands to run after a
		// given delay, or to execute periodically.
		ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
		
		//Using Future to check whether the ExecutorService has run successfully
		Future future =  executorService1.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("From executorService1");
			}
		});
		
		future.get(); // returns null if the task has completed successfully
		
		//Callable interface
		
		Future future2 =  executorService1.submit(new Callable() {

			@Override
			public Object call() throws Exception {
				return "RESULT";
			}
		});
		
		System.out.println(future2.get());
		
		executorService1.shutdown();
		executorService2.shutdown();
		executorService3.shutdown();
		
		
		
	}

}
