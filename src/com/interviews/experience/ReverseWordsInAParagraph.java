package com.interviews.experience;

import java.util.HashMap;
import java.util.Map;

/**
 * Exabeam Pune 2nd Round of Interview
 * 1) Coding Question: 
 * One Sentence can contain words.
 * Read the sentence and reverse each word and print it
 * Input: This is a java program, which is an assigment.
 * Output: sihT  si  a  avaj  margorp,   hcihw  si  na  tnemgissa. 
 * 
 * 2) System Design Question:
 * There is a TODO List of items which can be accessed from either Mobile app or Laptop
 * Whenever anyone is changing something to this TODO List then it should be synchronous
 * which means it should show the change simultaneously in both mobile & Laptop apps
 * Do the System Design for this by either storing it in a DB and also Scale it for 
 * millions of Customers
 * 
 */
public class ReverseWordsInAParagraph {
	
	public static void main(String[] args) {
		String input = "This is a java program, which is an assigment.";
		reverseSentence(input);
	}

	private static void reverseSentence(String input) {
		char[] chars = input.toCharArray();
		Map<String, String> map = new HashMap<>();
		StringBuffer s = new StringBuffer();
		
		String[] s1 = input.split("[ ][,][.]");
		for (String c2 : s1) {
			System.out.println("Input Sentence "+c2);
			System.out.print("Output Sentence: ");
		}
		
		Character c1 = null;
		for (Character character : chars) {
			
			if(!(character.equals(' ') || character.equals(',') || character.equals('.'))) {
				s.append(character);	
			} else {
				System.out.print(" "+s.reverse().append(character));
				s = new StringBuffer("");
			}
		}
	}
}
