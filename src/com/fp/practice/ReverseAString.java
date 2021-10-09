package com.fp.practice;

public class ReverseAString {

	public static void main(String[] args) {
		String sample = "Java is Awesome";
		char[] charArray = sample.toCharArray();
		String reverseSample = new String();
		System.out.println(sample);
		for (int i = charArray.length-1; i >= 0; i--) {
			reverseSample = reverseSample+charArray[i];
		}
		
		System.out.println(reverseSample);
	}

}
