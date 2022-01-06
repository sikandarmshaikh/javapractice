package com.interviews.experience;

/**
 * JPMC 4th Round
 * Find minimum meeting rooms needed
 * 
 */
public class Assessment1 {
	
	private static int minMeetingRooms(int[][] meetingTimes) {
		
		int meetingRooms = 0;
		for (int i = 0; i < meetingTimes.length; i++) {
			
			for (int j = 1; j < meetingTimes.length; j++) {
				if(meetingTimes[i][i] == meetingTimes[i][j]) {
					
				}
			}
			
		}
		for(int[] pair: meetingTimes) {
			
			
			
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		int[][] meetingTimes = {{2,8},{3,4},{3,9},{5,11},{8,20},{11,15}};
		// 6 1 6 6 12 4 
		// 24 Hrs 
		System.out.println(minMeetingRooms(meetingTimes));
		
	}
	
}
