package com.fp.practice;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JavaConcurrencyConcepts {

	public static void main(String[] args) {
		//1 FixedThreadPool example
		//get count of available cores
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		//ExecutorService service2 = Executors.newFixedThreadPool(nThreads:10);
		
		// submit the tasks for execution
		for(int i=0; i<100;i++) {
			service.execute(new CpuIntensiveTask());
			//service.IOIntensiveTask();
		}
		// For a Callable Task we need to use submit method instead of execute method
		Future<Integer> future = service.submit(new Task2());
		
		//Perform some operations for 1 or 2 seconds until Calleble Thread sleeps for 3 seconds
		//After that we can call below method
		//1 sec 
		try {
			Integer result = future.get(); // blocking operation 
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		} 
		
		//2 CachedThreadPool example where a Single Task is held and assgined to a free Thread
		// If no Thread is free then a new Thread is created to run this task
		// Here we use a Synchrous Queue with only 1 Task in it
		//for a lot of short lived tasks
		ExecutorService service3 = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(new Task());
		}
		
		// 3 ScheduledThreadPool example
		// Here we use a Delay Queue as we schedule the ThreadPool to run the tasks based on the 
		// scheduled delay time. 
		int poolSize = 10;		
		ScheduledExecutorService service4 = Executors.newScheduledThreadPool(poolSize);
		
		//Task to run after 10 seconds
		service4.schedule(new Task(), poolSize, TimeUnit.SECONDS);
		
		//Task to run repeatedly every 10 seconds
		int initialDelay = 15;
		service4.scheduleAtFixedRate(new Task(), initialDelay, poolSize, TimeUnit.SECONDS);
		
		//Task to run repeatedly 10 seconds after previous task completes
		initialDelay = 15;
		service4.scheduleWithFixedDelay(new Task(), initialDelay, poolSize, TimeUnit.SECONDS);
		
		for (int i = 0; i < 100; i++) {
			service4.execute(new Task());
		}
		
		// 4 SingleThreadedExecutor - here the PoolSize is only One
		// There is only 1 Thread which is accepting the task and executing it
		// In this case if the Thread is kiled then ThreadPool will recreate the Thread
		// This is used when you want to ensure that Task1 is always run after Task2 
		// and Task2 is always run after Task3
		// We can ensure that the tasks are run sequentially
		
		// RejectedExecutionException 
		int maximumPoolSize = 100, keepAliveTime=120,capacity=300;
		ExecutorService service5 = new ThreadPoolExecutor(poolSize, maximumPoolSize, keepAliveTime, 
				TimeUnit.SECONDS, new ArrayBlockingQueue<>(capacity),
				new CustomRejectionHandler());
		
		try {
			service.execute(new Task());
		} catch(RejectedExecutionException e) {
			System.err.println("task rejected "+ e.getMessage());
		}
		
		//How to shutdown the executor service
		service.isTerminated();
		try {
			service.awaitTermination(poolSize, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		service.shutdown();
		service3.shutdown();
		service4.shutdown();
		service.shutdownNow();
	}
	
	static class CpuIntensiveTask implements Runnable{
		@Override
		public void run() {
			//some CPU intensicve operations
			System.out.println("Thread Name: "+Thread.currentThread().getName());
		}
	}
	
	static class IOIntensiveTask implements Runnable{
		@Override
		public void run() {
			//some CPU intensicve operations
		}
	}
	
	static class Task implements Runnable{
		@Override
		public void run() {
			//some CPU intensicve operations
			System.out.println("Thread Name: "+Thread.currentThread().getName());
		}
	}
	
	static class CustomRejectionHandler implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			//logging operations to perform on rejection
		}
	}
	
	static class Task2 implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			Thread.sleep(3000);
			return 3;
		}
		
	}

}
