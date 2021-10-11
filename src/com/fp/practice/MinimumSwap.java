package com.fp.practice;

import java.util.ArrayList;
import java.util.List;
/*
 * Given an array of 0 and 1, find minimum no. of swaps to bring all 1s together (only adjacent swaps allowed)
 * Output: 1
 * https://stackoverflow.com/questions/38748760/given-an-array-of-0-and-1-find-minimum-no-of-swaps-to-bring-all-1s-together-o
 */
public class MinimumSwap {
//function to find consecutive number index
	public static int[] getMaxConsecutiveIndex(List<Integer> array) {
		int desiredIndex = -1;
		int count = 0;
		int dupDesiredIndex = -1;
		int dupCount = 0;

		int i = 0;
		while (i < array.size()) {
			if (array.get(i) == 0) {
				// pass duplcateIndex value to desiredIndex if count is more
				if (dupCount > count) {
					desiredIndex = dupDesiredIndex;
					count = dupCount;
				}
				dupDesiredIndex = -1;
				dupCount = 0;
			} else {
				if (dupDesiredIndex == -1) {
					dupDesiredIndex = i;
					dupCount = 1;
				} else {
					dupCount++;
				}
			}
			i++;
		}
		return new int[] { desiredIndex, count };
	}

	public static int swapCount(List<Integer> array, int startIndex, int endIndex, boolean side) {
		// side == false means 0 at the left
		// side == true means 1 at the left
		System.out.println("startIndex  " + startIndex + "  endIndex  " + endIndex + " side " + side);
		int swapCount = 0;
		if (side == false) {
			while (startIndex <= endIndex) {
				if (array.get(endIndex) == 0) // swap from the end only if it is 0
				{
					// check for first 1 from left to swap
					while (array.get(startIndex) == 0 && (startIndex != endIndex))
						startIndex++;

					if (array.get(startIndex) == 1) {
						// now swap
						int temp = array.get(startIndex);
						array.set(startIndex, array.get(endIndex));
						array.set(endIndex, temp);
						swapCount++;
						endIndex--;
					}
				}
				endIndex--;
			}
		} else {
			while (startIndex <= endIndex) {
				if (array.get(startIndex) == 0) // swap from the starting only if it is 0
				{
					// check for first 1 from right to swap
					while (array.get(endIndex) == 0 && (startIndex != endIndex))
						endIndex--;
					if (array.get(endIndex) == 1) {
						// now swap
						int temp = array.get(startIndex);
						array.set(startIndex, array.get(endIndex));
						array.set(endIndex, temp);
						swapCount++;
						startIndex++;
					}
				}
				startIndex++;
			}
		}
		return swapCount;
	}

	public static void main(String... strings) {
		List<Integer> arr = new ArrayList<Integer>();
		int temp[] = { 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 };
		// int temp[] = {1,0,0,1,1,0,1};
		for (int i = 0; i < temp.length; i++)
			arr.add(temp[i]);

		int centerIndex = getMaxConsecutiveIndex(arr)[0];
		int consequtivecount = getMaxConsecutiveIndex(arr)[1];
		System.out.println("centerIndex " + centerIndex + "  consequtivecount " + consequtivecount);
		int swapCountLeft = swapCount(arr, 0, centerIndex - 1, false);
		int swapCountRight = swapCount(arr, centerIndex + consequtivecount, arr.size() - 1, true);
		System.out.println("total swap count " + swapCountLeft + " :: " + swapCountRight);
		System.out.println("array after swapping " + arr);
	}
}
