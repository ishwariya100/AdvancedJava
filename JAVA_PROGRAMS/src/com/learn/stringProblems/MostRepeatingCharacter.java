package com.learn.stringProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


//While inserting to hashmap , also update count to have max value seen so far and update answer to store the character
public class MostRepeatingCharacter {
	
	public static void main(String[] args) {
		String str = "geeks";
		System.out.println("Most repeating character is "+ findMostRepeatingChar(str));
		numberOfTimesEachCharIsRepeated(str);
	}

	private static void numberOfTimesEachCharIsRepeated(String str) {
		
		HashMap<Character, Integer> hashmap = new HashMap<> ();
		
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			hashmap.put(c, hashmap.getOrDefault(c, 0)+1);
		}
		
		for(char c: hashmap.keySet()) {
			System.out.println(c + " : " + hashmap.get(c));
		}
		
		System.out.println("***********");
		
		Stream<Map.Entry<Character, Integer>> sortedMap = hashmap.entrySet().stream().sorted(Map.Entry.comparingByValue());
		
		sortedMap.forEach(sortedEntry -> System.out.println(sortedEntry.getKey() + " : " + sortedEntry.getValue()));
	}

	private static Character findMostRepeatingChar(String str) {
		
		char answer = 0;
		int count = 0;
		
		HashMap<Character, Integer> hashmap = new HashMap<> ();
		
		for(int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			hashmap.put(c, hashmap.getOrDefault(c, 0)+1);
			
			if(count < hashmap.get(c)) {
				count = hashmap.get(c);
				answer = c;
			}
		}
		
		return answer;
	}

}
