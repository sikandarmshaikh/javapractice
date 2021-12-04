package com.interviews.experience;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *  1st round of Interview
 * Parse a huge file with millions of records, each record is a comma separate string of non-negative floating point values, 
 * we need to remove duplicates and move all zeroes in the string to the end of the line while keeping the rest of the order of the values same 
 * and then store these values in a datastore. System can be used by multiple users at once, and they can upload multiple files everyday. 
 * We need to minimise total time it takes to process a single file and provide the user capability to search for specific values across all 
 * processed data uploaded by the user.
 * Sample row in input csv: 1.0,1.1,2.1,0.0,3.1,2.0,2.1
 * Sample row in output: 1.0,1.1,2.1,3.1,2.0,0.0
 * 
 */
public class FileRecordProcessingProgram {

	public static void main(String[] args) {

		// FileInputStream fs = new FileInputStream(new File(""));
		// float[] input = {1.0,1.1,2.1,0.0,3.1,2.0,2.1};
		List<Float> input = new ArrayList<Float>();
		input.add((float) 1.0);
		input.add((float) 1.1);
		input.add((float) 2.1);
		input.add((float) 0.0);
		input.add((float) 3.1);
		input.add((float) 2.0);
		input.add((float) 2.1);

		parseRecords(input);

	}

	public static void parseRecords(List<Float> input) {

		// Removed duplicates
		Set<Float> output = new LinkedHashSet<>();
		output.addAll(input);

		// Put all zeros in a SubArray
		List<Float> subArrayOfZeros = new ArrayList<Float>();

		for (Iterator iterator = output.iterator(); iterator.hasNext();) {
			Float float1 = (Float) iterator.next();
			if (float1 == 0.0) {
				// Add all zeros in a SubArray
				subArrayOfZeros.add(float1);
				// Remove it from main Array
				iterator.remove();
			}
		}

		output.addAll(subArrayOfZeros);

		for (Iterator iterator = output.iterator(); iterator.hasNext();) {
			Float float1 = (Float) iterator.next();
			System.out.println(float1);
		}
	}

}

