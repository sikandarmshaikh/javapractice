package com.interviews.experience;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * JPMC 4th Round
 * Find minimum meeting rooms needed
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * Constraints:
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 * Example 1:
 * Input: intervals = {{2,8},{3,4},{3,9},{5,11},{8,20},{11,15}}
 * Output: 3
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 * 
 */
public class FindMinimumMeetingRooms {

	public static void main(String[] args) {
		int[][] intervals = {{1,4},{3,4},{4,5}}; 
		System.out.println(findMinMeetingRooms(intervals));
	}

	private static int findMinMeetingRooms(int[][] intervals) {
		// First Sort the Array of intervals as per startTime asc order
		Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
		//Create a PQ to store the endTime which is ending sooner
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		//Now iterate over the Array to find the endTime in PQ which is >= the current interval endTime
		for (int[] range : intervals) {
			if(!pq.isEmpty() && range[0] >= pq.peek()[1]) {
				pq.poll();
			}
			pq.add(range);
		}
		// Return size of PQ
		return pq.size();
	}
	
	/* 
	public static int minMeetingRooms(int[][] intervals) {}
	
	public static void main(String[] args) {
		int[][] meetingTimes = {{7,10},{2,4}};
		System.out.println(minMeetingRooms(meetingTimes));
	}
	
	
	public static void main(String[] args) {
		int[][] intervals = {{7,10},{2,4}};
		System.out.println(findMinMeetingRooms(intervals));
	}

	private static int findMinMeetingRooms(int[][] intervals) {
		// First Sort the Array as per the start time
		Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
		//Now Create a PQ for getting endTime which is less than that of the current interval endTime
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));
		// Now loop through all the intervals one by one and compare the endTime of 
		// the current interval with that of the top endTime in the PQ
		// If endTime of the current interval is equal or greater than that of the Array then 
		// there is no extra Room needed and this interval can accomodate in the existing Room
		// Else we need to add another Room which is like adding in the PQ
		for (int[] range : intervals) { // Iterate over an array or iterable for intervals
			if(!pq.isEmpty() && range[0] >= pq.peek()[1]) { // peek method will just pop and check
				pq.poll(); // poll method will pop up the first element from the PQ
			}
			pq.add(range);
		}
		// Now return the size of the PQ which is the total minimum nor of Rooms that can be allocated
		return pq.size();
	}
	*/
	/*
	
		// Sort the array by start time
		Arrays.sort(intervals, (a,b) -> (a[0] - b[0])); // process in the order of start time
		/* 
		 * Use a Min heap like a Priority Queue to always get the end time of a room which is going to be free soon
		 * Hence the first member in the Priority Queue will always be the one that is free.
		 * If the first one is not free then we dont have any room which free and we need to allocate a new room for the
		 * timings we are searching
		 
		//Ending time to figure out when the room will free up 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1])); 
        
        /* Find whether any end time is there in the queue which is greater 
         * than that of the current meeting end time. If yes then adjust this timing with this room
         * Other wise we need to allocate a new Room for this timing
         */
       /* for (int[] range : intervals) {
            if(!pq.isEmpty() && range[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.add(range);
        }
        return pq.size(); // This size will give the total number of Rooms that are allocated  
	

	*/
}

