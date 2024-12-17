package com.learn;

import java.util.HashSet;


//Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
//Output: 6
//Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.


//Input: arr[] = [1, 9, 3, 10, 4, 20, 2]000000000000000000000000000000000000000000000000000010
//Output: 4
//Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.

//Duplicates are ignored 
//The element must be presnt in the array but need not be consecutively present in the array itself 
//we are returning the length of the sequence in the result

// First add all elements to hashSet
//For each element in array , check if downward seq exist in hashSet, remove if exist
//For each element in array, check if upward seq exist in hashSet, remove if exist
//increment count each time if exist and the max of length and count is the result

public class LongestConElementsSeq {

	public static void main(String[] args) {
		
		int arr[] = {100, 4, 200, 1, 3, 2, 4};
		int length = findLengOfLongestConsecutiveSeq(arr);
		System.out.println("Longest length is "+ length);
	}

	private static int findLengOfLongestConsecutiveSeq(int[] arr) {
		
		int length = 0;
		HashSet<Integer> hashset = new HashSet<> ();
		
		for(int element:arr) {
			hashset.add(element);
		}
		
		System.out.println("length of hashset is "+ hashset.size());
		
		for(int num: arr) {
			
			int count = 1;
			
			int downwardSeqNum = num-1;
	        while(hashset.contains(downwardSeqNum)){
	            hashset.remove(downwardSeqNum);
	            downwardSeqNum--;
	            count++;
	        }
	 
	        int upwardSeqNum = num+1;
	        while(hashset.contains(upwardSeqNum)){
	            hashset.remove(upwardSeqNum);
	            upwardSeqNum++;
	            count++;
	        }
	 
			length = Math.max(count, length);
		}
					
		return length;
	}
}
