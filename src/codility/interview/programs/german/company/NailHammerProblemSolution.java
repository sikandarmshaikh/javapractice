package codility.interview.programs.german.company;

import com.leetcode.exercises.A;

/**
 *
 * There are N nails hammered into the same block of wood. Each nail sticks out
 * of the wood at some length. You can choose at most k nails and hammer them
 * down to any length between their original lengths and 0. Nails cannot be
 * pulled up. The goal is to have as many nails of the same length as possible.
 * You are given an implementation of a function: function solution(A, K);
 * which, given an array A of N integers representing lengths of the nails
 * sorted in a non-decreasing order and an integer K, returns the maximal number
 * of nails that can be positioned at the same length after hammering down at
 * most k nails. For example, given K = 2 and array A = [1,1,3,3,3,4,5,5,5,5)
 * the function should return 5. One of the possibilities is to hammer the nails
 * represented by A[8] and A[9] down to length 3. 5 4 III 3 2 III 4 4 3 2 1 0 1
 * 2 3 4 5 6 7 8 9 The attached code is still incorrect for some inputs. Despite
 * the error(s), the code may produce a correct answer for the example test
 * cases. The goal of the exercise is to find and fix the bug(s) in the
 * implementation. You can modify at most four lines. Assume that: • Nis an
 * integer within the range [1..10,000); Kis an integer within the range [0..N]:
 * • each element of array A is an integer within the range [1..1,000,000,000);
 * array A is sorted in non-decreasing order. In your solution, focus on
 * correctness. The performance of your solution will not be the focus of the
 * assessment. 4 4 3 2 1 0 1 2 3 4 5 6 7 8 9 The attached code is still
 * incorrect for some inputs. Despite the error(s), the code may produce a
 * correct answer for the example test cases. The goal of the exercise is to
 * find and fix the bug(s) in the implementation. You can modify at most four
 * lines. Assume that: • Nis an integer within the range [1..10,000); Kis an
 * integer within the range [0..N]: • each element of array A is an integer
 * within the range [1..1,000,000,000); array A is sorted in non-decreasing
 * order. In your solution, focus on correctness. The performance of your
 * solution will not be the focus of the assessment. solution.js x 1" function
 * solution(A, K) { 2 var n= A.length; 3 var best = 0; 4 var count = 1; for (var
 * 1 @; 1 <n - K - 1; 1++) { if (A[1] A[1 + 1]) 7 count = count + 1; else 9
 * count - @; 10 if (count > best) 11 best - count; 12 || 13 var result - best 1
 * K; 14 15 return result; 16) .17
 *
 */
public class NailHammerProblemSolution {

	public static int solution(int[] A, int K) {
		int n = A.length;
		int best = 0;
		int count = 1;
		for (int i = 0; i < n - K - 1; i++) {
			if (A[i] == A[i + 1])
				count = count + 1;
			else
				count = 1;
			if (count > best)
				best = count;
		}

		int result = Math.max(best + K, Math.min(K + 1, n));

		return result;
	}
	
	public static void main(String[] args) {
		int [] A = {1,1,3,3,3,4,5,5,5,5};
		int K = 2;
		int result = solution(A, K);
		System.out.println("The number of nails that can be hammared are "+result);
	}
}
