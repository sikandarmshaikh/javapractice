package com.interviews.experience;

import java.util.Scanner;

/**
 * 
 * Queue implementation using an Array 
 *
 */
public class QueueDemo   
{  
  private int maxSize;  
  private int[] queueArray;  
  private int front;  
  private int rear;  
  private int currentSize;  
  
  public QueueDemo(int size)  
  {  
    this.maxSize = size;  
    this.queueArray = new int[size];  
    front = 0;  
    rear = -1;  
    currentSize = 0;  
  }  
  
  /**
   * Add items in the Queue
   * @param item
   */
  public void add(int item)  
  {  
    /**
     * Check if Queue is Full 
     */
    if(isQueueFull())  
    {  
      System.out.println("Queue is full!");  
      return;  
    }  
    if(rear == maxSize - 1)  
{  
      rear = -1;  
    }  
   
    queueArray[++rear] = item;  
    currentSize++;  
    System.out.println("Item added to queue: " + item);  
  } 
  
  /**
   * Delete operation of the Queue  
   * @return
   */
  public int delete()  
  {  
    /**
     * Check is Queue is empty
     */
    if(isQueueEmpty())  
    {  
      throw new RuntimeException("Queue is empty");  
    }  
    
    int temp = queueArray[front++];  
    if(front == maxSize)  
    {  
      front = 0;  
    }  
    currentSize--;  
    return temp;  
  }  
  
  /**
   * Check Peek element in the Queue      
   * @return
   */
  public int peek()  
  {  
    return queueArray[front];  
  }  
  
  /**
   * Check is the Queue is Full    
   * @return
   */
  public boolean isQueueFull()  
  {  
    return (maxSize == currentSize);  
  } 
  
  /**
   * Check is Queue is Empty   
   * @return
   */
  public boolean isQueueEmpty()  
{  
    return (currentSize == 0);  
  }  
  
  public static void main(String[] args)   
  {  
	QueueDemo queue = new QueueDemo(10);  
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter 5 elements to add in the Queue");
	int input1 = scan.nextInt();
	int input2 = scan.nextInt();
	int input3 = scan.nextInt();
	int input4 = scan.nextInt();
	int input5 = scan.nextInt();
      
    queue.add(input1);  
    queue.add(input2);
    queue.add(input3);
    queue.add(input4);
    queue.add(input5);
    
    System.out.println("Enter number of Items to delete from the in Queue: ");
    int input6 = scan.nextInt();
    scan.close();
	
    for (int i = 0; i < input6; i++) {
    	System.out.println("Item removed from queue is: " + queue.delete());
	}
    
  }  
}  

