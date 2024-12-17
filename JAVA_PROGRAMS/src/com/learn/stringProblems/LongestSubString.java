package com.learn.stringProblems;

import java.util.HashSet;


//Use sliding window 
// left pointer and right pointer is initially set to 0 
// to see if a character is visited or not , use boolean array .
//boolean array of size 256, because there are 256 characters 
//how to know the index of the array is for this character - > for this the ascii value of character is the index of the boolean array
//for eg : ASCII value of 'A' is 65, so the index 65 is marked false by default and true if already 'A' character is visited in the given string.
//when the encountered character is not visited, mark it as visited now, calculate length, max(maxlen,left-right+1), increment right pointer
//when the encountered character is visited now the window needs to change, so increment the left pointer until it comes the currently
//encountered character position in the string, also while incrementing the left pointer , mark the visited areas as false because
//we need to start a new window 

//Finally because we are using max operation, we will still get the longest substring length 

public class LongestSubString {
	
	public static void main(String[] args) {
		
		String str = "abcabcbb";
		
		int length = getLongestSubStrLen(str);
		
		System.out.println(length);
	}

	private static int getLongestSubStrLen(String str) {
		
		if(str.length() == 0)
			return 0;
		
		if(str.length() == 1)
			return 1;
		
		int leftPtrPos = 0;
		int rightPtrPos = 0;
		int maxLen = 0;
		boolean[] visited = new boolean[256];
		
		while(rightPtrPos < str.length()) {
			
			while(visited[str.charAt(rightPtrPos)]) {
				visited[str.charAt(leftPtrPos)] = false;
				leftPtrPos++;
			}
			
			visited[str.charAt(rightPtrPos)] = true;
			maxLen = Math.max(maxLen, rightPtrPos-leftPtrPos+1);
			rightPtrPos++;
		}
				
		return maxLen;
	}

}
