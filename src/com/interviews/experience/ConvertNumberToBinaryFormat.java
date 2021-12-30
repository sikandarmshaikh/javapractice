package com.interviews.experience;

/**
 * 
 * Convert a Number to its Binary representation
 * Examples: 
 * 256->null
 * 13->1101
 * 152->10011000
 * 
 */
public class ConvertNumberToBinaryFormat {
	
	public static void main(String[] args) {
		System.out.println(convertToBinary(new Integer(256)));
	}
	
	public static String convertToBinary(Integer number) {
		if(number==null || number<0 || number>255) {
			return null;
		} else if(number ==0) {
			return "0";
		}
		Integer remaining = number;
		Integer mod;
		String result = "";
		while(remaining>0) {
			mod = remaining%2; result = mod+result; remaining = remaining/2;
		}
		return result;
	}
}
