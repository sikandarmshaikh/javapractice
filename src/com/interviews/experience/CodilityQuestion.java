package com.interviews.experience;

/**
 * A central sphere of radius R is the set of all points(x, y, z) in 3D space
 * that satisfy the following. Equation: x^2+y^2+z^2 = R^2
 * We say that a set of central spheres covers a set of points if each of the points belongs to one of the spheres.
 * Assume that the following declartions are given.
 * struct Point3D {
 * int x;
 * int y;
 * int z;
 * };
 * 
 * write a function: 
 * int solution (struct Point3D A[], int N);
 * that, given an array describing of a set of points in 3D space, returns the minimum number of central spheres required to cover them.
 * 
 * For example, given the following array.
 * A[0].x = 0 A[0].y = 5 A[0].z = 4
 * A[1].x = 0 A[1].y = 0 A[1].z = -3
 * A[2].x = -2 A[2].y = 1 A[2].z = -6
 * A[3].x = 1 A[3].y = -2 A[3].z = 2
 * A[4].x = 1 A[4].y = 1 A[4].z = 1
 * A[5].x = 4 A[5].y = -4 A[5].z = 3
 * 
 * The function should return 3, because three central spheres are required to cover these points:
 * a central sphere of radius sqrt(3) covers array element A[4],
 * a central sphere of radius 3 covers array elements A[1] and A[3],
 * a central sphere of radius sqrt(41) covers array elements A[0], A[2] and A[5].
 * 
 * It is impossibel to cover these points with fewer central spheres.
 * Write an efficient algorithm for the following assumptions:
 * N is a integer with in the range [0 ... 100,000];
 * the coordinates of each point in array A are integers within the range[-10,000 ... 10, 000].
 * 
 * https://leetcode.com/discuss/interview-question/723125/amazon-online-assessment-question#:~:text=A%20central%20sphere%20of%20radius,space%20that%20satisfy%20the%20following.&text=We%20say%20that%20a%20set,the%20following%20declartions%20are%20given.
 * 
 * 
 */
public class CodilityQuestion {

	public static void main(String[] args) {

	}
	
	/*public int solution(Point3D[] A) {

		int count = 0;
		Map<Integer, Integer> centSphe = new HashMap<>();
		int radius = 0;
		for (int i = 0; i < A.length; i++) {
			radius = (int) (Math.pow(A[i].z, 2) + Math.pow(A[i].y, 2) + Math.pow(A[i].x, 2));
			if (!centSphe.containsKey(radius))
				centSphe.put(radius, i);
		}

		return centSphe.size();

	}*/

}
