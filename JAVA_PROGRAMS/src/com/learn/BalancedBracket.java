package com.learn;

import java.util.Stack;

// Add all opening brackets to stack
//When you encounter closed bracket, pop from stack and see if it matches with the closing version of popped element 
//if stack is empty when you encounter closed bracket, it is unbalanced 
//Finally if stack is empty , its balanced 

public class BalancedBracket {
	
	public static void main(String[] args) {
		
		String s = "[(])";
		
		System.out.println("Brackets are balanced : " + isBalanced(s));
	}

	private static boolean isBalanced(String s) {
		
		Stack<Character> stack = new Stack<> ();
		
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			
			Character currChar = s.charAt(i);
			
			if (currChar == '{' || currChar == '[' || currChar == '(') {
				
				stack.push(s.charAt(i));
			}
			else
			{
				if(stack.empty())
					return false;
				else
				{
					Character top = stack.pop();
					
					//Dont try to add true return case here, because it will fail to check further chars in the string
					if (!((currChar == '}' && top == '{') ||
		                      (currChar == ')' && top == '(') ||
		                      (currChar == ']' && top == '['))) 
					{
		                    return false;
		            }
		         }
			 }
		
		}
		
		return stack.isEmpty();
	}

}
