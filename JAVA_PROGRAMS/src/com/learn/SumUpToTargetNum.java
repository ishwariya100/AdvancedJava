package com.learn;

import java.util.HashMap;

public class SumUpToTargetNum {
	
	public static void main(String[] args) {
		
		int arr[] = {1, 5, 8, 10, 32, 9};
		
		int targetNum = 14;
		
		int result[] = findIndicesOfNumbers(arr, targetNum);
		
		if(result != null) {
			System.out.println("The indices are "+ result[0] + " , " + result[1]);
		}
		else
			System.out.println("No numbers add up to the target number");
	}

	private static int[] findIndicesOfNumbers(int[] arr, int targetNum) {
		
		HashMap<Integer, Integer> hashmap = new HashMap<> ();
		
		for(int i = 0; i < arr.length; i++) {
			
			int complement = targetNum - arr[i];
			
			if(hashmap.containsKey(complement)) {
				
			  return new int[] {hashmap.get(complement), i};
			}
	;		
			hashmap.put(arr[i], i);
		}
				
		return null;
	}

}
