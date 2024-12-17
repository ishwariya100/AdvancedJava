package com.learn;

//slowPointer moves only when elements are not equal 
//copy the value of the fastpointer loc to slowpointer loc, when they are not equal 
//fastPointer moves by one always
//slowPointer + 1 will be the point till where unique elements are present

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 2, 3, 4, 7, 8, 8, 9, 10, 11, 12, 12};
		
		int slowPointer = 0;
		
		for(int fastPointer = 1; fastPointer < arr.length; fastPointer++) {
			
			if(arr[slowPointer] != arr[fastPointer]) {
				slowPointer++;
				arr[slowPointer] = arr[fastPointer];
			}
		}
		
		System.out.println("Number of elements with out duplicates is "+ (slowPointer+1));
		
		for(int i = 0; i < (slowPointer+1) ; i++) {
			System.out.println(arr[i]);
		}
	}
}
