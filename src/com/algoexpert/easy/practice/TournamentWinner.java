package com.algoexpert.easy.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TournamentWinner {

	public static int HOME_TEAM_WON =1;
	
	/**
	 * O(n) time | O(k) space - where n is the number of competetions 
	 * and k is the number of teams
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
		ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML","C#"));
		ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#","Python"));
		ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python","HTML"));
		competitions.add(competition1);
		competitions.add(competition2);
		competitions.add(competition3);
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0,0,1));
		String expected = "Python";
		
		String winningTeam = TournamentWinner.tournamentWinner(competitions, results);
		System.out.println("Winning Team is "+winningTeam);
	}

	public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		String currentBestTeam = "";
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put(currentBestTeam, 0);
		
		for(int idx =0; idx < competitions.size(); idx++) {
			ArrayList<String> competition = competitions.get(idx);
			int result = results.get(idx);
			
			String homeTeam = competition.get(0);
			String awayTeam = competition.get(1);
			
			String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;
			
			updateScores(winningTeam, 3, scores);
			
			if(scores.get(winningTeam) > scores.get(currentBestTeam)) {
				currentBestTeam = winningTeam;
			}
		}
		return currentBestTeam;
	}

	public static void updateScores(String team, int i, HashMap<String, Integer> scores) {
		if(!scores.containsKey(team)) {
			scores.put(team, 0);
		}
		scores.put(team, scores.get(team)+3);
	}
}
