package com.learn.stringProblems;

import java.util.HashMap;

public class MostRepeatingWordsInSentence {
	
	public static void main(String[] args) {
		String str = "Core Java and Advanced Java";
		System.out.println("Most repeating word in sentence is "+ mostRepeatingWordInSentenceIs(str));
	}

	private static String mostRepeatingWordInSentenceIs(String str) {
		
		String repeatedWord = null;
		int count = 0;
		String[] splitWords = str.split(" ");
		HashMap<String, Integer> hashmap = new HashMap<> ();
		
		for(int i = 0; i < splitWords.length; i++) {
			
			hashmap.put(splitWords[i], hashmap.getOrDefault(splitWords[i], 0)+1);
			
			if(count < hashmap.get(splitWords[i])) {
				repeatedWord = splitWords[i];
				count = hashmap.get(splitWords[i]);
			}
		}
		return repeatedWord;
	}
}
