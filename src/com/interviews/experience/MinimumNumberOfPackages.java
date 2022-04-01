package com.interviews.experience;

/**
 * This was TestDome question
 * There are large box which can take 5 items and small box which can take 1 item
 * Find the minimum number of boxes needed to store the given items
 * Example 1: items = 16
 * We can have 2 large and 6 small boxes hence the answer is 8
 *
 */
public class MinimumNumberOfPackages {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int remaining=0,total=0;
        if(items%availableLargePackages >=0) {
        	remaining = items-(availableLargePackages*5);
        	if(remaining%availableSmallPackages >= 0) {
        		total= availableLargePackages+remaining;
        	}
        }
        return total;
    }
    
    public static void main(String[] args) {       
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}
