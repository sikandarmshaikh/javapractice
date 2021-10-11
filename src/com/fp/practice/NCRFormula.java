package com.fp.practice;

import java.util.Iterator;

/*
 * implement nCr formula for given N and K
 * nCr = (n!) / (r! * (n-r)!)
 * Output: for (n=5 and r=3) -> 5C3 is 10
 * 
 * Additional: The nPr formula is, P(n, r) = n! / (n−r)!.
 */
public class NCRFormula {

	public static void main(String[] args) {
		
		int n = 5, r = 3;
		System.out.println(nCr(n,r));
	}

	public static int nCr(int n, int r) {
		return (fact(n))/(fact(r)*fact(n-r));
	}

	public static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res = res*i;
		}
		return res;
	}

}
