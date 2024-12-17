package com.learn.KadanceAlgorithm;

//kadane's algorithm
//Example 1:

//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//Example 2:

//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
//Example 3:

//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

// Sub arrays - continuous elements from arraypicked to form sub array

// For each element, calculate the sum of subarray including that element 
// compare the current element and subarray(subaaray including that element) sum
//Max of that element is taken 

// when the current element is greater than the subarray sum including that element,
//then it means the subarray without those current element are mostly negative 
// so it makes sense to start a new sub array with the current element if 
// current element is greater than the subarray sum including the current element 

//if curr element is lessthan the the subaaray sum, then we are actually extending the curr subarray with that element for next calculation
public class MaxSumSubArray {
	
	public static void main(String[] args) {
		
		int arr[] = {2, -1, -3, 4, -1, 2, 1, -5, 4};
		
		int result = findMaxSumSubArr(arr);
		
		System.out.println("Maximum sum is "+ result);
	}

	private static int findMaxSumSubArr(int[] arr) {
	
		int result = arr[0];
		int maxEnding = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			
			maxEnding = Math.max(maxEnding+arr[i], arr[i]);
			
			result = Math.max(maxEnding, result);
		}
			return result;
	}

}
