package com.fp.practice;

public class AthleteClassComparable implements Comparable<AthleteClassComparable> {
	
	String name;
	int score;
	
	public AthleteClassComparable(String name,int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name+" "+score;
	}
	
	@Override
	public int compareTo(AthleteClassComparable a) {
		if(this.score>a.score) {
			return 1;
		}
		if(this.score < a.score) {
			return -1;
		}
		return 0;
	}
	
	
}
