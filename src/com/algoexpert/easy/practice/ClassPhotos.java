package com.algoexpert.easy.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Input: redShirtHeights = {5,8,1,3,4}, blueShirtHeights = {6,9,2,4,5}
 * Output: The Class Photo can be taken : true
 * Input: redShirtHeights = {6, 9, 2, 4, 5, 1}, blueShirtHeights = {5, 8, 1, 3, 4, 9}
 * Output: The Class Photo can be taken : false
 * 
 */
public class ClassPhotos {

	public static void main(String[] args) {
		List<Integer> redShirtHeights = Arrays.asList(6, 9, 2, 4, 5, 1);
		List<Integer> blueShirtHeights = Arrays.asList(5, 8, 1, 3, 4, 9);
		
		Boolean result = classPhotos(blueShirtHeights,redShirtHeights);
		
		System.out.println("The Class Photo can be taken : " + result);
		
	}

	private static Boolean classPhotos(List<Integer> blueShirtHeights, List<Integer> redShirtHeights) {
		
		Collections.sort(blueShirtHeights, Collections.reverseOrder());
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		
		String shirtColorInFirstRow = (redShirtHeights.get(0) < blueShirtHeights.get(0)) ? "RED" : "BLUE";
		for (int i = 0; i < redShirtHeights.size(); i++) {
			int redShirtHeight = redShirtHeights.get(i);
			int blueShirtHeight = blueShirtHeights.get(i);
			
			if (shirtColorInFirstRow == "RED") {
				if (redShirtHeight >= blueShirtHeight) {
					return false;
				}
			} else {
				if (blueShirtHeight >= redShirtHeight) {
					return false;
				}
			}

		}
		return true;
	}
}
